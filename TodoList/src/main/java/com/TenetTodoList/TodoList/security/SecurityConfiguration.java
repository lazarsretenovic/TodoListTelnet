package com.TenetTodoList.TodoList.security;

import com.TenetTodoList.TodoList.security.services.JwtAuthenticationFilter;
import com.TenetTodoList.TodoList.security.services.UserSecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final UserSecurityService userService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(request -> request.requestMatchers("/api/v1/auth/**",
                                "/api/users",
                                "/swagger-ui/**",
                                "/v2/api-docs",
                                "/v3/api-docs",
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/webjars/**",
                                "/swagger-resources",
                                "/swagger-resources/**")
                        .permitAll().anyRequest().authenticated())
                .sessionManagement(manager -> manager.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider()).addFilterBefore(
                        jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
@Bean
    CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration= new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:8080/"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","HEAD","OPTIONS"));
        configuration.setAllowedHeaders(List.of("Authorization"));
    UrlBasedCorsConfigurationSource source= new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;

}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService.userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
            throws Exception {
        return config.getAuthenticationManager();
    }
}
