package com.digipets.controller;

import java.sql.SQLException;

import com.digipets.model.Login;

public class LoginController {
	public static boolean Autenticar(String usuario, String senha) throws ExceptionDAO, SQLException {
		Login login = new Login(usuario, senha);
		return login.autenticar();
	}
}
