package com.journaldev.servlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.journaldev.servlet.jdbc.JDBCUtil;
import com.journaldev.servlet.model.User;

public class UserDAOImpl implements UserDAO {

	private Connection dbConnection;
	private PreparedStatement pStmt;

	private String SQL_SELECT = "SELECT name, address FROM users WHERE email = ? AND password = ?";
	private String SQL_INSERT = "INSERT INTO users (name,email,password,address) VALUES (?,?,?,?)";

	public UserDAOImpl() {
		dbConnection = JDBCUtil.getConnection();
	}

	public User loginUser(User user) {
		try {
			pStmt = dbConnection.prepareStatement(SQL_SELECT);
			pStmt.setString(1, user.getEmail());
			pStmt.setString(2, user.getPassword());
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				user.setName(rs.getString("name"));
				user.setAddress(rs.getString("address"));
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return user;
	}

	public int createUser(User user) {
		int result = 0;
		try {
			pStmt = dbConnection.prepareStatement(SQL_INSERT);
			pStmt.setString(1, user.getName());
			pStmt.setString(2, user.getEmail());
			pStmt.setString(3, user.getPassword());
			pStmt.setString(4, user.getAddress());
			result = pStmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return result;
	}
}