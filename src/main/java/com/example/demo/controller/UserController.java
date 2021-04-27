package com.example.demo.controller;

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

import com.example.demo.entity.UserEntity;
import com.example.demo.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private IUserService iUserService;

	@PostMapping(value = "/create", produces = { "application/json" }, consumes = { "application/json" })
//	@ApiResponse(responseCode = "201", description = "User is created", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserEntity.class))})

	public ResponseEntity<?> creatUserController(@RequestBody UserEntity userEntity) {
		return new ResponseEntity<UserEntity>(iUserService.createUserService(userEntity), HttpStatus.CREATED);
	}

	@GetMapping()
	public ResponseEntity<?> getAllUsersController() {
		Optional<List<UserEntity>> userEntities = iUserService.getAllUsersService();
		if(!userEntities.isPresent())
			return new ResponseEntity<List<UserEntity>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<UserEntity>>(userEntities.get(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getUserController(@PathVariable int id) {
		Optional<UserEntity> userEntity = iUserService.getUserByIdService(id);
		if (!userEntity.isPresent())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<UserEntity>(userEntity.get(), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateUserController(@PathVariable int id, @RequestBody UserEntity userEntity) {
		Optional<UserEntity> entity = iUserService.updateUserService(userEntity, id);
		if (!entity.isPresent()) {
			return new ResponseEntity<UserEntity>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<UserEntity>(entity.get(), HttpStatus.CREATED);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUserController(@PathVariable int id) {
		iUserService.deleteUserService(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
}
