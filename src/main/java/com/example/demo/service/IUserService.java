package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.UserEntity;

public interface IUserService {
	
	public UserEntity createUserService(UserEntity user);

	public Optional<UserEntity> getUserByIdService(int id);

	public Optional<List<UserEntity>> getAllUsersService();

	public Optional<UserEntity> updateUserService(UserEntity userEntity, int id);

	public void deleteUserService(int id);
}
