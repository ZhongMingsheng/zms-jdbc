package com.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class BaseConnection {
	public static void main(String[] args) {
		try {
			Driver driver = new com.mysql.jdbc.Driver();
			Properties properties = new Properties();
			properties.load(new FileInputStream("jdbc.properties"));
			Connection connection = driver.connect("jdbc:mysql://localhost:3306/tx", properties);
			System.out.println(connection);
			Statement createStatement = connection.createStatement();
			ResultSet executeQuery = createStatement.executeQuery("SELECT `isbn`,`book_name`,`price` FROM `tx`.`book` LIMIT 1;");
			int row = executeQuery.getRow();
			System.out.println(row);
			createStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
