package com.afuera.gesstock1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.afuera.gesstock1.dao.UserRepository;
import com.afuera.gesstock1.model.User;

public final class LoginServiceImpl implements LoginService{
	
	@Autowired
	protected UserRepository userRepository;
	
	@Override 
	public List<User> findAll(){
		return this.userRepository.findAll();
	}
	

}
