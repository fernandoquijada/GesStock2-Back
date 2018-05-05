package com.afuera.gesstock1.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.afuera.gesstock1.model.Product;
import com.afuera.gesstock1.service.ProductService;
import com.afuera.gesstock1.util.RestResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * Clase que se invoca desde el front para el manejo Productos
 *
 */
@RestController
public class ProductController {

    @Autowired
	protected ProductService productService;	
	protected ObjectMapper mapper;
	
	
	/**
	 * Crea y actualiza productos
	 * 
	 */
	@RequestMapping(value = "/saveOrUpdateProduct", method = RequestMethod.POST)
	public RestResponse saveOrUpdate(@RequestBody String productJson)
			throws JsonParseException, JsonMappingException, IOException {
		
		this.mapper = new ObjectMapper();
		Product product = this.mapper.readValue(productJson, Product.class);
		//validación de usuario 
		if (!this.validate(product)) 
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Hay campos obligatorios nulos");
		
		this.productService.save(product);
		
		return new RestResponse(HttpStatus.OK.value(), "Operación exitosa");
	}

	
	/**
	 * json con una búsqueda general de la tabla productos
	 * 
	 */
	@RequestMapping(value = "/getProducts", method = RequestMethod.GET)
	public List<Product> getProducts() {
		return productService.findAll();
	}
	
	
	/**
	 *  borra el producto con el id correspondiente que se le pasa en el json
	 *  
	 */
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
	public void  deleteProduct(@RequestBody String productJson) throws Exception {
		
		this.mapper = new ObjectMapper();
		Product product = this.mapper.readValue(productJson, Product.class);

		this.productService.deleteProduct(product.getIdProducto());
		
	}
	
	
	/**
	 * 
	 * Validación de campos del tipo Product que se le pasan en el json
	 * @param product
	 * @return
	 */
	private boolean validate(Product product) {
		boolean isValid = true;
	
		if  (product.getNombreProducto() == null  || product.getNombreProducto() == "") 
			isValid = false;
		 else if (product.getRefProducto() == null || product.getRefProducto() == "") 
			isValid = false;
	
		return isValid;
	}	
	
	
}
