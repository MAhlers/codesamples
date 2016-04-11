package myPkg;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	
	static final String user = "user", password = "pass";
	
	public static Connection OpenDBConnection(String server, String db) throws ClassNotFoundException, IOException {
		Connection jCon = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String connString = "jdbc:sqlserver://" + server + ";" 
                    + "database=" + db + ";"
                    + "user=" + user + ";password=" + password + ";";
	        jCon = DriverManager.getConnection(connString);
		} catch (SQLException e) {
			LogMessage.postLogMessage("EXCEPTION: JDBCConnection.OpenConnection - " + e);
		}
		return jCon;
	}

	public static void CloseDBConnection(Connection conn) throws IOException {
		try {
			conn.close();
		} catch (SQLException e) {
			LogMessage.postLogMessage("EXCEPTION: JDBCConnection.CloseConnection - " + e);
		}
	}
}