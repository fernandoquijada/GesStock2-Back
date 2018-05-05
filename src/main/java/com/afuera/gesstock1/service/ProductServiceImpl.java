package com.afuera.gesstock1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afuera.gesstock1.dao.ProductRepository;
import com.afuera.gesstock1.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	protected ProductRepository productRepository;

	@Override
	public Product save(Product product) {
		return this.productRepository.save(product);
	}

	@Override
	public List<Product> findAll() {
		return this.productRepository.findAll();
	}

	@Override
	public void deleteProduct(Integer id) {
		this.productRepository.deleteById(id);	
	}
	


}
