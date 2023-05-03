package com.gustavo.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMVC {
	public Connection getConnection() {
		Connection conn = null;
		/*try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://johrossato.database.windows.net:1433;database=Digipets-Desktop;user=johrossato@johrossato;password=@dministrador123;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}
    
}
