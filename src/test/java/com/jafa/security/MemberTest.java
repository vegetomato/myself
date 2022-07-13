package com.jafa.security;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jafa.config.Apptest;

public class MemberTest extends Apptest{

	@Autowired
	DataSource dataSource;
	
	@Autowired
	@Qualifier(value = "뽈롱")
	PasswordEncoder encoder;
	
	
	@Test
	public void memberinsertTest() {
		String sql = "insert into member_tbl(userId,userPw,userName) values(?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "goku");
			pstmt.setString(2, encoder.encode("1234"));
			pstmt.setString(3, "손오공");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void admininsertTest() {
		String sql = "insert into member_tbl(userId,userPw,userName) values(?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "goku");
			pstmt.setString(2, encoder.encode("1234"));
			pstmt.setString(3, "손오공");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
