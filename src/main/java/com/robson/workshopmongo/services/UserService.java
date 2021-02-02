package com.robson.workshopmongo.services;

import java.util.List;
import java.util.Optional;

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
	 * Foi descontinuado o método findOne(id)
	 * User user = repo.findOne(id);
	 * Então foi implementado o de baixo
	 */
	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		 
		//User user = repo.findOne(id);
		
		if(user.isEmpty()) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user.get();
	}
	
	//Metodos criados para inserir dados na tabela de do Banco de Dados
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	/*
	public User update(User obj) {
		Optional<User> newObj = repo.findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj.get());
	}
	
	//Atenção: Tenho que encontrar uma forma de acessar os métodos dentro do Optional
	private void updateData(Optional<User> newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	*/
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
