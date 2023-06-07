package com.digipets.model;

public class Vacina {
	private int id;
	private int animalId;
	private String nome;
	private String dataAplicacao;

	public Vacina(String nome, String dataAplicacao, int animalId) throws Exception {
		Validate(nome, dataAplicacao, animalId);
	}
	
	public Vacina(int id, String nome, String dataAplicacao, int animalId) throws Exception {
		Validate(nome, dataAplicacao, animalId);
		this.id = id;
	}

	private void Validate(String nome, String dataAplicacao, int animalId) throws Exception {
		if(nome != null && nome.length() > 0 &&  dataAplicacao != null && animalId !=0) {
			this.nome = nome;
			this.dataAplicacao = dataAplicacao;
			this.animalId = animalId;
		}
		else {
			throw new Exception("Os dados da vacina são inválidos!");
		}
	}
	
	public int getAnimalId() {
		return animalId;
	}

	public void setAnimalId(int animalId) {
		this.animalId = animalId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataAplicacao() {
		return dataAplicacao;
	}

	public void setDataAplicacao(String dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
	}
	




}
