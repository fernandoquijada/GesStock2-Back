package com.afuera.gesstock1.service;

import java.util.List;

import com.afuera.gesstock1.model.Product;


public interface ProductService {

	/**
	 * guarda o actualiza en bdd en la tabla productos el objeto @param product
	 * @return un json con mensaje
	 */
	Product save(Product product);

	/*
	 * @return lista de productos
	 */
	List<Product> findAll();
	
	
	/**
	 * borra el producto de bdd con id = @param id
	 */
	void deleteProduct(Integer id);

}
