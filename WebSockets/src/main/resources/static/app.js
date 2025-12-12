class LiveChat {
    constructor() {
        this.stompClient = null;
        this.username = null;
        this.sessionId = null;
        this.connectedUsers = new Set();

        this.initializeElements();
        this.bindEvents();
        this.setupSockJS();
    }

    initializeElements() {
        // Elementos del DOM
        this.loginModal = document.getElementById('loginModal');
        this.chatContainer = document.getElementById('chatContainer');
        this.usernameInput = document.getElementById('username');
        this.joinBtn = document.getElementById('joinBtn');
        this.currentUser = document.getElementById('currentUser');
        this.messages = document.getElementById('messages');
        this.messageInput = document.getElementById('messageInput');
        this.sendBtn = document.getElementById('sendBtn');
        this.usersList = document.getElementById('usersList');
        this.userCount = document.getElementById('userCount');
        this.usersToggle = document.getElementById('usersToggle');
        this.usersPanel = document.getElementById('usersPanel');
        this.disconnectBtn = document.getElementById('disconnectBtn');
        this.notification = document.getElementById('notification');
        this.emojiBtn = document.getElementById('emojiBtn');
    }

    bindEvents() {
        // Unirse al chat
        this.joinBtn.addEventListener('click', () => this.joinChat());
        this.usernameInput.addEventListener('keypress', (e) => {
            if (e.key === 'Enter') this.joinChat();
        });

        // Enviar mensajes
        this.sendBtn.addEventListener('click', () => this.sendMessage());
        this.messageInput.addEventListener('keypress', (e) => {
            if (e.key === 'Enter' && !e.shiftKey) {
                e.preventDefault();
                this.sendMessage();
            }
        });

        // Toggle panel de usuarios
        this.usersToggle.addEventListener('click', () => {
            this.usersPanel.classList.toggle('show');
        });

        // Desconectar
        this.disconnectBtn.addEventListener('click', () => this.disconnect());

        // Emojis
        this.emojiBtn.addEventListener('click', () => this.showEmojiPicker());
    }

    setupSockJS() {
        const socket = new SockJS('/websocket-server');
        this.stompClient = Stomp.over(socket);

        this.stompClient.debug = null; // Desactivar logs en consola

        socket.onclose = () => {
            this.showNotification('Conexión perdida. Intentando reconectar...', 'warning');
            setTimeout(() => this.setupSockJS(), 3000);
        };
    }

    joinChat() {
        this.username = this.usernameInput.value.trim();

        if (!this.username) {
            this.showNotification('Por favor ingresa un nombre de usuario', 'error');
            this.usernameInput.focus();
            return;
        }

        if (this.username.length > 20) {
            this.showNotification('El nombre no puede tener más de 20 caracteres', 'error');
            return;
        }

        this.stompClient.connect({}, (frame) => {
            console.log('Conectado: ' + frame);

            // Obtener session ID del frame
            const sessionId = frame.headers['user-name'];
            this.sessionId = sessionId;

            // Mostrar chat
            this.loginModal.style.display = 'none';
            this.chatContainer.style.display = 'flex';
            this.currentUser.textContent = this.username;

            // Habilitar input
            this.messageInput.disabled = false;
            this.sendBtn.disabled = false;
            this.messageInput.focus();

            // Suscribirse a los topics
            this.subscribeToTopics();

            // Enviar mensaje de unión
            this.sendJoinMessage();

            this.showNotification('Conectado al chat', 'success');
        }, (error) => {
            console.error('Error de conexión:', error);
            this.showNotification('Error al conectar con el servidor', 'error');
        });
    }

    subscribeToTopics() {
        // Suscribirse a mensajes
        this.stompClient.subscribe('/topic/responses', (message) => {
            const chatMessage = JSON.parse(message.body);
            this.displayMessage(chatMessage);
        });

        // Suscribirse a actualizaciones de usuarios
        this.stompClient.subscribe('/topic/users', (message) => {
            const userMessage = JSON.parse(message.body);
            this.updateUsersList(userMessage.content);
        });
    }

    sendJoinMessage() {
        const joinMessage = {
            username: this.username
        };

        this.stompClient.send("/app/chat.join", {}, JSON.stringify(joinMessage));
    }

    sendMessage() {
        const message = this.messageInput.value.trim();

        if (!message) {
            return;
        }

        const chatMessage = {
            username: this.username,
            content: message
        };

        this.stompClient.send("/app/chat", {}, JSON.stringify(chatMessage));

        // Limpiar input
        this.messageInput.value = '';
        this.messageInput.focus();
    }

    displayMessage(message) {
        const messageElement = document.createElement('div');
        messageElement.className = 'message';

        const isSystem = !message.username || message.username === 'System';
        const isSent = message.username === this.username;

        if (isSystem) {
            messageElement.classList.add('system');
            messageElement.innerHTML = `
                <div class="message-content">${message.content}</div>
                <div class="message-time">${this.getCurrentTime()}</div>
            `;
        } else {
            messageElement.classList.add(isSent ? 'sent' : 'received');

            // Crear avatar con iniciales
            const initials = message.username.charAt(0).toUpperCase();

            messageElement.innerHTML = `
                <div class="message-header">
                    <div class="message-avatar" title="${message.username}">${initials}</div>
                    <span class="message-username">${message.username}</span>
                    <span class="message-time">${this.getCurrentTime()}</span>
                </div>
                <div class="message-content">${this.escapeHtml(message.content)}</div>
            `;
        }

        this.messages.appendChild(messageElement);
        this.messages.scrollTop = this.messages.scrollHeight;
    }

    updateUsersList(usersString) {
        const users = usersString.split(',');
        this.connectedUsers = new Set(users.filter(user => user));

        // Actualizar contador
        this.userCount.textContent = this.connectedUsers.size;

        // Actualizar lista
        this.usersList.innerHTML = '';

        this.connectedUsers.forEach(user => {
            const userElement = document.createElement('div');
            userElement.className = 'user-item';

            const initials = user.charAt(0).toUpperCase();

            userElement.innerHTML = `
                <div class="user-avatar" title="${user}">${initials}</div>
                <div class="user-info">
                    <div class="user-name">${user}</div>
                </div>
            `;

            this.usersList.appendChild(userElement);
        });
    }

    disconnect() {
        if (this.stompClient && this.stompClient.connected) {
            this.stompClient.disconnect(() => {
                this.showNotification('Desconectado del chat', 'info');
            });
        }

        // Resetear estado
        this.connectedUsers.clear();
        this.usersList.innerHTML = '';
        this.userCount.textContent = '0';
        this.messages.innerHTML = '';
        this.usernameInput.value = '';

        // Mostrar modal de inicio
        this.chatContainer.style.display = 'none';
        this.loginModal.style.display = 'flex';
    }

    showEmojiPicker() {
        const emojis = ['😀', '😂', '😍', '😎', '🤔', '👍', '👋', '🎉', '🔥', '❤️'];

        if (document.getElementById('emojiPicker')) {
            document.getElementById('emojiPicker').remove();
            return;
        }

        const picker = document.createElement('div');
        picker.id = 'emojiPicker';
        picker.style.cssText = `
            position: absolute;
            bottom: 70px;
            right: 20px;
            background: white;
            border: 1px solid #ddd;
            border-radius: 10px;
            padding: 10px;
            display: grid;
            grid-template-columns: repeat(5, 1fr);
            gap: 5px;
            box-shadow: 0 5px 15px rgba(0,0,0,0.1);
            z-index: 100;
        `;

        emojis.forEach(emoji => {
            const btn = document.createElement('button');
            btn.textContent = emoji;
            btn.style.cssText = `
                width: 35px;
                height: 35px;
                border: none;
                background: none;
                font-size: 1.2rem;
                cursor: pointer;
                border-radius: 5px;
                transition: background 0.2s;
            `;
            btn.addEventListener('click', () => {
                this.messageInput.value += emoji;
                this.messageInput.focus();
                picker.remove();
            });
            btn.addEventListener('mouseover', () => {
                btn.style.background = '#f0f0f0';
            });
            btn.addEventListener('mouseout', () => {
                btn.style.background = 'none';
            });
            picker.appendChild(btn);
        });

        this.chatContainer.appendChild(picker);

        // Cerrar al hacer clic fuera
        setTimeout(() => {
            const closePicker = (e) => {
                if (!picker.contains(e.target) && e.target !== this.emojiBtn) {
                    picker.remove();
                    document.removeEventListener('click', closePicker);
                }
            };
            document.addEventListener('click', closePicker);
        }, 0);
    }

    showNotification(message, type = 'info') {
        this.notification.textContent = message;
        this.notification.className = 'notification show';

        // Estilos según tipo
        const styles = {
            success: 'linear-gradient(135deg, #4CAF50 0%, #2E7D32 100%)',
            error: 'linear-gradient(135deg, #ff4757 0%, #c23616 100%)',
            warning: 'linear-gradient(135deg, #ffa502 0%, #e84118 100%)',
            info: 'linear-gradient(135deg, #667eea 0%, #764ba2 100%)'
        };

        this.notification.style.background = styles[type] || styles.info;

        // Ocultar después de 3 segundos
        setTimeout(() => {
            this.notification.classList.remove('show');
        }, 3000);
    }

    getCurrentTime() {
        const now = new Date();
        return `${now.getHours().toString().padStart(2, '0')}:${now.getMinutes().toString().padStart(2, '0')}`;
    }

    escapeHtml(text) {
        const div = document.createElement('div');
        div.textContent = text;
        return div.innerHTML;
    }
}

// Inicializar chat cuando el DOM esté listo
document.addEventListener('DOMContentLoaded', () => {
    const chat = new LiveChat();
    window.chat = chat; // Para acceso desde consola si es necesario
});