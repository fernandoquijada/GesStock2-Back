package com.afuera.gesstock1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afuera.gesstock1.model.Product;

/*
 * Comunica con la BDD
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@SuppressWarnings("unchecked")
	Product save(Product product);
}
