package com.InicioUsuario.repaso.Security;

import com.InicioUsuario.repaso.Service.Interface.IJWTUtilityService;
import com.nimbusds.jwt.JWTClaimsSet;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    private IJWTUtilityService service;

    public JWTAuthorizationFilter(IJWTUtilityService ijwtUtilityService){
        this.service = ijwtUtilityService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String requestUri = request.getRequestURI();
        String header = request.getHeader("Authorization");

        System.out.println("=== JWT FILTER START ===");
        System.out.println("URI: " + requestUri);
        System.out.println("Authorization Header: " + header);

        // Rutas públicas
        if (requestUri.startsWith("/auth/")) {
            System.out.println("Ruta pública /auth/ - permitiendo sin token");
            filterChain.doFilter(request, response);
            return;
        }

        if (requestUri.equals("/user/findAll") || requestUri.startsWith("/user/findAll/") ||
                requestUri.equals("/user/user/findAll") || requestUri.startsWith("/user/user/findAll/") ) {
            System.out.println("Ruta pública /user/findAll - permitiendo sin token");
            filterChain.doFilter(request, response);
            return;
        }

        // Para rutas protegidas, validar token
        if (header == null || !header.startsWith("Bearer ")) {
            System.out.println("ERROR: No Bearer token found for protected route");
            filterChain.doFilter(request, response);
            return;
        }

        try {
            String token = header.substring(7);
            System.out.println("Token recibido (primeros 30 chars): " +
                    token.substring(0, Math.min(30, token.length())) + "...");

            JWTClaimsSet claims = service.parseJWT(token);
            System.out.println("Token válido para usuario: " + claims.getSubject());

            // Crear autenticación
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                            claims.getSubject(),
                            null,
                            Collections.emptyList()
                    );

            // Establecer en contexto de seguridad
            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println("Autenticación establecida en SecurityContext");
            System.out.println("Contexto después de establecer: " +
                    SecurityContextHolder.getContext().getAuthentication());

            filterChain.doFilter(request, response);

            // Verificar después de la cadena de filtros
            System.out.println("Contexto después de doFilter: " +
                    SecurityContextHolder.getContext().getAuthentication());

        } catch (Exception e) {
            System.out.println("ERROR validando token: " + e.getMessage());
            e.printStackTrace();
            // Limpiar contexto por seguridad
            SecurityContextHolder.clearContext();
            filterChain.doFilter(request, response);
        }

        System.out.println("=== JWT FILTER END ===\n");
    }
}
