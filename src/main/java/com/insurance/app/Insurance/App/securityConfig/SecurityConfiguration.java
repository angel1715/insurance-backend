package com.insurance.app.Insurance.App.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf -> csrf.disable()).
                sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));/*.
                authorizeHttpRequests(httpAuth ->{
                    httpAuth.requestMatchers(HttpMethod.POST, "/auth/register").permitAll();
                    httpAuth.requestMatchers(HttpMethod.POST, "/auth/login/{email}/{password}").permitAll();
                    httpAuth.requestMatchers(HttpMethod.GET, "/auth/listar").permitAll();
                });
                */
            return httpSecurity.build();
    }

      @Bean
      public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
      }
}
