package com.harman.ui;

import java.util.List;
import java.util.Scanner;

import com.harman.exception.LibraryException;
import com.harman.model.Book;
import com.harman.service.BookService;
import com.harman.service.BookServiceImpl;

public class LibraryManagementApplication {
		
		private static BookService bookService;
		private static Scanner scan;
		
		public static void main(String[] args) {
			
			bookService = new BookServiceImpl();
			scan = new Scanner(System.in);
			LibraryOperations choice = null;
			
			while(choice != LibraryOperations.QUIT) {
				System.out.println("Choice\t\tMenu");
				for(LibraryOperations opt : LibraryOperations.values()) {
					System.out.println(opt.ordinal()+ "\t\t" + opt);
				}
				System.out.println("Enter Choice");
				int  ch = scan.nextInt();
				
				if(ch >=0 && ch<LibraryOperations.values().length) {
					choice = LibraryOperations.values()[ch];
					
					switch(choice) {
					case ADD : doAdd();
							break;
					case UPDATE : doSave();
							break;
					case LIST :doList();
							break;
					case DELETE : doDelete();
							break;
					case QUIT : System.out.println("Terminated");
							break;
					}
				}
			}
		}
		
		private static void doAdd() {
			Book book = new Book();
			System.out.println("Enter bookCode");
			book.setBookCode(scan.nextInt());
			System.out.println("Enter Price");
			book.setPrice(scan.nextDouble());
			System.out.println("Enter Title");
			book.setTitle(scan.next());
			System.out.println("Enter Category");
			book.setCategory(scan.next());
			
			try {
				bookService.add(book);
				System.out.println("Book added successfully");
			}catch (LibraryException exp) {
				System.out.println("Error " +exp.getMessage());
			}
		}
		
		private static void doList() {
			try {
				List<Book> books = bookService.listAll();
				if(books == null || books.isEmpty()) {
					System.out.println("No Book Found");
				}else {
					for(Book book : books) {
						System.out.println(book.getBookCode() +"\t" + book.getTitle()+"\t" + book.getPrice()+"\t"+ book.getCategory());						
					}
				}
			}catch (LibraryException exp) {
				System.out.println("Error" + exp.getMessage());
			}
		}
		
		private static void doDelete() {
			System.out.println("Enter Book code");
			int bookCode = scan.nextInt();
			try {
				bookService.remove(bookCode);
				System.out.println("Book deleted");
			}catch (LibraryException exp) {
				System.out.println("Error" + exp.getMessage());
			}
		}
		
		private static void doSave() {
			System.out.println("Enter Book Code");
			Book book = new Book();
			int bookCode = scan.nextInt();
			try {
				
				System.out.println("Enter bookCide");
				book.setBookCode(scan.nextInt());
				System.out.println("Enter Price");
				book.setTitle(scan.next());
				System.out.println("Enter Category");
				book.setCategory(scan.next());
				book.setBookCode(bookCode);
				bookService.save(book);
				System.out.println("Book Updated");
				
			}catch (LibraryException exp) {
				System.out.println("Error" +exp.getMessage());
			}
		}


}
