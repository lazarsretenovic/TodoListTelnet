package services;

import domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findAll();

    User findById(int theId);

    Object save(User user);

    void deleteById(int theId);
}
