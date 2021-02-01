package com.robson.workshopmongo.services.exception;

//RuntimeException é uma exceção que o compilador não exige que a trate
public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String msg) {
		//Repassando a mensagem para a superclasse RunTimeException
		super(msg);
	}

}
