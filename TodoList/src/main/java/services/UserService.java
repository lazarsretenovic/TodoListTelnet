package services;

import domain.Todo;
import domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(int theId);

    Object save(User user);

    void deleteById(int theId);
}
