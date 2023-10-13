package com.TenetTodoList.TodoList.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }
    /*napraviti lgoin controller, gde se potvrdi da li je korsinik ok i generse se jwt token*/
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/logout").permitAll()
                        .requestMatchers("/api/users").hasRole("ADMIN")
                        .requestMatchers("/api/todolistresponse").hasRole("EMPLOYEE")
                        .requestMatchers("/api/todolistresponse/{userId}").hasRole("USER")
                        .anyRequest().authenticated()).httpBasic(withDefaults());
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
/*DROP SCHEMA IF EXISTS `todolistproject`;

CREATE SCHEMA `todolistproject`;

use `todolistproject`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `user_detail`;

CREATE TABLE `user_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(128) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,

  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(128) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  `user_detail_id` int NOT NULL,

  PRIMARY KEY (`id`),
  KEY `FK_DETAIL_idx` (`user_detail_id`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`user_detail_id`) REFERENCES `user_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
  ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `todo_list`;

CREATE TABLE `todo_list` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(128) DEFAULT NULL,
  `status` varchar(128) DEFAULT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `user`(`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--

INSERT INTO `users`
VALUES
('john','{noop}test123',1),
('mary','{noop}test123',1),
('susan','{noop}test123',1);


--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities`
VALUES
('john','ROLE_EMPLOYEE'),
('mary','ROLE_EMPLOYEE'),
('mary','ROLE_MANAGER'),
('susan','ROLE_EMPLOYEE'),
('susan','ROLE_MANAGER'),
('susan','ROLE_ADMIN');
INSERT INTO `todolistproject`.`todo_list` (`description`, `status`, `user_id`) VALUES ('Uneti drva', 'Complited', '1');
INSERT INTO `todolistproject`.`todo_list` (`description`, `status`, `user_id`) VALUES ('Platati racune', 'Not_Complited', '2');
INSERT INTO `todolistproject`.`todo_list` (`description`, `status`, `user_id`) VALUES ('Spremiti veceru', 'In_Progress', '3');
INSERT INTO `todolistproject`.`todo_list` (`description`, `status`, `user_id`) VALUES ('Ostaviti kola kod majsotra', 'Complited', '4');
INSERT INTO `todolistproject`.`todo_list` (`description`, `status`, `user_id`) VALUES ('Pregled kod doktora', 'Not_Complited', '5');





INSERT INTO `todolistproject`.`user` (`username`, `password`, `user_detail_id`) VALUES ('igor99', 'password123', '1');
INSERT INTO `todolistproject`.`user` (`username`, `password`, `user_detail_id`) VALUES ('petar123', 'lozinka', '2');
INSERT INTO `todolistproject`.`user` (`username`, `password`, `user_detail_id`) VALUES ('telnet', 'telnet123', '3');
INSERT INTO `todolistproject`.`user` (`username`, `password`, `user_detail_id`) VALUES ('lazar002', 'lazar321', '4');
INSERT INTO `todolistproject`.`user` (`username`, `password`, `user_detail_id`) VALUES ('milan111', 'LoziNka13', '5');


INSERT INTO `todolistproject`.`user_detail` (`firstname`, `lastname`, `email`, `city`) VALUES ('Igor', 'Matovic', 'imatovic99@gmail.com', 'Gornji Milanovac');
INSERT INTO `todolistproject`.`user_detail` (`firstname`, `lastname`, `email`, `city`) VALUES ('Petar', 'Petrovic', 'ppetr@gmail.com', 'Topola');
INSERT INTO `todolistproject`.`user_detail` (`firstname`, `lastname`, `email`, `city`) VALUES ('Tel', 'Net', 'telnet@gmail.com', 'Cacak');
INSERT INTO `todolistproject`.`user_detail` (`firstname`, `lastname`, `email`, `city`) VALUES ('Lazar', 'Sretenovic', 'sretenoviclazar0002@gmail.com', 'Gornji Milanovac');
INSERT INTO `todolistproject`.`user_detail` (`firstname`, `lastname`, `email`, `city`) VALUES ('Milan', 'MIlanovic', 'mmilan0000@gmail.com', 'Kragujevac');

*/


