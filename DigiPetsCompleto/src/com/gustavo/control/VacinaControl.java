package com.gustavo.control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.gustavo.model.Cliente;
import com.gustavo.model.Vacina;

public class VacinaControl {
	public static boolean cadastrarVacina(String nome, String data,  int idPet) throws ExceptionDAO, SQLException {
		if (nome != null && nome.length() > 0 &&  data != null && idPet !=0) {
			Vacina vacina = new Vacina(nome, data, idPet);
			Vacina.cadastrarVacina(vacina);
			return true;
		}
		return false;
	}
	public static boolean alterarVacina(String nome, String data, int codigo) throws ExceptionDAO, SQLException {

		if (nome != null && nome.length() > 0 &&  data != null && codigo!=0) {
			Vacina vacina = new Vacina(nome, data, codigo);
			Vacina.alterarVacina(vacina);
			return true;
		}
		return false;
	}

	public ArrayList<Vacina> listarVacinaPet(int codigo) throws ExceptionDAO, SQLException {
		return new Vacina().listarVacinaPet(codigo);
	}

	public  static boolean deletarVacina(int cod) throws ExceptionDAO, SQLException {
		if(cod != 0) {	
			Vacina.deletarVacina(cod);
			return true;
		}
		return false;
	}

}
