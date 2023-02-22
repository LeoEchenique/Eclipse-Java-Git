package DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbConn {
	/*
	 * The PostgreSQL JDBC Driver allows Java programs to connect to a PostgreSQL
	 * database using standard, database independent Java code. pgJDBC is an open
	 * source JDBC driver written in Pure Java (Type 4), and communicates in the
	 * PostgreSQL native network protocol. Because of this, the driver is platform
	 * independent; once compiled, the driver can be used on any system.
	 */

	public static void main(String[] args) throws SQLException {
		String JDBCurl = "jdbc:postgresql://localhost:5432/JavaDB";
		String username = "postgres"; // DONT CARE ABOUT this
		String password = System.getenv("DB_PASSWORD");
		/*
		 * String query = "INSERT INTO contacts (first_name, last_name, email)" +
		 * " VALUES ('Benito', 'supirsa', 'lalale@gmail.com')"; String query2 =
		 * "SELECT * FROM contacts"; try { Connection conect =
		 * DriverManager.getConnection(JDBCurl, username, password);
		 * System.out.println("CONNECTED!"); Statement statement =
		 * conect.createStatement(); int row = statement.executeUpdate(query); if (row >
		 * 0) { System.out.println("INSERTED"); } Statement statement2 =
		 * conect.createStatement(); ResultSet data = statement2.executeQuery(query2);
		 * while (data.next()) {
		 * 
		 * System.out.println(data.getString("id") + "||||||" +
		 * data.getString("email"));
		 * 
		 * } conect.close(); } catch (SQLException e) {
		 * System.out.println("error in network"); e.printStackTrace(); }
		 */

		// prepared query:
		Connection conect = null;
		PreparedStatement newQuery = null;
		ResultSet res= null;
		try {

			conect = DriverManager.getConnection(JDBCurl, username, password);
			System.out.println("CONNECTED!");
			//dinamic query based on params:
			newQuery = conect.prepareStatement("SELECT * from contacts " + " WHERE first_name=? AND email=?");
			
			// params: 
			newQuery.setString(1, "Leo");
			newQuery.setString(2, "pockfface@gmail.com");
			
			 res= newQuery.executeQuery();
			
			while(res.next()) {
				 System.out.println(res.getString(1) + " | " + res.getString(2) + " | "+ res.getString(3) + " | " +  res.getString(4));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (conect != null)
				conect.close();
			if (newQuery != null)
				newQuery.close();
			if (res != null)
				res.close();
		}

	}
}
