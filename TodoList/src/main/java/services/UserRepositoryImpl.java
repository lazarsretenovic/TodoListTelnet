package services;

import domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public abstract class UserRepositoryImpl implements UserRepository {
    private  UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int theId) {
        Optional<User> result = Optional.ofNullable(userRepository.findById(theId));

        User theUser = null;

        if (result.isPresent()) {
            theUser = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theUser;
    }
    @Override
    public Object save(User theUser) {
    userRepository.save(theUser);
            return theUser;
        }
    @Override
    public void deleteById(int theId){
       userRepository.deleteById(theId);
    }

    @Override
    public void flush() {

    }
}
