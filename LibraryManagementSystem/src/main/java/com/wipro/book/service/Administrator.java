package com.wipro.book.service;

import com.wipro.book.bean.BookBean;
import com.wipro.book.dao.BookDAO;

public class Administrator {
	private BookDAO bookdao;
	public String addBook(BookBean bookBean) {
		
		
		
		System.out.println("ISBN: " + bookBean.getIsbn());
		System.out.println("Book Name: " + bookBean.getBookName());
		System.out.println("Book Type: " + bookBean.getBookType());
		System.out.println("Cost: " + bookBean.getCost());

		if(bookBean.getAuthor() != null) {
		    System.out.println("Author Code: " + bookBean.getAuthor().getAuthorCode());
		    System.out.println("Author Name: " + bookBean.getAuthor().getAuthorName());
		} else {
		    System.out.println("Author is NULL");
		}    
		
		
		
		
		if(bookBean != null && bookBean.getBookName()!=null && bookBean.getIsbn()!=null && (bookBean.getBookType()=='G' || bookBean.getBookType()=='T') && bookBean.getCost()>0 && bookBean.getAuthor()!=null && bookBean.getAuthor().getAuthorName()!=null) {
			bookdao = new BookDAO();
			int rows = bookdao.createBook(bookBean);
			if(rows == 1) {
				return "SUCCESS";
			}
			else {
				return "FAILURE";
			}
		}

		return "INVALID";
	}
	
	public BookBean viewBook(String isbn) {
		bookdao = new BookDAO();
		BookBean book = bookdao.fetchBook(isbn);
		return book;
	}
}
