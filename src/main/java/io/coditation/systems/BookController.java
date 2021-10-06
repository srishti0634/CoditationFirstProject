package io.coditation.systems;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private AuthorService authorService;
	
	@RequestMapping("/allBooks")
	public List<Books> getAllBooks(){
		return bookService.getBooksList();
	}
	
	@RequestMapping("/book/{id}")
	public Books getBookById(@PathVariable Integer id){
		return bookService.getBookById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/book")
	public void addBook(@RequestBody Books newBook){
		bookService.addBook(newBook);
	}
	
//	@RequestMapping(method=RequestMethod.POST,value="/addBook")
//	public void addBook(@RequestBody String bookName,@RequestBody String authorName){
//		Authors author = authorService.findAuthorByName(authorName);
//		Books newBook=new Books();
//		newBook.setBookName(bookName);
//		newBook.getAuthorSet().add(author);
//		bookService.addBook(newBook);
//	}
//	
	@RequestMapping(method=RequestMethod.DELETE,value="/book/{id}")
	public void deleteBookById(@PathVariable Integer id){
		bookService.deleteBookById(id);
	}
}
