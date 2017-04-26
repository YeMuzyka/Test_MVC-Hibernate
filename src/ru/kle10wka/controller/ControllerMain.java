package ru.kle10wka.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kle10wka.service.BookService;
import ru.kle10wka.table.Book;

@Controller
public class ControllerMain {
	@Resource(name="bookService")
	private BookService bookService;
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String helloWorld (ModelMap modelMap) {
		modelMap.addAttribute("message", "Hello World from Spring_MVC");
		return "hello";
	}
	
	@RequestMapping(value="/books", method=RequestMethod.GET)
	public String allList(Model model){
		List<Book> books = bookService.getAll();
		model.addAttribute("books", books);
		return "books";
	}
	
	@RequestMapping(value = "/books/add", method = RequestMethod.GET)
    public String getAdd(Model model) {
		model.addAttribute("bookAttribute", new Book());
		return "addpage";
	}
 
    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("bookAttribute") Book book) {
    	bookService.add(book);
    	return "addedpage";
    }
     
    @RequestMapping(value = "/books/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value="id", required=true) Integer id, Model model) {
    	bookService.delete(id);
    	model.addAttribute("id", id);
    	return "deletedpage";
    }
		
}