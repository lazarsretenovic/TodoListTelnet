package com.TenetTodoList.TodoList.security;

import com.TenetTodoList.TodoList.domain.UserDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

@Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
    http.authorizeHttpRequests(configurer->
            configurer
                    .requestMatchers("/").hasRole("EMPLOYEE")
                    .requestMatchers("/api/**").hasRole("EMPLOYEE")
                    .anyRequest().authenticated()
    );

    return http.build();
}}
//    public InMemoryUserDetailsManager userDetailsManager(){
//    UserDetails john = User.builder()
//            .username("john")
//            .password("{noop}test123")
//            .roles("EMPLOYEE")
//            .build();
//    UserDetails mary = User.builder()
//            .username("mary")
//            .password("{noop}test123")
//            .roles("EMPLOYEE","MANAGER")
//            .build();
//    UserDetails susan = User.builder()
//            .username("susan")
//            .password("{noop}test123")
//            .roles("EMPLOYEE","MANAGER","ADMIN")
//            .build();
//
//return new InMemoryUserDetailsManager(john,mary,susan);
//}

