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
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        String requestUri = request.getRequestURI();

        // Solo permitir rutas públicas sin token
        if(requestUri.startsWith("/auth/")){
            filterChain.doFilter(request,response);
            return;
        }

        // Para TODAS las demás rutas, incluyendo /user/, requerir token
        if(header == null || !header.startsWith("Bearer ")){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Token JWT requerido");
            return;
        }

        try {
            String token = header.substring(7);
            JWTClaimsSet claims = service.parseJWT(token);

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(claims.getSubject(), null, Collections.emptyList());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            filterChain.doFilter(request, response);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Token JWT inválido o expirado: " + e.getMessage());
        }
    }
}
