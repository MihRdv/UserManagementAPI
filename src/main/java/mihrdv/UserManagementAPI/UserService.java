package mihrdv.UserManagementAPI;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User changeEmail(Long id, String newEmail){
        Optional<User> optionalUser = userRepository.findById(id);

        if(userRepository.findByEmail(newEmail).isPresent()){
            throw new IllegalArgumentException("Email already exists: "+ newEmail);
        }

        if(optionalUser.isPresent()){
            User user = optionalUser.get();

            user.setEmail(newEmail);
            return userRepository.save(user);
        } else {
            throw new EntityNotFoundException("User not found with ID: "+id);
        }
    }

    public User changePassword(Long id, String newPassword){
        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isPresent()){
            User user = optionalUser.get();

            user.setPassword(newPassword);
            return userRepository.save(user);
        } else {
            throw new EntityNotFoundException("User not found with ID: " + id);
        }
    }

    public User changeUsername(Long id, String newUsername){
        Optional<User> optionalUser = userRepository.findById(id);

        if (userRepository.findByUsername(newUsername).isPresent()) {
            throw new IllegalArgumentException("Username already exists: " + newUsername);
        }

        if(optionalUser.isPresent()){
            User user = optionalUser.get();

            user.setUsername(newUsername);
            return userRepository.save(user);
        } else {
            throw new EntityNotFoundException("User not found with ID: "+ id);
        }
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("User not found with ID: " + id));
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void deleteAllUsers(){
        userRepository.deleteAll();
    }

    public void deleteUserByID(Long id){
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()){
            userRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("User not found with ID: " + id);
        }
    }

    public void deleteUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isPresent()) {
            userRepository.delete(user.get()); // Delete the user if found
        } else {
            throw new EntityNotFoundException("User not found with username: " + username);
        }
    }

    public void deleteUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent()) {
            userRepository.delete(user.get()); // Delete the user if found
        } else {
            throw new EntityNotFoundException("User not found with email: " + email);
        }
    }


}
