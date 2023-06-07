package com.digipets.model;

import java.sql.SQLException;

import com.digipets.controller.ExceptionDAO;
import com.digipets.dao.LoginDAO;

public class Login {
	
	private String usuario;
	private String senha;
	
	public Login(String usuario, String senha ) {
		setUsuario(usuario);
		setSenha(senha);
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean autenticar() throws ExceptionDAO, SQLException {
		LoginDAO loginDAO = new LoginDAO();
		return loginDAO.autenticar(this.usuario, this.senha);
	}

}
