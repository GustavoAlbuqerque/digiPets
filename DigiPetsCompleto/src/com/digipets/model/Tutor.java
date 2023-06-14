package com.digipets.model;

import java.sql.SQLException;
import java.util.ArrayList;

import com.digipets.controller.ExceptionDAO;
import com.digipets.dao.ClienteDAO;
import com.digipets.validate.Validate;



public class Tutor {
	private int id;
	private String nome;
	private String cpf;
	private String endereco;


	public Tutor(int id, String nome, String cpf, String endereco) throws Exception {
		if(Validate.Tutor(nome, cpf, endereco)) {
			this.setId(id);
			this.nome = nome;
			this.cpf = cpf;
			this.endereco = endereco;
		}
	}
	
	public Tutor(String nome, String cpf, String endereco) throws Exception {
		if(Validate.Tutor(nome, cpf, endereco)) {
			this.nome = nome;
			this.cpf = cpf;
			this.endereco = endereco;
		}
	}
	
	public Tutor() {}


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

	public ArrayList<Tutor> listarCliente() throws ExceptionDAO, SQLException {
		return new ClienteDAO().listarClientes();
	}

	public static void cadastrarCliente(Tutor tutor) throws ExceptionDAO {
		new ClienteDAO().cadastrarCliente(tutor);
	}
	//    public static void alterarCliente(Cliente cliente) throws ExceptionDAO {
	//        new ClienteDAO().alterarCliente(cliente);
	//    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	//	@Override
	//	public String toString() {
	//		return nome;
	//	}


}
