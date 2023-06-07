package com.digipets.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.digipets.controller.ExceptionDAO;
import com.digipets.dao.*;
import com.digipets.model.*;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClienteDAO {

	public Tutor tutor;
	public ConnectionMVC connect;
	private ResultSet resultSet;
	private String sql;

	public void cadastrarCliente(Tutor tutor) throws ExceptionDAO {
		String sql = "INSERT INTO Tb_Tutores (Nome, CPF, Endereco) VALUES (?,?,?)";
		PreparedStatement pStatement = null;
		Connection connection = null;
		try{
			connection = new ConnectionMVC().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, tutor.getNome());
			pStatement.setString(2, tutor.getCpf());
			pStatement.setString(3, tutor.getEndereco());
			pStatement.execute();

		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao cadastrar cliente");
		} finally {
			try {
				if (pStatement != null) {
					pStatement.close();
				}
			} catch (SQLException e) {
				throw new ExceptionDAO("Erro ao fechar statement " + e);
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new ExceptionDAO("Erro ao fechar conex�o " + e);
			}
		}
	}



	public ArrayList<Tutor> listarClientes() throws ExceptionDAO, SQLException {
		String sql = "SELECT * FROM Tb_Tutores";
		PreparedStatement pStatement = null;
		Connection connection = null;
		ArrayList<Tutor> tutors = null;

		try {
			connection = new ConnectionMVC().getConnection();
			pStatement = connection.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery();

			if (rs != null) {
				tutors = new ArrayList<Tutor>();
				while (rs.next()) {
					Tutor tutor = new Tutor();
					tutor.setId(rs.getInt("Id"));
					tutor.setNome(rs.getString("Nome"));
					tutor.setCpf(rs.getString("CPF"));
					tutor.setEndereco(rs.getString("Endereco"));

					tutors.add(tutor);
				}
			}
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao consultar clientes");
		} finally {
			pStatement.close();
			connection.close();
			
		}
		return tutors;
	}
	
	public ArrayList<Tutor> BuscarTutor(String busca) throws ExceptionDAO, SQLException {
		String sql = "SELECT * FROM Tb_Tutores WHERE Tb_Tutores.Nome Like '%" + busca +"%'";
		PreparedStatement pStatement = null;
		Connection connection = null;
		ArrayList<Tutor> tutors = null;

		try {
			connection = new ConnectionMVC().getConnection();
			pStatement = connection.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery();

			if (rs != null) {
				tutors = new ArrayList<Tutor>();
				while (rs.next()) {
					Tutor tutor = new Tutor();
					tutor.setId(rs.getInt("Id"));
					tutor.setNome(rs.getString("Nome"));
					tutor.setCpf(rs.getString("CPF"));
					tutor.setEndereco(rs.getString("Endereco"));

					tutors.add(tutor);
				}
			}
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao consultar clientes");
		} finally {
			pStatement.close();
			connection.close();
			
		}
		return tutors;
	}

	public ArrayList<Tutor> comboMostra() throws ExceptionDAO, SQLException {
		String sql = "SELECT Id, Nome FROM Tb_Tutores";
		PreparedStatement pStatement = null;
		Connection connection = null;
		ArrayList<Tutor> tutors = null;

		try {
			connection = new ConnectionMVC().getConnection();
			pStatement = connection.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery();
			if (rs != null) {
				tutors = new ArrayList<Tutor>();
				while (rs.next()) {
					Tutor tutor = new Tutor();
					tutor.setId(rs.getInt("Id"));
					tutor.setNome(rs.getString("Nome"));
					tutors.add(tutor);
				}
			}
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao consultar cliente");
			
		} finally {
			try {
				if (pStatement != null) {
					pStatement.close();
				}
			} catch (SQLException e) {
				throw new ExceptionDAO("Erro ao fechar o pStatement" + e);
			}
		}
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao fechar conex�o" + e);
		}
		return tutors;


	}


}