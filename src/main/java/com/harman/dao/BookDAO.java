package com.harman.dao;

import java.util.List;

import com.harman.exception.LibraryException;
import com.harman.model.Book;

public interface BookDAO {
	Book add(Book book) throws LibraryException;
	Book save(Book book) throws LibraryException;
	void remove(Integer bookCode) throws LibraryException;
	List<Book> listAll() throws LibraryException;
	Book getById(Integer bookCode) throws LibraryException;
}
