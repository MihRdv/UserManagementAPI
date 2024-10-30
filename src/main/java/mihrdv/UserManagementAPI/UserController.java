package mihrdv.UserManagementAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/changeUsername")
    public User changeUsername(@RequestParam Long id, @RequestParam String newUsername){
        return userService.changeUsername(id,newUsername);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/byId/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserByID(id);
    }

    @DeleteMapping("/byUsername/{username}")
    public void deleteUserByUsername(@PathVariable String username) {
        userService.deleteUserByUsername(username);
    }

    @DeleteMapping("/byEmail/{email}")
    public void deleteUserByEmail(@PathVariable String email) {
        userService.deleteUserByEmail(email);
    }


    @DeleteMapping("/clearAll")
    public void clearDatabase(){
        userService.deleteAllUsers();
    }
}
