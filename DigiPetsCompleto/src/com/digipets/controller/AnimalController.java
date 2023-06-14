package com.digipets.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.digipets.dao.AnimalDAO;
import com.digipets.model.Animal;

public class AnimalController {

	public static boolean CreateAnimal(String nome, String raca, String sexo, String especie, int idDono) throws Exception {
		AnimalDAO dao = new AnimalDAO();
		if (nome != null && nome.length() > 0 && raca != null && raca.length() > 0 && especie != null && especie.length() > 0  && sexo != null && sexo.length() > 0 && idDono !=  0) {
			Animal animal = new Animal(nome, raca, sexo, especie, idDono);
			dao.CreateAnimal(animal);
			return true;
		}
		return false;
	}
	
	public static ArrayList<Animal> GetAnimaisFromTutorId(int id) throws ExceptionDAO, SQLException {
		AnimalDAO dao = new AnimalDAO();
		return dao.GetAnimaisFromTutorId(id);
	}
	
	public static ArrayList<Animal> GetAnimais() throws ExceptionDAO, SQLException {
		AnimalDAO dao = new AnimalDAO();
		return dao.GetAnimais();
	}
}
