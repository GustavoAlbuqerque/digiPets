package com.gustavo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gustavo.control.ExceptionDAO;
import com.gustavo.model.Cliente;

import com.gustavo.DAO.*;
import com.gustavo.model.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClienteDAO {

	public Cliente cliente;
	public ConnectionMVC connect;
	private ResultSet resultSet;
	private String sql;

	public void cadastrarCliente(Cliente cliente) throws ExceptionDAO {
		String sql = "INSERT INTO Tb_Tutores (Nome, CPF, Endereco) VALUES (?,?,?)";
		PreparedStatement pStatement = null;
		Connection connection = null;
		try{
			connection = new ConnectionMVC().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, cliente.getNome());
			pStatement.setString(2, cliente.getCpf());
			pStatement.setString(3, cliente.getEndereco());
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



	public ArrayList<Cliente> listarClientes() throws ExceptionDAO, SQLException {
		String sql = "SELECT * FROM Tb_Tutores";
		PreparedStatement pStatement = null;
		Connection connection = null;
		ArrayList<Cliente> clientes = null;

		try {
			connection = new ConnectionMVC().getConnection();
			pStatement = connection.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery();

			if (rs != null) {
				clientes = new ArrayList<Cliente>();
				while (rs.next()) {
					Cliente cliente = new Cliente();
					cliente.setNome(rs.getString("Nome"));
					cliente.setCpf(rs.getString("CPF"));
					cliente.setEndereco(rs.getString("Endereco"));

					clientes.add(cliente);
				}
			}
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao consultar clientes");
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
		return clientes;
	}

	public ArrayList<Cliente> comboMostra() throws ExceptionDAO, SQLException {
		String sql = "SELECT Id, Nome FROM Tb_Tutores";
		PreparedStatement pStatement = null;
		Connection connection = null;
		ArrayList<Cliente> clientes = null;

		try {
			connection = new ConnectionMVC().getConnection();
			pStatement = connection.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery();
			System.out.println("Resultado consulta"+ rs);
			if (rs != null) {
				clientes = new ArrayList<Cliente>();
				while (rs.next()) {
					Cliente cliente = new Cliente();
					cliente.setId(rs.getInt("Id"));
					cliente.setNome(rs.getString("Nome"));
					clientes.add(cliente);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
		System.out.println("Retorno do metodo dao"+clientes);
		return clientes;


	}


}