package com.digipets.model;

public class Animal {
	private int idPet;
	private String nome;
	private String raca;
	private String sexo;
	private String especie;
	private int idDono;

	public Animal(String nome, String raca, String sexo, String especie, int idDono) {

		this.nome = nome;
		this.raca = raca;
		this.sexo = sexo;
		this.especie = especie;
		this.idDono = idDono;
	}
	public Animal() {

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
}
