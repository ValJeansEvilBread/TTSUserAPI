package com.tts.UsersAPI.repository;

import org.springframework.data.repository.CrudRepository;

import com.tts.UsersAPI.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	public User findByState(String state);

}
