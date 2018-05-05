package com.afuera.gesstock1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afuera.gesstock1.dao.UserRepository;
import com.afuera.gesstock1.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	protected UserRepository userRepository;

	@Override
	public User save(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	public void deleteUser(Long id) {
		this.userRepository.deleteById(id);
		
	}

	


}
