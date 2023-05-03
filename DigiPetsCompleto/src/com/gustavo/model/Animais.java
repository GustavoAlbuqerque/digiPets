package com.gustavo.model;

import java.sql.SQLException;
import java.util.ArrayList;

import com.gustavo.DAO.AnimalDAO;
import com.gustavo.control.ExceptionDAO;

public class Animais {
	private int idPet;
	private String nome;
	private String raca;
	private String sexo;
	private String especie;
	private int idDono;

	public Animais(String nome, String raca, String sexo, String especie, int idDono) {

		this.nome = nome;
		this.raca = raca;
		this.sexo = sexo;
		this.especie = especie;
		this.idDono = idDono;
	}
	public Animais() {

	}

	public int getIdPet() {
		return idPet;
	}

	public void setIdPet(int idPet) {
		this.idPet = idPet;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public int getIdDono() {
		return idDono;
	}

	public void setIdDono(int idDono) {
		this.idDono = idDono;
	}

	public static void cadastrarAnimais(Animais animal) throws ExceptionDAO {
		new AnimalDAO().cadastrarAnimais(animal);
	}

	public ArrayList<Animais> listarAnimais() throws ExceptionDAO, SQLException{
		return new AnimalDAO().listarAnimais();
	}

	public ArrayList<Animais> listarAnimaisClienteCompleto(int idDono) throws ExceptionDAO, SQLException{
		return new AnimalDAO().listarAnimaisClienteCompleto(idDono);
	}
	public ArrayList<Animais> listarAnimaisCliente(int idPet) throws ExceptionDAO, SQLException{
		return new AnimalDAO().listarAnimaisCliente(idPet);
	}

}
