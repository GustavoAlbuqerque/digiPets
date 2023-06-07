package com.digipets.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.digipets.controller.ExceptionDAO;
import com.digipets.model.Login;

public class LoginDAO {
	public boolean autenticar(String usuario, String senha) throws ExceptionDAO, SQLException {
		String sql = " SELECT * FROM Tb_Login WHERE Usuario = '"+ usuario +"' and Senha = '"+ senha +"'";
		PreparedStatement pStatement = null;
		Connection connection = null;
		try {
			connection = new ConnectionMVC().getConnection();
			pStatement = connection.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery();
			@SuppressWarnings("unused")
			Login loginFromBd  = null;
				if (rs != null) {
					while (rs.next()) {
						loginFromBd = new Login(rs.getString("Usuario"), rs.getString("Senha"));
					}
				}
				if(loginFromBd != null) 
					return true;
				else
					return false;
			} catch (SQLException e) {
				throw new ExceptionDAO("Erro ao logar");
			} finally {
				pStatement.close();
				connection.close();
			}
	}
}
