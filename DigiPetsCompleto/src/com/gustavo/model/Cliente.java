package com.gustavo.model;

import java.sql.SQLException;
import java.util.ArrayList;

import com.gustavo.DAO.ClienteDAO;
import com.gustavo.control.ExceptionDAO;



public class Cliente {

	private String nome;
	private String cpf;
	private String endereco;


	public Cliente( String nome, String cpf, String endereco) {

		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;

	}
	public Cliente() {}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public ArrayList<Cliente> listarCliente(String cpf) throws ExceptionDAO, SQLException {
		return new ClienteDAO().listarClientes(cpf);
	}

	public static void cadastrarCliente(Cliente cliente) throws ExceptionDAO {
		new ClienteDAO().cadastrarCliente(cliente);
	}
	//    public static void alterarCliente(Cliente cliente) throws ExceptionDAO {
	//        new ClienteDAO().alterarCliente(cliente);
	//    }

	//	@Override
	//	public String toString() {
	//		return nome;
	//	}


}
