// chat-simple.js - Versión simplificada
class SimpleChat {
    constructor() {
        this.stompClient = null;
        this.username = null;
        this.connected = false;

        this.init();
    }

    init() {
        this.elements = {
            loginContainer: document.getElementById('loginContainer'),
            chatContainer: document.getElementById('chatContainer'),
            usernameInput: document.getElementById('username'),
            joinButton: document.getElementById('joinBtn'),
            messageInput: document.getElementById('messageInput'),
            sendButton: document.getElementById('sendBtn'),
            messagesContainer: document.getElementById('messagesContainer'),
            userList: document.getElementById('userList')
        };

        this.setupEvents();
    }

    setupEvents() {
        this.elements.joinButton.addEventListener('click', () => this.join());
        this.elements.usernameInput.addEventListener('keypress', (e) => {
            if (e.key === 'Enter') this.join();
        });

        this.elements.sendButton.addEventListener('click', () => this.send());
        this.elements.messageInput.addEventListener('keypress', (e) => {
            if (e.key === 'Enter') {
                e.preventDefault();
                this.send();
            }
        });
    }

    join() {
        const username = this.elements.usernameInput.value.trim();
        if (!username) {
            alert('Ingresa un nombre de usuario');
            return;
        }

        this.username = username;
        this.connect();
    }

    connect() {
        const socket = new SockJS('http://localhost:8083/websocket-server');
        this.stompClient = Stomp.over(socket);

        this.stompClient.connect({}, (frame) => {
            this.connected = true;
            this.showChat();

            // Enviar mensaje de unión
            this.stompClient.send("/app/join", {}, JSON.stringify({
                username: this.username
            }));

            // Suscribirse
            this.stompClient.subscribe('/topic/responses', (message) => {
                try {
                    const msg = JSON.parse(message.body);
                    this.addMessage(msg.username, msg.content);
                } catch (e) {
                    console.error('Error:', e);
                }
            });

            this.stompClient.subscribe('/topic/users', (message) => {
                try {
                    const msg = JSON.parse(message.body);
                    this.updateUsers(msg.content || msg.username || '');
                } catch (e) {
                    console.error('Error usuarios:', e);
                }
            });

        }, (error) => {
            console.error('Error de conexión:', error);
            alert('Error al conectar');
        });
    }

    showChat() {
        this.elements.loginContainer.style.display = 'none';
        this.elements.chatContainer.style.display = 'block';
        this.elements.messageInput.disabled = false;
        this.elements.sendButton.disabled = false;
        this.elements.messageInput.focus();
    }

    send() {
        const text = this.elements.messageInput.value.trim();
        if (!text) return;

        this.stompClient.send("/app/chat", {}, JSON.stringify({
            username: this.username,
            content: text
        }));

        this.elements.messageInput.value = '';
    }

    addMessage(username, content) {
        const div = document.createElement('div');
        div.className = 'message';

        if (content.includes('joined') || username === 'System') {
            div.className += ' system-message';
            div.innerHTML = `<div class="message-content">${content}</div>`;
        } else {
            const isMe = username === this.username;
            div.className += isMe ? ' my-message' : ' other-message';
            div.innerHTML = `
                <div class="message-header">
                    <span class="message-sender">${username}</span>
                    <span class="message-time">${new Date().toLocaleTimeString([], {hour: '2-digit', minute:'2-digit'})}</span>
                </div>
                <div class="message-content">${content}</div>
            `;
        }

        this.elements.messagesContainer.appendChild(div);
        this.elements.messagesContainer.scrollTop = this.elements.messagesContainer.scrollHeight;
    }

    updateUsers(usersString) {
        if (!usersString) return;

        const users = usersString.split(',').map(u => u.trim()).filter(u => u);
        this.elements.userList.innerHTML = '';

        users.forEach(user => {
            const div = document.createElement('div');
            div.className = 'user-item';
            div.innerHTML = `
                <i class="fas fa-user-circle"></i>
                <span class="user-name">${user}</span>
                ${user === this.username ? '<i class="fas fa-user" style="margin-left: auto; color: #667eea;"></i>' : ''}
            `;
            this.elements.userList.appendChild(div);
        });
    }
}

// Iniciar
document.addEventListener('DOMContentLoaded', () => {
    window.chat = new SimpleChat();
});