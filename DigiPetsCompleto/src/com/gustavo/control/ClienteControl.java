package com.gustavo.control;

import java.sql.SQLException;
import java.util.ArrayList;

import com.gustavo.model.Cliente;

public class ClienteControl {
	public static boolean cadastrarCliente(String cpf, String nome, String endereco) throws ExceptionDAO {

		if ( cpf != null && cpf.length() > 0 && nome != null && nome.length() > 0 && endereco != null && endereco.length() > 0) {
			Cliente cliente = new Cliente(cpf, nome, endereco);
			Cliente.cadastrarCliente(cliente);
			return true;
		}
		return false;
	}

	public ArrayList<Cliente> listarCliente() throws ExceptionDAO, SQLException {
		return new Cliente().listarCliente();
	}

}
