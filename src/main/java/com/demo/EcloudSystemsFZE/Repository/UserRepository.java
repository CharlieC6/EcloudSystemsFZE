package com.demo.EcloudSystemsFZE.Repository;

import com.demo.EcloudSystemsFZE.Entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}