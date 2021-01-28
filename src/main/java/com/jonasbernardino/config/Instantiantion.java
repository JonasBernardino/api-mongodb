package com.jonasbernardino.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jonasbernardino.dto.AuthorDTO;
import com.jonasbernardino.entities.Post;
import com.jonasbernardino.entities.User;
import com.jonasbernardino.repository.PostRepository;
import com.jonasbernardino.repository.UserRepository;

@Configuration
public class Instantiantion implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GNT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/2/2222"),	"vamos", "Vou viajar para São Paulo. Abraços",new AuthorDTO( maria));
		Post post2 = new Post(null, sdf.parse("21/2/3333"),	"cheguei", "Vou viajar para cabedelo. Abraços", new AuthorDTO( maria));
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		maria.getPost().addAll(Arrays.asList(post1,post2));
		
		userRepository.save(maria);
	}

}
