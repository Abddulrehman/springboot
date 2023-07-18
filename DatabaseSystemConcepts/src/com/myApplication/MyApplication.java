package com.myApplication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyApplication {
	static int table1records = 0;
	static int table2records = 0;
	static int actualJoinSize = 0;

	public static Connection createConnetion(String table1, String table2) {

		Connection connection = null;
		try {

			// Load the JDBC driver class for mysql
			 java.lang.Class.forName("com.mysql.cj.jdbc.Driver");

			// Load the JDBC driver class for postgresql
			//Class.forName("org.postgresql.Driver");

			// Establish a connection to the PostgreSQL database
			//String url = "jdbc:postgresql://localhost:5432/mydatabase";
		    String url = "jdbc:mysql://localhost:3306/onlineapp";
			String username = "root";
			String password = "root";
			connection = java.sql.DriverManager.getConnection(url, username, password);
			String query = "SELECT * FROM  " + table1 + "  NATURAL JOIN " + table2;

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			// Iterate through the result set and count the rows
			// int naturalJoinSize = 0;

			while (resultSet.next()) {
				actualJoinSize++;
			}

			String query1 = "SELECT count(*) as test FROM " + table1;
			String query2 = "SELECT count(*) FROM " + table2;
			resultSet = statement.executeQuery(query1);

			if (resultSet.next()) {
				table1records = resultSet.getInt(1);

			}

			resultSet = statement.executeQuery(query2);
			resultSet = statement.executeQuery(query1);
			// Iterate through the result set and count the rows
			if (resultSet.next()) {
				table2records = resultSet.getInt(1);
			}

			// Calculate the estimation error
//	            int estimationError = estimatedJoinSize - actualJoinSize;
//
//	            System.out.println("Estimated join size: " + naturalJoinSize);
//	            System.out.println("Actual join size: " + naturalJoinSize);
//	            System.out.println("Estimation error: " + table2records);

			System.out.println("Connection established successfully.");
		} catch (ClassNotFoundException e) {
			System.err.println("Could not load JDBC driver class: " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Could not establish connection: " + e.getMessage());
		} finally {
			// Close the connection
			try {
				if (connection != null) {
					connection.close();
					System.out.println("Connection closed.");
				}
			} catch (SQLException e) {
				System.err.println("Could not close connection: " + e.getMessage());
			}
		}
		return connection;
	}

	public static int estimateJoinSize(int tableA, int tableB, int commonColumns) {

		// int numCommonColumns = commonColumns.length;
		int minNumRows = Math.min(tableA, tableB);
		return (tableA * tableB / commonColumns);
	}

	public static int computeJoinSize(int tableA, int tableB, int[] commonColumns) {
		List<int[]> joinedRows = new ArrayList<>();

		if (matchOnCommonColumns(tableA, tableB, commonColumns)) {
			int joinedRow = joinRows(tableA, tableB);
			// joinedRows.add(joinedRow);

		}
		return joinedRows.size();
	}

	private static boolean matchOnCommonColumns(int rowA, int rowB, int[] commonColumns) {
		// TODO Auto-generated method stub
		return false;
	}

	private static int joinRows(int rowA, int rowB) {
		int joinedRow = rowA + rowB;

		return joinedRow;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		// Input the number of rows in each table
		System.out.println("Enter table 1: ");
		String table1 = scanner.nextLine();

		System.out.println("Enter  table 2: ");
		String table2 = scanner.nextLine();

		createConnetion(table1, table2);

		int commonColumns = 2;
		int estimatedJoinSize = estimateJoinSize(table1records, table2records, commonColumns);
		System.out.println("Estimated join size: " + estimatedJoinSize);

		// Compute actual join size
		// int actualJoinSize = computeJoinSize(table1records, table2records,
		// commonColumns);
		System.out.println("Actual join size: " + actualJoinSize);

		// Compute estimation error
		int estimationError = estimatedJoinSize - actualJoinSize;
		System.out.println("Estimation error: " + estimationError);

	}

}
