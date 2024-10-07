package com.demo.EcloudSystemsFZE.Controller;

import java.util.List;

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

import com.demo.EcloudSystemsFZE.Entity.UserEntity;
import com.demo.EcloudSystemsFZE.Service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public UserEntity createUser(@RequestBody UserEntity user) {
		return userService.createUserEntity(user);
	}

	@GetMapping
	public List<UserEntity> getAllUsers() {
		return userService.getAllUserEntity();
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserEntity> getUserById(@PathVariable Long id) {
		return userService.getUserEntityById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public UserEntity updateUserEntity(@PathVariable Long id, @RequestBody UserEntity userDetails) {
		return userService.updateUserEntity(id, userDetails);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.deleteUserEntity(id);
		return ResponseEntity.noContent().build();
	}
}
