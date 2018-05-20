package com.afuera.gesstock1.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.afuera.gesstock1.model.User;
import com.afuera.gesstock1.model.UserSession;
import com.afuera.gesstock1.model.ValidaLoginUsuario;
import com.afuera.gesstock1.service.UserService;
import com.afuera.gesstock1.util.RestResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * Clase que se invoca desde el front para el manejo de Usuarios
 */
@RestController
public class UserController {

	@Autowired
	protected UserService userService;
	protected ObjectMapper mapper;

	// Método de guardar y actualizar
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public RestResponse saveOrUpdate(@RequestBody String userJson)
			throws JsonParseException, JsonMappingException, IOException {

		this.mapper = new ObjectMapper();
		User user = this.mapper.readValue(userJson, User.class);
		// validación de usuario
		if (!this.validate(user))
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Hay campos obligatorios nulos");

		this.userService.save(user);

		return new RestResponse(HttpStatus.OK.value(), "Operación exitosa");
	}

	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public List<User> getUsers() {
		return userService.findAll();
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public void deleteUser(@RequestBody String userJson) throws Exception {

		this.mapper = new ObjectMapper();
		User user = this.mapper.readValue(userJson, User.class);
		if (user.getId() == null)
			throw new Exception("El id está nulo");
		this.userService.deleteUser(user.getId());

	}

	@CrossOrigin
	@RequestMapping(value = "/validateUserLogin", method = RequestMethod.POST)
	public User validarUsuarioLogin(@RequestBody String userJson) throws Exception {
		List<User> todosLosUsuarios = userService.findAll();
		this.mapper = new ObjectMapper();
		UserSession usuarioAValidar = this.mapper.readValue(userJson, UserSession.class);
		return ValidaLoginUsuario.validaUsuario(todosLosUsuarios, usuarioAValidar);
	}

	private boolean validate(User user) {
		boolean isValid = true;

		// TODO no estamos comprobando el ID porque se supone que tenemos que
		// auto-generarlo
		if (user.getNombre() == null || user.getNombre() == "")
			isValid = false;
		else if (user.getApellidos() == null || user.getNombre() == "")
			isValid = false;

		return isValid;
	}
}
