package com.InicioUsuario.repaso.infrastructure.security;

import com.InicioUsuario.repaso.global.GlobalValue;
import com.nimbusds.jwt.JWTClaimsSet;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    private IJWTUtilityService ijwtUtilityService;

    public JWTAuthorizationFilter(IJWTUtilityService ijwtUtilityService){
        this.ijwtUtilityService = ijwtUtilityService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestUri = request.getRequestURI();
        String header = request.getHeader("Authorization");

        if(requestUri.startsWith("/auth/")){
            filterChain.doFilter(request, response);
            return;
        }

        if(header == null || !header.startsWith("Bearer")){
            filterChain.doFilter(request, response);
            return;
        }

        try{
            String token = header.substring(7);
            JWTClaimsSet claims = ijwtUtilityService.parseJWT(token);

            List<String> roles =  claims.getStringListClaim("roles");
            List<GrantedAuthority> authorities = roles.stream()
                    .map(role -> {
                        if(!role.startsWith("ROLE_")){
                            role = "ROLE_" + role;
                            GlobalValue.role_user = role;
                        }

                        return new SimpleGrantedAuthority(role);
                    })
                    .collect(Collectors.toList());
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(claims.getSubject(), null , authorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            filterChain.doFilter(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
