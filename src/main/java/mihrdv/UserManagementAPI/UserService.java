package mihrdv.UserManagementAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User getUserByID(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        //If the user ID exists, returns the user, if not null
        return optionalUser.orElse(null);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void deleteUserByID(Long id){
        userRepository.deleteById(id);
    }

    public void deleteUserByName(User user){
        userRepository.delete(user);
    }
}
