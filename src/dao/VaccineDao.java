package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectdb.ConnectDb;
import model.Vaccine;

public class VaccineDao {

	public VaccineDao() {
		super();// TODO Auto-generated constructor stub
	}

	ConnectDb connectDb = new ConnectDb();
	Connection connection;

	public List<Vaccine> getVaccine() throws SQLException {

		List<Vaccine> vaccines = new ArrayList<Vaccine>();
		connection = connectDb.getDbConnection();
		String sql = "select * from javaproject.vaccine";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			Vaccine vaccine = new Vaccine();
			vaccine.setVaccine_ID(rs.getInt(1));
			vaccine.setVaccineName(rs.getString(2));
			vaccine.setManufacturer(rs.getString(3));
			vaccine.setType(rs.getString(4));
			vaccine.setCost(rs.getString(5));
			vaccines.add(vaccine);
		}

		return vaccines;
	}

	public Vaccine getVaccine(int id) throws SQLException {

		Vaccine vaccine = new Vaccine();
		connection = connectDb.getDbConnection();
		String sql = ("select * from vaccine where vaccine_ID =" + id);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			vaccine.setVaccine_ID(rs.getInt(1));
			vaccine.setVaccineName(rs.getString(2));
			vaccine.setManufacturer(rs.getString(3));
			vaccine.setType(rs.getString(4));
			vaccine.setCost(rs.getString(5));
		}

		return vaccine;
	}

	public List<String> getAvailableDates(int vaccine_ID) throws SQLException {

		List<String> availableDates = new ArrayList<String>();
		connection = connectDb.getDbConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select availableDate from vaccine_availability where vaccine_ID=" + vaccine_ID);
		while (rs.next()) {
			availableDates.add(rs.getString(1));
		}
		return availableDates;
	}
}
