package com.digipets.validate;

public class Validate {

	
	public static boolean Tutor(String nome, String cpf, String endereco) throws Exception {
		if(nome != null && nome.length() > 0 && cpf != null && cpf.length() > 0 && endereco != null && endereco.length() > 0) {
			return true;
		}
		else {
			throw new Exception("Os dados do tutor são inválidos!");
		}
	}
	
	public static boolean Animal(String nome, String raca, String sexo, String especie, int idDono) throws Exception {
		if(nome != null && nome.length() > 0 && raca != null && raca.length() > 0 &&
				sexo != null && sexo.length() > 0 && especie != null && especie.length() > 0 && idDono != 0) {
			return true;
		}
		else {
			throw new Exception("Os dados do animal são inválidos!");
		}
	}
}
