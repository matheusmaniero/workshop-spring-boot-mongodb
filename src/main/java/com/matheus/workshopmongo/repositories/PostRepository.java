package com.matheus.workshopmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.matheus.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	public List<Post> customFindByTitle(String text);
	
	public List<Post> findByTitleContainingIgnoreCase(String text);

}
