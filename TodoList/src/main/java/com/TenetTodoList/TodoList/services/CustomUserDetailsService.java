//package com.TenetTodoList.TodoList.services;
//
//import com.TenetTodoList.TodoList.dao.UsersRepository;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Service
//@Transactional(readOnly = true)
//@AllArgsConstructor
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final UsersRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        var u = userRepository.findByUsername(username);
//
//        User user = u.orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
//
//        return new SecurityUser(user);
//    }
//    @Transactional
//    public void createUser(User user) {
//        var u = userRepository.findByUsername(user.getUsername());
//
//        if (u.isPresent()) {
//            throw new UsernameAlreadyExistsException();
//        }
//
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userRepository.save(user);
//    }
//}