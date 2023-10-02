package services;

import Dao.UserRepository;
import domain.Todo;
import domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserRepositoryImpl implements  UserService{
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return  userRepository.findAll();
    }

    @Override
    public User findById(int theId) {
        Optional<User> result = userRepository.findById((long) theId);
        User theUser=null;
        if (result.isPresent()) {
            theUser = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find Todolist with the id of- " + theId);
        }

        return theUser;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(int theId) {
        userRepository.deleteById((long) theId);

    }
}
