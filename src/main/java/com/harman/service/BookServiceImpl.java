package com.harman.service;

import java.util.ArrayList;
import java.util.List;

import com.harman.dao.BookDAO;
import com.harman.dao.BookDAOImpl;
import com.harman.exception.LibraryException;
import com.harman.model.Book;

public class BookServiceImpl implements BookService {
	
	private BookDAO bookDAO;
	public BookServiceImpl() {
		bookDAO = new BookDAOImpl();
	}
	
	public Book add(Book book) throws LibraryException{
		if(book != null) {
			validateBook(book);
			bookDAO.add(book);
		}
		return book;
	}
	
	public Book save(Book book) throws LibraryException{
		if(book != null) {
			validateBook(book);
			bookDAO.save(book);
		}
		return book;
	}
	
	public void remove(Integer bookCode) throws LibraryException{
		bookDAO.remove(bookCode);
	}
	
	public List<Book> listAll() throws LibraryException{
		return bookDAO.listAll();
	}
	
	public Book getById(Integer bookCode) throws LibraryException{
		return bookDAO.getById(bookCode);
	}
	
	private boolean isValidBookCode(int bookCode) {
		return bookCode > 0;
	}
	
	private boolean isValidTitle(String title) {
		return title !=null && title.length() >= 3 && title.length() <=50;
	}
	
	private boolean isValidPrice(double price) {
		return price >= 0;
	}
	
	private boolean isValidCategory(String category) {
		return category !=null && category.length() >= 3 && category.length() <=50;
	}
	
	private void validateBook(Book book) throws LibraryException{
		List<String> errMessage = new ArrayList<String>();
		
		if(!isValidBookCode(book.getBookCode())) {
			errMessage.add("Book code cannot be negative");
		}
		
		if(!isValidTitle(book.getTitle())) {
			errMessage.add("Book title cannot be left blank and must be of 4 to 50 characters");
		}
		if(!isValidPrice(book.getPrice())) {
			errMessage.add("Price cannot be negative");
		}
		if(!isValidCategory(book.getCategory())) {
			errMessage.add("Category cannot be left blank and must be of 3 to 50 characters");
		}
		if(!errMessage.isEmpty()) {
			throw new LibraryException();
		}
	}
}
