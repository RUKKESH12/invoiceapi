package com.project.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.project.app.response.APIResponse;
import com.project.app.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<APIResponse<UserDto>> createUser(@RequestBody User user) {

		try {
			User savedUser = userService.saveUser(user);
			UserDto dto = UserToDto.converToUserDto(savedUser);
			APIResponse<UserDto> res = new APIResponse<>("User addedd", true, dto);
			return ResponseEntity.ok(res);
		} catch (Exception e) {
			APIResponse<UserDto> res = new APIResponse<>("User not  added", false, null);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
		}

//		User savedUser = userService.saveUser(user);
//		UserDto dto = UserToDto.converToUserDto(savedUser);
//
//		return ResponseEntity.ok(dto);

	}

	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsers() {
		List<UserDto> dtos = userService.getAllUsers().stream().map(UserToDto::converToUserDto).toList();
		if (dtos.size() == 0) {
			return ResponseEntity.ok(null);
		}
		return ResponseEntity.ok(dtos);
//
//Older way
//    	List<User> savedUsers= userService.getAllUsers();
//        
//        List<UserDto> dtos = savedUsers.stream().map(null)
//        
//        
//      List<UserDto> dtos = new ArrayList<>();
//      for(User user:savedUsers)
//      {
//    	 dtos.add(UserToDto.converToUserDto(user)) ;
//      }
//      
//      return ResponseEntity.ok(dtos);
	}

	@GetMapping("/{id}")
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
