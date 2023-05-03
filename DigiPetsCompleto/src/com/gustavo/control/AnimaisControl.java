package com.gustavo.control;

import java.sql.SQLException;
import java.util.ArrayList;

import com.gustavo.model.Animais;

public class AnimaisControl {

	public static boolean cadastrarAnimais(String nome, String raca, String sexo, String especie, int idDono) throws ExceptionDAO {

		if (nome != null && nome.length() > 0 && raca != null && raca.length() > 0 && especie != null && especie.length() > 0  && sexo != null && sexo.length() > 0 && idDono !=  0) {
			Animais animais = new Animais(nome, raca, sexo, especie, idDono);
			Animais.cadastrarAnimais(animais);
			return true;
		}
		return false;
	}
	public ArrayList<Animais> listarAnimaisClienteCompleto(int idDono) throws ExceptionDAO, SQLException {
		return new Animais().listarAnimaisClienteCompleto(idDono);
	}


	public ArrayList<Animais> listarAnimais() throws ExceptionDAO, SQLException {
		return new Animais().listarAnimais();
	}
	public ArrayList<Animais> listarAnimaisCliente(int id) throws ExceptionDAO, SQLException {
		return new Animais().listarAnimaisCliente(id);
	}

}
