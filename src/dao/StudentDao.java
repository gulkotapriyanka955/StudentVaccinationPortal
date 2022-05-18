package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connectdb.ConnectDb;
import model.Student;

public class StudentDao {

	ConnectDb connectDb = new ConnectDb();
	Connection connection;

	public String studentDetails(Student sd) throws SQLException {
		String insert_Student_Details = "INSERT INTO javaproject.student(emailId , password, ucmo_ID , firstName , lastName , department , contactNumber) VALUES  ( ?,?,?,?,?,?,? );";
		String result = "";
		Student student = getStudent(sd.getEmailId());
		if (student.getEmailId() == null) {
			connection = connectDb.getDbConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(insert_Student_Details);
			preparedStatement.setString(1, sd.getEmailId());
			preparedStatement.setString(2, sd.getPassword());
			preparedStatement.setString(3, sd.getUcmo_ID());
			preparedStatement.setString(4, sd.getFirstName());
			preparedStatement.setString(5, sd.getLastName());
			preparedStatement.setString(6, sd.getDepartment());
			preparedStatement.setString(7, sd.getContactNumber());

			preparedStatement.executeUpdate();
			result = "success";
		} else {
			result = "fail";
		}
		connection.close();
		return result;
	}

	public String updateStudentDetails(Student student) throws SQLException {
		String update_Student_Details = "UPDATE javaproject.student SET " + " ucmo_ID =\'" + student.getUcmo_ID()
				+ "\', firstName=\'" + student.getFirstName() + "\' ,lastName =\'" + student.getLastName()
				+ "\' , department=\'" + student.getDepartment() + "\' , contactNumber=\'" + student.getContactNumber()
				+ "\' WHERE emailId= \'" + student.getEmailId() + "\'";
		String result;
		System.out.println(update_Student_Details);
		connection = connectDb.getDbConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(update_Student_Details);
		int count = preparedStatement.executeUpdate();
		if (count == 1) {
			result = "success";
		} else {
			result = "fail";
		}
		connection.close();
		return result;
	}

	public List<Student> getStudentsList() throws SQLException {
		String get_Students_List = "SELECT * FROM javaproject.student";
		List<Student> studentsList = new ArrayList<Student>();
		connection = connectDb.getDbConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(get_Students_List);
		System.out.println(preparedStatement);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			Student student = new Student();
			student.setStudent_ID(rs.getInt(1));
			student.setEmailId(rs.getString(2));
			student.setPassword(rs.getString(3));
			student.setUcmo_ID(rs.getString(4));
			student.setFirstName(rs.getString(5));
			student.setLastName(rs.getString(6));
			student.setDepartment(rs.getString(7));
			student.setContactNumber(rs.getString(8));
			studentsList.add(student);
		}
		connection.close();
		return studentsList;
	}

	public Student getStudent(String emailId) throws SQLException {
		String get_Student_info = "SELECT * FROM javaproject.student where emailId = \'" + emailId + "\'";
		Student student = new Student();
		connection = connectDb.getDbConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(get_Student_info);
		System.out.println(preparedStatement);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			student.setStudent_ID(rs.getInt(1));
			student.setEmailId(rs.getString(2));
			student.setPassword(rs.getString(3));
			student.setUcmo_ID(rs.getString(4));
			student.setFirstName(rs.getString(5));
			student.setLastName(rs.getString(6));
			student.setDepartment(rs.getString(7));
			student.setContactNumber(rs.getString(8));

		}
		connection.close();
		return student;
	}

	public Student checkLogin(String emailId, String password) throws SQLException {
		connection = connectDb.getDbConnection();
		String validate = "SELECT * FROM student WHERE emailId = ? and password = ?";
		PreparedStatement statement = connection.prepareStatement(validate);
		statement.setString(1, emailId);
		statement.setString(2, password);
		ResultSet result = statement.executeQuery();

		Student student = null;
		if (result.next()) {
			student = new Student();
			student.setFirstName(result.getString("firstName"));
			student.setEmailId(result.getString("emailId"));
			student.setStudent_ID(result.getInt("student_ID"));
		}

		connection.close();

		return student;
	}

}
