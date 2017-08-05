package io.egen.api.controller;


import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.api.constants.URI;
import io.egen.api.entity.User;
import io.egen.api.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value=URI.USERS)
@Api(tags="users")
public class UserController {

	private UserService service;
	
	public UserController(UserService service) {
		// TODO Auto-generated constructor stub
		this.service = service;
	}
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value="Find All Users", notes = "Returns a list of users in the app")
	@ApiResponses(value={
			@ApiResponse(code=200, message="Success"),
			@ApiResponse(code=500, message="Internal Server error")
	})
	public List<User> findAll(){
		return service.findAll();
	}
	

	@RequestMapping(method = RequestMethod.GET, value=URI.ID)
	@ApiOperation(value="Find User by Id", notes = "Returns a user by id if it exist in the app")
	@ApiResponses(value={
			@ApiResponse(code=200, message="Success"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Internal Server error")
	})
	public User findOne(@PathVariable("id") String id){
		return service.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value="Create User", notes = "Create a user in the app with unique email")
	@ApiResponses(value={
			@ApiResponse(code=200, message="Success"),
			@ApiResponse(code=400, message="Bad Request"),
			@ApiResponse(code=500, message="Internal Server error")
	})
	public User create(@RequestBody User user){
		return service.create(user);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value=URI.ID)
	@ApiOperation(value="Update User", notes = "Update an existing user")
	@ApiResponses(value={
			@ApiResponse(code=200, message="Success"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Internal Server error")
	})
	public User update(@PathVariable("id") String id, @RequestBody User user){
		return service.update(id, user);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value=URI.ID)
	@ApiOperation(value="Delete Users", notes = "Delete an existing user")
	@ApiResponses(value={
			@ApiResponse(code=200, message="Success"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Internal Server error")
	})
	public void delete(@PathVariable("id") String id){
		service.delete(id);
	}
}
