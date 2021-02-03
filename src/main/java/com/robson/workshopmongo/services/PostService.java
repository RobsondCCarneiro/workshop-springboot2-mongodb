package com.robson.workshopmongo.services;

import java.util.Date;
import java.util.List;
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
	
	public List<Post> findByTitle(String text){
		//return repo.findByTitleContainingIgnoreCase(text);
		return repo.searchTitle(text);
	}
	
	//Este método é para a busca com vários critérios
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		/*
		 * Como a data é calculada, porque o tipo da data é instant (milissegundo),
		 * então é necessário fazer o método para comparar o dia seguinte a data informada
		 * a meia-noite para incluir até 23:59:59 da data máxima informada
		 */
		maxDate = new Date(maxDate.getTime() + 24*60*60*1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
}
