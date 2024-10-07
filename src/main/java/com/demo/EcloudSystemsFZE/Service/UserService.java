package com.demo.EcloudSystemsFZE.Service;

import com.demo.EcloudSystemsFZE.Entity.UserEntity;
import com.demo.EcloudSystemsFZE.Repository.UserRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UserEntity createUserEntity(UserEntity userEntity) {
		return userRepository.save(userEntity);
	}

	public List<UserEntity> getAllUserEntity() {
		return userRepository.findAll();
	}

	public Optional<UserEntity> getUserEntityById(Long id) {
		return userRepository.findById(id);
	}

	public UserEntity updateUserEntity(Long id, UserEntity userDetails) {
		UserEntity user = userRepository.findById(id).orElseThrow();
		user.setUsername(userDetails.getUsername());
		user.setPassword(userDetails.getPassword());
		user.setActive(userDetails.isActive());
		return userRepository.save(user);
	}

	public void deleteUserEntity(Long id) {
		userRepository.deleteById(id);
	}
}
