package com.afuera.gesstock1.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.afuera.gesstock1.service.UserService;

public class ValidaLoginUsuario {
	@Autowired
	protected UserService userService;

	public static User validaUsuario(List<User> todosLosUsuarios, UserSession usuarioAValidar) {
		boolean usuarioEncontrado = false;
		int i = 0;
		User usuarioMatch = null;

		do {
			if (usuarioAValidar.getUsuario().equals(todosLosUsuarios.get(i).getUsuario())
					&& usuarioAValidar.getPass().equals(todosLosUsuarios.get(i).getPass())) {
				usuarioEncontrado = true;
				usuarioMatch = todosLosUsuarios.get(i);
			}
			i++;
		} while (!usuarioEncontrado && todosLosUsuarios.size() != i);

		return usuarioMatch;
	}

}
