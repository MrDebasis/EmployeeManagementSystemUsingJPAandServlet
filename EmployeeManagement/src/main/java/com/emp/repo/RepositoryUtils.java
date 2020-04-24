package com.emp.repo;

public class RepositoryUtils {
	private static final String DRIVER_NAME="com.mysql.jdbc.Driver";
	private static final String DATABASE_NAME="Login";
	private static final String DB_URL="jdbc:mysql://localhost:3306/Login?user=root&password=1234";


	public static String getDriverName() {
		return DRIVER_NAME;
	}


	public static String getDatabaseName() {
		return DATABASE_NAME;
	}


	public static String getDbUrl() {
		return DB_URL;
	}

}
