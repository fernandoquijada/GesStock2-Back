package com.afuera.gesstock1.service;

import java.util.List;

import com.afuera.gesstock1.model.User;

public interface UserService {
	
	User save(User user);


	/*
	 * Recupera la lista de usuarios
	 * @return lista de usuarios
	 */
	List<User> findAll();



	void deleteUser(Long id);
	
	

}
