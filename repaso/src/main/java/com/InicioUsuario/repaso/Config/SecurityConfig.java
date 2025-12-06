package com.InicioUsuario.repaso.Config;

import com.InicioUsuario.repaso.Security.JWTAuthorizationFilter;
import com.InicioUsuario.repaso.Service.Interface.IJWTUtilityService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    @Autowired
    private IJWTUtilityService service;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){
        return http
                .csrf(httpSecurityCsrfConfigurer ->
                        httpSecurityCsrfConfigurer.disable()
                )
                .authorizeHttpRequests(authRequest -> // Dentrode este método es donde se deberían de añadir los roles a la hora de entrar en el servidor
                        authRequest
                                .requestMatchers("/auth/**").permitAll() // Estas rutas serán públicas gracias al permitAll()
                                .anyRequest().authenticated()
                )
                .sessionManagement(sessionManager ->
                        sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                )
                .addFilterBefore(new JWTAuthorizationFilter(service), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(httpSecurityExceptionHandlingConfigurer ->

                        httpSecurityExceptionHandlingConfigurer.authenticationEntryPoint((request, response, authException) -> {

                            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized!");

                        })).build();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){ // Totalmente necesario siemrpe
        return new BCryptPasswordEncoder();
    }

}
