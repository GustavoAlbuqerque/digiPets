package com.digipets.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.digipets.dao.ClienteDAO;
import com.digipets.model.Tutor;

public class TutorController {
	public static boolean cadastrarCliente(String cpf, String nome, String endereco) throws Exception {

		if ( cpf != null && cpf.length() > 0 && nome != null && nome.length() > 0 && endereco != null && endereco.length() > 0) {
			Tutor tutor = new Tutor(cpf, nome, endereco);
			Tutor.cadastrarCliente(tutor);
			return true;
		}
		return false;
	}

	public ArrayList<Tutor> getTutores() throws ExceptionDAO, SQLException {
		return new Tutor().listarCliente();
	}
	
	public ArrayList<Tutor> getTutoresLike(String busca) throws ExceptionDAO, SQLException {
		ClienteDAO dao = new ClienteDAO();
		return dao.BuscarTutor(busca);
	}
	

}
