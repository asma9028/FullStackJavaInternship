package com.wipro.book.servlets;

import java.io.IOException;

import com.wipro.book.bean.AuthorBean;
import com.wipro.book.bean.BookBean;
import com.wipro.book.dao.AuthorDAO;
import com.wipro.book.service.Administrator;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	public Administrator admin;
	public AuthorDAO authordao;
	public String addBook(HttpServletRequest request) {
		admin = new Administrator();
		authordao = new AuthorDAO();
		BookBean bookBean = new BookBean();
		String isbn = request.getParameter("isbn");
		String bookName = request.getParameter("bookName");
		String authorName = request.getParameter("authorName");
		AuthorBean author = authordao.getAuthor(authorName);
		
		
		
		System.out.println("Author selected from form: " + authorName);

		if(author == null) {
		    System.out.println("Author object is NULL");
		} else {
		    System.out.println("Author Code: " + author.getAuthorCode());
		    System.out.println("Author Name: " + author.getAuthorName());
		}
		
		
		
		
		String type = request.getParameter("bookType");
		char bookType = ' ';
		if(type!=null && !type.isEmpty()) {
			bookType=type.charAt(0);
		}
		float cost = Float.parseFloat(request.getParameter("bookCost"));
		bookBean.setAuthor(author);
		bookBean.setBookName(bookName);
		bookBean.setBookType(bookType);
		bookBean.setCost(cost);
		bookBean.setIsbn(isbn);
		String result = admin.addBook(bookBean);
		return result;
	}
	
	public 	BookBean viewBook(HttpServletRequest request) {
		admin = new Administrator();
		String isbn = request.getParameter("isbn");
		return admin.viewBook(isbn);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		if(operation.equals("AddBooks")) {
			String result = addBook(request);
			if(result.equals("SUCCESS")) {
				response.sendRedirect("Menu.html");
			}
			else if(result.equals("FAILURE")) {
				response.sendRedirect("Failure.html");
			}
			else {
				response.sendRedirect("Invalid.html");
			}
		}
		else if(operation.equals("Search")) {
			BookBean bookBean = viewBook(request);
			if(bookBean != null) {
				request.setAttribute("title", bookBean.getBookName());
				request.setAttribute("author", bookBean.getAuthor().getAuthorName());
				RequestDispatcher rd = request.getRequestDispatcher("View.jsp");
				rd.forward(request, response);
			}else {
				response.sendRedirect("Invalid.html");
			}
		}
		
	}

}
