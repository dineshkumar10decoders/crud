package com.sample.Employee;
import java.sql.*;

public class Database {
		Database(){
			
			connect();
		}
		
		public Connection con;
		
public void connect() {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		   con=DriverManager.getConnection(
		    "jdbc:mysql://localhost:3306/employee","root","10@Decoders");
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	}
