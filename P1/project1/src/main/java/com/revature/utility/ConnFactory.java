package com.revature.utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {

	//Singleton Factory
		private static ConnFactory cf= new ConnFactory();

		//constructor
		private ConnFactory() {
			super();

		}
		public static synchronized ConnFactory getInstance() {
			if(cf==null) {
				cf= new ConnFactory();
			}
			return cf;
		}

		public Connection getConnection() {
			Connection conn =null;
			Properties prop = new Properties();

			try {
				InputStream stream = this.getClass().getResourceAsStream("/database.properties");
				prop.load(stream);

				//prop.load(new FileReader("database.properties"));
				Class.forName(prop.getProperty("driver"));
				conn= DriverManager.getConnection(
						prop.getProperty("url"), 
						prop.getProperty("usr"),
						prop.getProperty("password"));

			} catch (FileNotFoundException e) {			
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return conn;
		}

	}

