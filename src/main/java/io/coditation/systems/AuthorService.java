package io.coditation.systems;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepository authorRepository;
	
	public List<Authors> getAuthorsList(){
		return authorRepository.findAll();
	}
	
	public Authors getAuthorById(Integer id) {
		return authorRepository.findById(id).orElse(null);
	}

	public void addAuthor(Authors newAuthor) {
		authorRepository.save(newAuthor);		
	}

	public void deleteAuthorById(Integer id) {
		authorRepository.deleteById(id);		
	}

	public List<Authors> findByAuthorName(String authorName) {
		return authorRepository.findByAuthorName(authorName);
	}
}
