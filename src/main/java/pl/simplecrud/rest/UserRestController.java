package pl.simplecrud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.simplecrud.entity.User;
import pl.simplecrud.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<User> getUsers() {
		return userService.getAll();
	}

	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable int userId) {
		User user = userService.getOne(userId);
		if (user == null) {
			throw new UserNotFoundException("User id not found - " + userId);
		}
		return user;
	}

	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		user.setId(0);
		userService.save(user);
		return user;
	}

	@PutMapping("/users")
	public User updateUser(@RequestBody User user) {
		userService.save(user);
		return user;
	}

	@DeleteMapping("/users/{userId}")
	public String deleteUser(@PathVariable int userId) {
		User user = userService.getOne(userId);
		if (user == null) {
			throw new UserNotFoundException("User id not found - " + userId);
		}
		userService.delete(userId);
		return "Deleted user id - " + userId;
	}
}
