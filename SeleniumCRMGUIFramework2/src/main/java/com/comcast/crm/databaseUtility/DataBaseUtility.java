package com.comcast.crm.databaseUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection conn;
	public void getDBConnection(String url, String username, String password) throws SQLException {
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		conn=DriverManager.getConnection(url,username,password);
		}catch(Exception e){
			
		}	
	}
	
	public void getDBConnection() throws IOException {
		FileInputStream fis=new FileInputStream("D:\\User\\Desktop\\ExcelFile\\database.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String DBLOC=prop.getProperty("dbloc");
		String USERNAME=prop.getProperty("username");
		String PASWORD=prop.getProperty("password");
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			DriverManager.getConnection(DBLOC, USERNAME, PASWORD);
			}catch(Exception e) {
				
			}
	}
	
	public void closeDBconnection() {
		try {
		conn.close();
		}catch(Exception e) {
			
		}
	}
	
	public ResultSet executeQuery(String query) {
		ResultSet result=null;
		try {
			Statement stmt=conn.createStatement();
			result=stmt.executeQuery(query);
		}catch(Exception e) {
			
		}
		return result;
	
	}
	public int nonselectQuery(String query) {
		int a=0;
		try {
			Statement stmt=conn.createStatement();
			a=stmt.executeUpdate(query);
			}catch(Exception e) {
				
			}
		return a;
	}

	
	
	}


