package com.gustavo.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.gustavo.DAO.ClienteDAO;
import com.gustavo.DAO.VacinaDAO;
import com.gustavo.control.ExceptionDAO;

public class Vacina {

	private int codigo;
	private int codPet;
	private String nome;
	private String dataAplicacao;


	
	public Vacina(String nome, String dataAplicacao, int codPet) {
		this.codigo = codPet;
		this.nome = nome;
		this.dataAplicacao = dataAplicacao;
		this.codPet = codPet;

	}
	
	public Vacina(){}

	public int getCodPet() {
		return codPet;
	}

	public void setCodPet(int codPet) {
		this.codPet = codPet;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	public static void cadastrarVacina(Vacina vacina) throws ExceptionDAO, SQLException {
		new VacinaDAO().cadastrarVacina(vacina);
	}
	public static void alterarVacina(Vacina vacina) throws ExceptionDAO, SQLException {
		new VacinaDAO().alterarVacina(vacina);
	}

	public ArrayList<Vacina> listarVacinaPet(int codigo) throws ExceptionDAO, SQLException{
		return new VacinaDAO().listarVacinaPet(codigo);
	}
	public static void deletarVacina(int cod) throws ExceptionDAO, SQLException {
		new VacinaDAO().deletarVacina(cod);
	}




}
