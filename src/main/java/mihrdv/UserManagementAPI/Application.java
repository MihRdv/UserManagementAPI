package mihrdv.UserManagementAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	private UserRepository userRepository;

	public User createUser(User user){
		return  userRepository.save(user);
	}

	
}
