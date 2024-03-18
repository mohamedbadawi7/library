package com.system.library.security;

import com.system.library.filter.*;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@Configuration
public class ProjectSecurityConfig {


    /*
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);

        userDetailsManager.setUsersByUsernameQuery("select username, pwd, enabled from users where username=?");

        userDetailsManager.setAuthoritiesByUsernameQuery("select username, role from authorities where username=?");

        return userDetailsManager;
    }

     */

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {


        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                        .cors().configurationSource(new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                CorsConfiguration config = new CorsConfiguration();
                config.setAllowedMethods(Collections.singletonList("*"));
                config.setAllowCredentials(true);
                config.setAllowedHeaders(Collections.singletonList("*"));
                config.setExposedHeaders(Arrays.asList("Authorization"));
                config.setMaxAge(3600L);
                return config;
            }
        }).and().csrf().disable()
                //.addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new AuthoritiesLoggingAfterFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new JWTTokenGenerationFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new JWTTokenValidatorFilter(), BasicAuthenticationFilter.class)
                .addFilterAt(new AuthoritiesLoggingAtFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests();

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/library/books").hasAnyAuthority("user", "admin")
                        .requestMatchers(HttpMethod.GET, "/library/books/**").hasAnyAuthority("user","admin")
                        .requestMatchers(HttpMethod.POST, "/library/books").hasAuthority("admin")
                        .requestMatchers(HttpMethod.PUT, "/library/books").hasAuthority("admin")
                        .requestMatchers(HttpMethod.DELETE, "/library/books/**").hasAuthority("admin")
                        .requestMatchers(HttpMethod.GET, "/users/").hasAuthority("admin")
                        .requestMatchers(HttpMethod.POST, "/users/signup").hasAuthority("admin")
                        .requestMatchers(HttpMethod.GET, "/users/**").hasAuthority("admin")
                        .requestMatchers(HttpMethod.PUT, "/users/").hasAuthority("admin")
                        .requestMatchers(HttpMethod.DELETE, "/users/**").hasAuthority("admin")
                        .requestMatchers(HttpMethod.GET, "/login").permitAll());

        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
