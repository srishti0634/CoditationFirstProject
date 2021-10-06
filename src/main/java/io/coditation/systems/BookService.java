package io.coditation.systems;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	public List<Books> getBooksList(){
		return bookRepository.findAll();
	}
	
	public Books getBookById(Integer id) {
		return bookRepository.findById(id).orElse(null);
	}

	public void addBook(Books newBook) {
		bookRepository.save(newBook);		
	}

	public void deleteBookById(Integer id) {
		bookRepository.deleteById(id);		
	}
	
}
