package com.TenetTodoList.TodoList.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers(HttpMethod.GET, "/api/users").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/users").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/users").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/api/users").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/todolist").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/todolist").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/todolist").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/api/todolist").permitAll()
//                        .requestMatchers(HttpMethod.GET, "/api/users/login", "/api/users/{username}", "/api/users/logout", "/api/customers", "/api/storages").authenticated()
//                        .requestMatchers(HttpMethod.POST, "/api/customers", "/api/storages").authenticated()
//                        .requestMatchers(HttpMethod.PUT, "/api/customers/{id}", "/api/storages/{id}").authenticated()
//                        .requestMatchers(HttpMethod.DELETE, "/api/users/{id}", "/api/storages/{id}", "/api/customers/{id}").authenticated()
                        .anyRequest().denyAll())
                .httpBasic();
        return http.build();
    }}
//
//@Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        http.authorizeHttpRequests(configurer-> configurer
//                  .requestMatchers("").hasRole("EMPLOYEE")
//                .requestMatchers("/api/**").hasRole("MANAGER")
//                .requestMatchers("/api/todolist").hasRole("ADMIN")
//
//                .anyRequest().authenticated());
//        return http.build();
//}
