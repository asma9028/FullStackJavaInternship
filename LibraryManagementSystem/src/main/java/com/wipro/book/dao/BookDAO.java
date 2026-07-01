package com.wipro.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wipro.book.bean.AuthorBean;
import com.wipro.book.bean.BookBean;
import com.wipro.book.util.DBUtil;

public class BookDAO {
	private Connection con;
	private BookBean book = null;
	private AuthorDAO authordao = new AuthorDAO();
	public BookBean fetchBook(String isbn) {
		try {
			AuthorBean author = null;
			con = DBUtil.getDBConnection();
			String query1 = "Select author_code from BOOK_TBL where isbn=?";
			PreparedStatement ps1 = con.prepareStatement(query1);
			ps1.setString(1, isbn);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()) {
			int author_code = rs1.getInt(1);
			author = authordao.getAuthor(author_code);
			}
			String query2 = "Select * from BOOK_TBL where isbn=?";
			PreparedStatement ps = con.prepareStatement(query2);
			ps.setString(1,isbn);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				book = new BookBean();
				book.setIsbn(rs.getString(1));
				book.setBookName(rs.getString(2));
				book.setAuthor(author);
				book.setBookType(rs.getString(4).charAt(0));
				book.setCost(rs.getFloat(5));
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
	
	public int createBook(BookBean bookBean) {
		try {
			con = DBUtil.getDBConnection();
			String query = "Insert into BOOK_TBL (ISBN,BOOK_TITLE,AUTHOR_CODE,BOOK_TYPE,BOOK_COST) values (?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, bookBean.getIsbn());
			ps.setString(2, bookBean.getBookName());
			ps.setString(4, String.valueOf(bookBean.getBookType()));
			ps.setInt(3, bookBean.getAuthor().getAuthorCode());
			ps.setFloat(5, bookBean.getCost());
			int rows = ps.executeUpdate();
			return rows;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
}
