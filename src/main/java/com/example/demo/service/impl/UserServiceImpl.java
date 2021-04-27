package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IUserRepo;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepo iUserRepo;

	public UserEntity createUserService(UserEntity user) {

		return iUserRepo.save(user);
	}

	@Override
	public Optional<List<UserEntity>> getAllUsersService() {

		List<UserEntity> userEntities = iUserRepo.findAll();
		Optional<List<UserEntity>> optional = Optional.ofNullable(userEntities);
		return optional;
	}

	@Override
	public Optional<UserEntity> getUserByIdService(int id) {
		Optional<UserEntity> optional = iUserRepo.findById(id);
		return optional;
	}

	@Override
	public Optional<UserEntity> updateUserService(UserEntity userEntity, int id) {

		Optional<UserEntity> optional = iUserRepo.findById(id);

		if (!optional.isPresent())
			return optional;
		UserEntity entity = optional.get();
		userEntity.setId(entity.getId());
		userEntity = iUserRepo.save(userEntity);
		Optional<UserEntity> optional2 = Optional.ofNullable(userEntity);
		return optional2;
	}

	@Override
	public void deleteUserService(int id) {

		iUserRepo.deleteById(id);
	}

}
