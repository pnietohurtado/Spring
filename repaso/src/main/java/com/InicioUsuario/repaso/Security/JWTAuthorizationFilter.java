package com.InicioUsuario.repaso.Security;

import com.InicioUsuario.repaso.Service.Interface.IJWTUtilityService;
import com.nimbusds.jwt.JWTClaimsSet;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
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


        if(requestUri.startsWith("/auth/") ||
                requestUri.equals("/user/findAll") ||
                requestUri.startsWith("/user/findAll/")){
            filterChain.doFilter(request,response);
            return;
        }

        if(header == null || !header.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;  // Para que termine el método ya que ya lo ha comprobado
        }

        String token = header.substring(7);

        JWTClaimsSet claims = service.parseJWT(token);

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(claims.getSubject(), null, Collections.emptyList());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        filterChain.doFilter(request, response);
    }
}
