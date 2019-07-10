package com.mj.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mj.pojos.AllCarsView;
import com.mj.users.Cars;
import com.mj.utility.ConnectionService;

public class carDaoImpl implements carDao {

	public ConnectionService cf = ConnectionService.getInstance();
	public Connection conn = cf.getConnection();

	@Override
	public void createCar(Cars c) throws SQLException {
		
		//Connection conn = cf.getConnection();
		
		String sql = "INSERT INTO CARS VALUES(CARSEQ.NEXTVAL,?,?,?,?,?,?,?)";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, c.getCarMake());
		ps.setString(2, c.getCarModel());
		ps.setInt(3, c.getYearMake());
		ps.setDouble(4, c.getPrice());
		ps.setInt(5, c.getMileage());
		ps.setString(6, c.getLot());
		ps.setString(7, c.getCar_Status());
		
		ps.executeUpdate();
	}

	// public List<Cars> getAllCars() throws SQLException;

	@Override
	public ArrayList<Cars> getAllCars() throws SQLException {

		ArrayList<Cars> carList = new ArrayList<>();
		
		
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM CARS WHERE CAR_STATUS = 'Actif' ");

			Cars c = null;

			while (rs.next()) {
				carList.add(new Cars(rs.getInt(1), rs.getString("CAR_MAKE"), rs.getString("CAR_MODEL"),
						rs.getInt("YEAR_MAKE"), rs.getDouble("PRICE"), rs.getInt("MILEAGE"), rs.getString("LOT"),
						rs.getString("CAR_STATUS")));
			}

		return carList;
	}

	
	
	@Override

	public List<Cars> getCarByVIN(Integer VIN) throws SQLException {
		Scanner sc = new Scanner(System.in);
		int v1=1;

		ArrayList<Cars> carList = new ArrayList<>();
		
		System.out.println("Please provide the Car VIN 1-5 ");
		Connection conn = cf.getConnection();
		Statement ps = conn.createStatement();
		((PreparedStatement) ps).setInt(1, v1);
		  //PreparedStatement stmt = conn.prepareStatement(sql);
		
		
		
		ResultSet rs = ps.executeQuery("SELECT * FROM CARS WHERE CAR_VIN = ? ");
		//stmt.setCarVIN(1, v1);


		Cars c = null;
			
				if (rs.next()) {
					
					carList.add(new Cars(rs.getInt(1), rs.getString("CAR_MAKE"), rs.getString("CAR_MODEL"),
						rs.getInt("YEAR_MAKE"), rs.getDouble("PRICE"), rs.getInt("MILEAGE"), rs.getString("LOT"),
						rs.getString("CAR_STATUS")));
				}

		return carList;
	}
	
}
