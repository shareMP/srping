package com.mrl.spring.beans.properties;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-properties.xml");
		
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		
		Connection connection = dataSource.getConnection();
		
		PreparedStatement pstmt = connection.prepareStatement("select * from frame_user");
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			System.out.println(rs.getString("displayname"));
		}
		
		
	}

}
