package com.robson.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robson.workshopmongo.domain.Post;
import com.robson.workshopmongo.repository.PostRepository;
import com.robson.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	//O autowired faz o Spring instanciar automaticamente (mecanismo de injecao de dependencia automatica)
	@Autowired
	private PostRepository repo;
	
	
	public Post findById(String id) {
		Optional<Post> user = repo.findById(id);
		 
		//User user = repo.findOne(id);
		
		if(user.isEmpty()) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user.get();
	}
}
