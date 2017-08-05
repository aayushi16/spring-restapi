package io.egen.api.service.impl;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.api.entity.User;
import io.egen.api.exception.BadRequestException;
import io.egen.api.exception.NotFoundException;
import io.egen.api.repository.UserRepository;
import io.egen.api.service.UserService;

@Service
public class UserServiceimpl implements UserService{

	private UserRepository repository;
	
	public UserServiceimpl(UserRepository repository){
		this.repository = repository;
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public User findOne(String id) {
		// TODO Auto-generated method stub
		User existing = repository.findOne(id);
		if(existing == null){
		//throw an runtime exception here which should return 404 to client	
			throw new NotFoundException("User with id " + id+ "does not exist");
		}
		return existing;
	}

	@Override
	@Transactional
	public User create(User user) {
		// TODO Auto-generated method stub
		User existing = repository.findByEmail(user.getEmail());
		if(existing != null){
			//throw an runtime exception here which should return 400 to client	Bad Request. Email already exists
			throw new BadRequestException("User with email " +user.getEmail()+ "already exist");
			}
			return repository.create(user);
		}

	@Override
	@Transactional
	public User update(String id, User user) {
		User existing = repository.findOne(id);
		if(existing == null){
		//throw an runtime exception here which should return 404 to client	
			throw new NotFoundException("User with id " + id+ "does not exist");
		}
		return repository.update(user);
	}

	@Override
	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		
		User existing = repository.findOne(id);
		if(existing == null){
		//throw an runtime exception here which should return 404 to client	
			throw new NotFoundException("User with id " + id+ "does not exist");
		}
		repository.delete(existing);
	}
}
