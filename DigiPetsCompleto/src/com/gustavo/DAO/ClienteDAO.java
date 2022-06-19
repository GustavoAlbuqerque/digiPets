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
		String sql = "INSERT INTO cliente (cpfCliente, nomeCliente, endereco) VALUES (?,?,?)";
		PreparedStatement pStatement = null;
		Connection connection = null;
		try{
			connection = new ConnectionMVC().getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, cliente.getCpf());
			pStatement.setString(2, cliente.getNome());
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



	public ArrayList<Cliente> listarClientes(String cpf) throws ExceptionDAO, SQLException {
		String sql = " select * from cliente where cpfCliente =" + cpf ;
		PreparedStatement pStatement = null;
		Connection connection = null;
		ArrayList<Cliente> clientes = null;

		try {
			connection = new ConnectionMVC().getConnection();
			pStatement = connection.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery(sql);

			if (rs != null) {
				clientes = new ArrayList<Cliente>();
				while (rs.next()) {
					Cliente cliente = new Cliente();
					cliente.setCpf(rs.getString("cpfCliente"));
					cliente.setNome(rs.getString("nomeCliente"));
					cliente.setEndereco(rs.getString("endereco"));

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
		String sql = "select cpfCliente from cliente ";
		PreparedStatement pStatement = null;
		Connection connection = null;
		ArrayList<Cliente> clientes = null;

		try {
			connection = new ConnectionMVC().getConnection();
			pStatement = connection.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery(sql);
			System.out.println("Resultado consulta"+ rs);
			if (rs != null) {
				clientes = new ArrayList<Cliente>();
				while (rs.next()) {
					Cliente cliente = new Cliente();
					cliente.setCpf(rs.getString("cpfCliente"));
					clientes.add(cliente);
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
		System.out.println("Retorno do metodo dao"+clientes);
		return clientes;


	}


}