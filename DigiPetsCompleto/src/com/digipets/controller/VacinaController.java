package com.digipets.controller;

import java.util.ArrayList;
import com.digipets.dao.VacinaDAO;
import com.digipets.model.Vacina;

public class VacinaController {
	VacinaDAO _dao;
	
	public VacinaController(){
		_dao = new VacinaDAO();
	}
	
	public boolean CreateVacina(String nome, String dataAplicacao, int animalId) throws Exception {
		Vacina vacina = new Vacina(nome, dataAplicacao, animalId);
		return _dao.CreateVacina(vacina);
	}
	public boolean updateVacina(int id, String nome, String dataAplicacao, int animalId) throws Exception {
		Vacina vacina = new Vacina(id, nome, dataAplicacao, animalId);
		return _dao.UpdateVacina(vacina);
	}

	public ArrayList<Vacina> GetVacinasByAnimalId(int id) throws Exception {
		return _dao.GetVacinaByAnimalId(id);
	}

	public  boolean deleteVacina(int id) throws Exception {
		return _dao.DeleteVacina(id);
	}
}
