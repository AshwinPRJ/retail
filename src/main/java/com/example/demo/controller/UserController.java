package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService iUserService;

	@PostMapping(value = "/create", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<UserEntity> creatUserController(@RequestBody UserEntity userEntity) {
		return new ResponseEntity<UserEntity>(iUserService.createUserService(userEntity), HttpStatus.CREATED);
	}
}
