package com.robson.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robson.workshopmongo.domain.User;
import com.robson.workshopmongo.dto.UserDTO;
import com.robson.workshopmongo.repository.UserRepository;
import com.robson.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	//O autowired faz o Spring instanciar automaticamente (mecanismo de injecao de dependencia automatica)
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}

	/*
	 * Desconfio que o erro é porque ele não aceita a seguinte linha
	 * User user = repo.findOne(id);
	 * talvez por isso que o código não reconhece o id.
	 */
	public User findById(String id) {
		Object user = repo.findById(id);
		//User user = repo.findOne(id);
		if(user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return (User) user;
	}
	
	//Metodos criados para inserir dados na tabela de do Banco de Dados
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
