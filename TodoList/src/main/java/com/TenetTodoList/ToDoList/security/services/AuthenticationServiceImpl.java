package com.TenetTodoList.ToDoList.security.services;

import com.TenetTodoList.ToDoList.domain.Role;
import com.TenetTodoList.ToDoList.domain.User;
import com.TenetTodoList.ToDoList.dto.UserDTOWhoAmI;
import com.TenetTodoList.ToDoList.exceptions.ResourceNotFoundException;
import com.TenetTodoList.ToDoList.security.JwtAuthenticationResponse;
import com.TenetTodoList.ToDoList.security.SignUpRequest;
import com.TenetTodoList.ToDoList.security.SingInRequest;
import com.TenetTodoList.ToDoList.services.mappers.UserDetailsMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserSecurityRepository userSecurityRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsMapper userDetailsMapper;
    public AuthenticationServiceImpl(UserSecurityRepository userSecurityRepository,PasswordEncoder passwordEncoder,JwtService jwtService, AuthenticationManager authenticationManager, UserDetailsMapper userDetailsMapper) {
        this.userSecurityRepository = userSecurityRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userDetailsMapper = userDetailsMapper;
    }
    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        var user = User.builder()
                .loginname(request.getLogin_name())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.valueOf("USER"))
                .userDetail(request.getUserDetail())
                .build();
        userSecurityRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse singin(SingInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin_name(),
                        request.getPassword()));

        var user = userSecurityRepository.findByLoginname(request.getLogin_name())
                .orElseThrow(() -> new ResourceNotFoundException("Invalid login name or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public UserDTOWhoAmI loadUserByLoginname(String loginname) throws UsernameNotFoundException {
        User user = userSecurityRepository.findByLoginname(loginname)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with login_name of: " + loginname));


        UserDTOWhoAmI userDtoWhoAmI = new UserDTOWhoAmI(
                user.getId(),
                user.getUsername(),
                userDetailsMapper.UserDetailFromEntityToDto(user.getUserDetail()),
                user.getRole(),
                user.isAccountNonExpired(),
                user.isAccountNonLocked(),
                user.isCredentialsNonExpired(),
                user.isEnabled()
        );
        return userDtoWhoAmI;
    }


}
