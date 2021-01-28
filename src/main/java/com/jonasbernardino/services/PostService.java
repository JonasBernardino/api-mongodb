package com.jonasbernardino.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonasbernardino.entities.Post;
import com.jonasbernardino.repository.PostRepository;
import com.jonasbernardino.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository userRepository;

	public Post findById(String id) {
		Optional<Post> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	
	

}
