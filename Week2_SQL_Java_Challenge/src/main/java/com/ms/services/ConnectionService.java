package com.ms.services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionService {

	// singleton connection factory

	private static ConnectionService cf = new ConnectionService();

	// constructor

	private ConnectionService() {
		super();
	}

	// creates a sync'd instance of the ConnFactory if none exists and returns an
	// instance of itself
	public static synchronized ConnectionService getInstance() {
		if (cf == null) { // if no instance exists
			cf = new ConnectionService(); // create a new instance of the ConnFactory
		}
		return cf;
	}

	// attempts a connection with a sql database

	public Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();

		try {
			prop.load(new FileReader("database.properties"));
			Class.forName(prop.getProperty("driver"));

			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usr"),
					prop.getProperty("password"));

		} catch (FileNotFoundException e) { // file was not found
			e.printStackTrace();
		} catch (IOException e) { // IOException
			e.printStackTrace();
		} catch (SQLException e) { // SQLException
			e.printStackTrace();

		} catch (ClassNotFoundException e) { // ClassNotFound

			e.printStackTrace();
		}

		return conn;

	}

}
