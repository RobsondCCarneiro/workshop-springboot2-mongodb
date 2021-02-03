package com.robson.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.robson.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

	//Método para buscar posts contendo um dado string no título
	//List<Post> findByTitleContaining(String text);
	
	//Para aceitar maiusculos e minusculos temos que ignorar o Case Sensitive
	List<Post> findByTitleContainingIgnoreCase(String text);

}
