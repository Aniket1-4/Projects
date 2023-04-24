package com.jspiders.studentmanagament1.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Operations {

	private static Connection connection;
	private static PreparedStatement pstm;
	private static ResultSet resultSet;
	private static int result;
	private static String query;
	private static String dburl;
	private static String driverPath;
	private static Scanner scanner = new Scanner(System.in);

	public static void openConnection() {

		try {
			String user = "root";
			String pass = "root";
			dburl = "jdbc:mysql://localhost:3306/wejm4?stud";
			driverPath = "com.mysql.cj.jdbc.Driver";

			Class.forName(driverPath);
			connection = DriverManager.getConnection(dburl, user, pass);
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
			if (pstm != null) {

				pstm.close();

			}
			if (resultSet != null) {

				resultSet.close();

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void addStudent() {
		
		try {

			openConnection();

			query = "insert into stud(id,name,email,city) values(?,?,?,?)";

			pstm = connection.prepareStatement(query);

			System.out.println("Enter Student id");
			int id = scanner.nextInt();
			pstm.setInt(1, id);

			System.out.println("Enter Student name");
			String name = scanner.next();
			pstm.setString(2, name);

			System.out.println("Enter Student email");
			String email = scanner.next();
			pstm.setString(3, email);

			System.out.println("Enter Student city");
			String city = scanner.next();
			pstm.setString(4, city);

			result = pstm.executeUpdate();

			if (result != 0) {

				System.out.println("Student added successfully...!!");

			} else {

				System.err.println("Something went wrong..!!");

			}

			closeConnection();

		} catch (Exception e ) {
			e.printStackTrace();
		}

	}

	public static void searchStudent() {
		
		try {
			
			openConnection();
			
			query="select * from stud where id=?";
			
			pstm=connection.prepareStatement(query);
			
			System.out.println("Enter student id");
			int id=scanner.nextInt();
			pstm.setInt(1, id);
			
			resultSet=pstm.executeQuery();
			
			while(resultSet.next()) {
				
				System.out.println(resultSet.getInt(1)+"|"
						+ resultSet.getString(2)+"|"
						+ resultSet.getString(3)+"|"
						+ resultSet.getString(4));
				
			}
			
			closeConnection();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void updateStudent() {
		
		try {
			
			openConnection();
			
			query="update stud set email=? where id=?";
			
			pstm=connection.prepareStatement(query);
			System.out.println("Update email");
			String email=scanner.next();
			pstm.setString(1, email);
			
			System.out.println("Enter student id");
			int id=scanner.nextInt();
			pstm.setInt(2, id);
			
			result=pstm.executeUpdate();
			
			if (result != 0) {
				
				System.out.println("Student updated Successfully..!!");
				
			}
			
			closeConnection();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void deleteStudent() {
		
		try {
			
			openConnection();
			
			query="delete from stud where id=?";
			
			pstm=connection.prepareStatement(query);
			
			System.out.println("Enter student id");
			int id=scanner.nextInt();
			pstm.setInt(1, id);
			
			result=pstm.executeUpdate();
			
			if (result != 0) {
				
				System.out.println("Student deleted Successfully..!!");
				
			}
			
			closeConnection();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void main(String[] args) {

		while (true) {

			System.out.println("Press 1 to add Student");
			System.out.println("Press 2 to show Student");
			System.out.println("Press 3 to update Student");
			System.out.println("Press 4 to delete Student");
			System.out.println("Press 5 to Exit");
			int c = Integer.parseInt(scanner.next());

			if (c == 1) {

				addStudent();

			} else if (c == 2) {

				searchStudent();

			} else if (c == 3) {

				updateStudent();

			} else if (c == 4) {

				deleteStudent();

			} else if (c == 5) {

				break;

			} else {

				System.err.println("Invalid choise..!!");

			}
		}

		System.out.println("Thankyou for using the Application ");

	}

}
