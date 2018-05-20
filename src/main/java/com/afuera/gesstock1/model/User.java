package com.afuera.gesstock1.model;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
@Access(AccessType.FIELD)
public class User implements Serializable {

	private static final long serialVersionUID = -5014387200981046050L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "nombre", nullable = false, length = 30)
	private String nombre;

	@Column(name = "apellidos", nullable = false, length = 30)
	private String apellidos;

	@Column(name = "telefono", nullable = true, length = 15)
	private String telefono;

	@Column(name = "direccion", nullable = true, length = 255)
	private String direccion;

	@Column(name = "usuario", unique = true, nullable = false, length = 255)
	private String usuario;

	@Column(name = "pass", nullable = false, length = 255)
	private String pass;

	@Column(name = "email", nullable = false, length = 255)
	private String email;

	@Column(name = "img_perfil", nullable = true, length = 255)
	private String imgPerfil;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImgPerfil() {
		return imgPerfil;
	}

	public void setImgPerfil(String imgPerfil) {
		this.imgPerfil = imgPerfil;
	}
}
