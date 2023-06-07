package com.digipets.exceptionHandler;

public class CadastrarVacinaException extends Exception{
	public CadastrarVacinaException() {
		super("Erro - Selecione: *Tutor > Animal* para cadastrar uma vacina!");
	}
}
