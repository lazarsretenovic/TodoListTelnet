package com.TenetTodoList.TodoList.security.services;

import com.TenetTodoList.TodoList.domain.Role;
import com.TenetTodoList.TodoList.domain.User;
import com.TenetTodoList.TodoList.security.JwtAuthenticationResponse;
import com.TenetTodoList.TodoList.security.SignUpRequest;
import com.TenetTodoList.TodoList.security.SinginRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserSecurityRepository userSecurityRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationServiceImpl(UserSecurityRepository userSecurityRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userSecurityRepository = userSecurityRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }
    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        var user = User.builder()
                .loginname(request.getLogin_name())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.valueOf("USER"))
                .build();
        userSecurityRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SinginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin_name(),
                        request.getPassword()));

        var user = userSecurityRepository.findByLoginname(request.getLogin_name())
                .orElseThrow(() -> new IllegalArgumentException("Invalid login name or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public UserDetails loadUserByLoginname(String loginname) throws UsernameNotFoundException {
        User user = userSecurityRepository.findByLoginname(loginname)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with login_name of: " + loginname));

        return User.builder()
                .id(user.getId())
                .loginname(user.getUsername())
                .role(user.getRole())
                .userDetail(user.getUserDetail())
                .build();
    }

}
