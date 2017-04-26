package ru.kle10wka.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kle10wka.table.Book;

@Service("bookService")
@Transactional
public class BookService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	public BookService(){
		
	}
	
	public List<Book> getAll(){
		List<Book> list = new ArrayList<Book>(); 
	    Session session = sessionFactory.getCurrentSession();
	    for (Object oneObject : session.createQuery("FROM Book").getResultList()) {
	        list.add((Book)oneObject);
	    }
		return list;
	}
	
	public void add(Book book) {
		Session session = sessionFactory.getCurrentSession();
		session.save(book);
	}
	
	public void delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Book book = (Book) session.get(Book.class, id);
		session.delete(book);
	}
	
}