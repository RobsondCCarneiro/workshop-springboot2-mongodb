/*
 * Como gostaríamos de armazenar apenas o Id e o nome do autor,
 * fazeremos esta projeção do autor 
 */

package com.robson.workshopmongo.dto;

import java.io.Serializable;

import com.robson.workshopmongo.domain.User;

public class AuthorDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	
	public AuthorDTO(){
		
	}
	
	public AuthorDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
