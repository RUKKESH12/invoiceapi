package com.project.app.controller;

import java.util.List;

import com.project.app.service.UserServiceImps;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.app.dto.UserDto;
import com.project.app.dto.UserToDto;
import com.project.app.entity.User;
import com.project.app.repository.UserRepository;
import com.project.app.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
    private  UserServiceImps userServiceImps;

    @Autowired
    private  UserRepository userRepository;

	@Autowired
	private UserService userService;

   
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));

	}
	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsers() {
		List<UserDto> dtos = userService.getAllUsers().stream().map(UserToDto::converToUserDto).toList();
		if (dtos.size() == 0) {
			return ResponseEntity.ok(null);
		}
		return ResponseEntity.ok(dtos);
		}


	@GetMapping("/all")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		return userService.getUserById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
		user.setId(id);
		userService.saveUser(user);
		return ResponseEntity.ok(user);
	}
}
