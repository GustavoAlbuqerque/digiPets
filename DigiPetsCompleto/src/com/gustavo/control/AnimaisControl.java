package com.gustavo.control;

import java.sql.SQLException;
import java.util.ArrayList;

import com.gustavo.model.Animais;

public class AnimaisControl {

	public static boolean cadastrarAnimais(String nome, String raca, String sexo, String especie, String cpfDono) throws ExceptionDAO {

		if (nome != null && nome.length() > 0 && raca != null && raca.length() > 0 && especie != null && especie.length() > 0  && sexo != null && sexo.length() > 0 && cpfDono != null && cpfDono.length() > 0) {
			Animais animais = new Animais(nome, raca, sexo, especie, cpfDono);
			Animais.cadastrarAnimais(animais);
			return true;
		}
		return false;
	}
	public ArrayList<Animais> listarAnimaisClienteCompleto(String cpfDono) throws ExceptionDAO, SQLException {
		return new Animais().listarAnimaisClienteCompleto(cpfDono);
	}


	public ArrayList<Animais> listarAnimais() throws ExceptionDAO, SQLException {
		return new Animais().listarAnimais();
	}
	public ArrayList<Animais> listarAnimaisCliente(int id) throws ExceptionDAO, SQLException {
		return new Animais().listarAnimaisCliente(id);
	}

}
