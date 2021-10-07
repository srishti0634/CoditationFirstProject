package io.coditation.systems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(method=RequestMethod.POST,value="/addBook")
	public void addBook(@RequestBody Books book){
		if(book.getAuthorSet()!=null && book.getAuthorSet().size()>0) {
			Set<Authors> temp=book.getAuthorSet();
			book.setAuthorSet(new HashSet<>());
			for(Authors a:temp) {
				List<Authors> authors = authorService.findByAuthorName(a.getAuthorName());
				if(authors!=null && authors.size()>0) {
					authors.get(0).getBookSet().add(book);
					book.getAuthorSet().add(authors.get(0));
				}
				
			}
		}
		bookService.addBook(book);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/book/{id}")
	public void deleteBookById(@PathVariable Integer id){
		bookService.deleteBookById(id);
	}
}
