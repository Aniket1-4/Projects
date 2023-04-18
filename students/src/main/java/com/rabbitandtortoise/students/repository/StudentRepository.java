package com.rabbitandtortoise.students.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rabbitandtortoise.students.pojo.StudentPOJO;

@Repository
public class StudentRepository {

	private static Connection connection;
	private static PreparedStatement statement;
	private static ResultSet resultSet;
	private static int result;
	private static String query;
	private static String dburl = "jdbc:mysql://localhost:3306/wejm4";
	private static String user = "root";
	private static String password = "root";

	private static void openConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(dburl, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void closeConnection() {

		try {

			if (connection != null) {
				connection.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {

			e.printStackTrace();

		}
	}

	public StudentPOJO addStudent(int id, String name, String email) {
		openConnection();
		query = "insert into students1 values (?, ?, ?)";
		try {
			statement = connection.prepareStatement(query);

			statement.setInt(1, id);
			statement.setString(2, name);
			statement.setString(3, email);
			result = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		if (result == 1) {
			StudentPOJO student = new StudentPOJO();
			student.setId(id);
			student.setName(name);
			student.setEmail(email);
			return student;
		}
		return null;
	}

	public StudentPOJO search(int id) {

		openConnection();
		StudentPOJO student = new StudentPOJO();

		query = "select * from students1 where id=" + id;

		try {
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {

				student.setId(resultSet.getInt(1));
				student.setName(resultSet.getString(2));
				student.setEmail(resultSet.getString(3));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeConnection();

		return student;

	}

	public List<StudentPOJO> searchAll() {

		openConnection();
		List<StudentPOJO> students = new ArrayList<StudentPOJO>();

		query = "select * from students1";
		try {
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {

				StudentPOJO student = new StudentPOJO();
				student.setId(resultSet.getInt(1));
				student.setName(resultSet.getString(2));
				student.setEmail(resultSet.getString(3));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeConnection();

		return students;
	}

	public int update(int id, String name, String email) {

		openConnection();

		query = "update students1 set student_name =?, Student_email= ? where id=?";
		try {
			statement = connection.prepareStatement(query);

			statement.setInt(3, id);
			statement.setString(1, name);
			statement.setString(2, email);
			result = statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeConnection();
		return result;

	}

	public int delete(int id) {

		openConnection();

		query = "delete from students1 where id=?";
		try {
			statement = connection.prepareStatement(query);

			statement.setInt(1, id);

			result = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeConnection();
		return result;

	}

}
