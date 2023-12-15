package com.takeo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class EnvironmentVariableTest {

	static List<Student> studentList = new ArrayList<Student>();

	public static void main(String... args) {
		try {
			Class.forName(System.getenv("sqlDriverclass"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ResultSetMetaData resultSetMetaData = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + System.getenv("sqlDatabase"),
					System.getenv("sqlUsername"), System.getenv("sqlPassword"));
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from " + System.getenv("tableName"));
			resultSetMetaData = resultSet.getMetaData();
			int numberOfColumn = resultSetMetaData.getColumnCount();

			while (resultSet.next()) {
				Student student = new Student();
				for (int i = 1; i <= numberOfColumn; i++) {
					System.out.println("Data type of column " + i + " = " + resultSetMetaData.getColumnTypeName(i));
					// Column Types : INT, VARCHAR

					String str = resultSet.getString(i);

					if(resultSetMetaData.getColumnTypeName(i).equals("VARCHAR")) {
						student.setString(str);
					}
					else if(resultSetMetaData.getColumnTypeName(i).equals("INT")) {
						if(i==5) {
							student.setYear(Year.parse(str));
						}
						else {
							student.setInt(Integer.parseInt(str));
						}
					}
					else {
						throw new RuntimeException("Invalid");
					}
					

				}
				studentList.add(student);
				System.out.println("=========================");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println(studentList);

	}
}
