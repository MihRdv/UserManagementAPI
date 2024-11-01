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

    @PutMapping("/changePassword")
    public User changePassword(@RequestParam Long id, @RequestParam String newPassword) {
        return userService.changePassword(id,newPassword);
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
    public String deleteUserById(@PathVariable Long id) {
        userService.deleteUserByID(id);
        return "Successfully deleted user by ID: " + id;
    }

    @DeleteMapping("/username/{username}")
    public String deleteUserByUsername(@PathVariable String username) {
        userService.deleteUserByUsername(username);
        return "Successfully deleted user by username: " + username;
    }

    @DeleteMapping("/email/{email}")
    public String deleteUserByEmail(@PathVariable String email) {
        userService.deleteUserByEmail(email);
        return "Successfully deleted user by email: " + email;
    }


    @DeleteMapping("/clearAll")
    public String clearDatabase(){
        userService.deleteAllUsers();
        return "Successfully deleted all users from database";
    }
}
