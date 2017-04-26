package ru.kle10wka.table;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="book")
public class Book implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="id")
	private int id;
		
	@Column(name="name")
	private String name;
		
	@Column(name="pages")
	private int pages;
		
	@Column(name="genre")
	private String genre;
		
	public Book (){
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Book(int id, String name, int pages, String genre) {
		this.id = id;
		this.name = name;
		this.pages = pages;
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Book [ id= " + id + ", name= " + name + ", pages= " + pages + ", genre= " + genre;
	}	

}