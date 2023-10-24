//package com.TenetTodoList.TodoList.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import javax.sql.DataSource;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }
//    @Bean
//    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(requests -> requests
//                        .requestMatchers("/logout").permitAll()
//                        .requestMatchers("/api/users").hasRole("ADMIN")
//                        .requestMatchers("/api/todolistresponse").hasRole("EMPLOYEE")
//                        .requestMatchers("/api/todolistresponse/{userId}").hasRole("USER")
//                        .anyRequest().authenticated()).httpBasic(withDefaults());
//        return http.build();
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//}

