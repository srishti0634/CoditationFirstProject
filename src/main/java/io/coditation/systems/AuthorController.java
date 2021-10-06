package io.coditation.systems;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
	@Autowired
	private AuthorService authorService;
	
	@RequestMapping("/allAuthors")
	public List<Authors> getAllAuthors(){
		return authorService.getAuthorsList();
	}
	
	@RequestMapping("/author/{id}")
	public Authors getAuthorById(@PathVariable Integer id){
		return authorService.getAuthorById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/author")
	public void addAuthor(@RequestBody Authors newAuthor){
		authorService.addAuthor(newAuthor);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/author/{id}")
	public void deleteAuthorById(@PathVariable Integer id){
		authorService.deleteAuthorById(id);
	}
}
