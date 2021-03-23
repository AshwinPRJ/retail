package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IUserRepo;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserRepo iUserRepo;
	
	public UserEntity createUserService(UserEntity user) {
		
		return iUserRepo.save(user);
	}

}
