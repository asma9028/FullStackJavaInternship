package com.wipro.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wipro.book.bean.AuthorBean;
import com.wipro.book.util.DBUtil;

public class AuthorDAO {
	private AuthorBean author = null;
	private Connection con;
	public AuthorBean getAuthor(int authorCode) {
		try {
			con = DBUtil.getDBConnection();
			String query = "Select * from AUTHOR_TBL where author_code=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, authorCode);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				author = new AuthorBean();
				author.setAuthorCode(rs.getInt(1));
				author.setAuthorName(rs.getString(2));
				author.setContactNo(rs.getLong(3));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return author;
		
	}
	
	public AuthorBean getAuthor(String authorName) {
		try {
			con = DBUtil.getDBConnection();
			String query = "Select * from AUTHOR_TBL where author_name=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, authorName);
			author = new AuthorBean();
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				author.setAuthorCode(rs.getInt(1));
				author.setAuthorName(rs.getString(2));
				author.setContactNo(rs.getLong(3));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return author;
	}
}
