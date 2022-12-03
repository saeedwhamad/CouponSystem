package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConnectionPool {
	ConnectionPool instance;
	Set<Connection> connections=new HashSet<Connection>();
	int x = -1;
	Connection connection;
	public final static String URL = "jdbc:mysql://localhost:3306/phaseone";
	public static final String user = "root";
	public static final String password = "0000";
	public final static String DRIVER = "com.mysql.cj.jdbc.Driver";

	public ConnectionPool() {
	
		

		for (int i = 0; i < 9; i++) {
			x++;
			try {
				Class.forName(DRIVER);
				Connection connection = DriverManager.getConnection(URL, user, password);
				connections.add(connection);
			} catch (SQLException e) {
				System.out.println(e.getLocalizedMessage());
			} catch (ClassNotFoundException e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
		

		
	}

	public ConnectionPool getInstance() {
		return instance;
	}

	public Connection getConnection() {
		
		
		List<Connection> cons=new ArrayList<Connection>(connections);
		
		
		Connection connection =cons.get(x);
		connections.remove(connection);
		x--;
	
		return connection;

		
		
	}

	public void restoreConnection(Connection connection) {
		connections.add(connection);

	}

	public void closeAllConnections() throws SQLException {
		for (Connection connection : connections) {
			connection.close();

		}

	}
}
