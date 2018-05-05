package com.afuera.gesstock1.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.afuera.gesstock1.model.User;

/*
 * Comunica con la BDD
 */
public interface UserRepository extends JpaRepository<User, Long> {

	
	@SuppressWarnings("unchecked")
	User save(User user);

}
