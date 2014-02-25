package examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SQLExample {
	
	public static void main(String[] args) throws ClassNotFoundException,SQLException {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		Connection con = DriverManager.getConnection("jdbc:derby:wombat;create=true");
		Statement stmt = con.createStatement();
//		stmt.execute("CREATE TABLE TableExample (PersonId INTEGER, FirstName VARCHAR(10), LastName VARCHAR(10), Age INTEGER, CarNumber INTEGER)");

//		stmt.execute("INSERT INTO TableExample VALUES (1, 'Atanas', 'Atanasov', 16, null)");
//		stmt.execute("INSERT INTO TableExample VALUES (2, 'Georgi', 'Neychev', 18, 2)");
//		stmt.execute("INSERT INTO TableExample VALUES (3, 'Stefan', 'Petrov', 19, null)");
//		stmt.execute("INSERT INTO TableExample VALUES (4, 'Martin', 'Zanov', 29, 10)");
//		stmt.execute("INSERT INTO TableExample VALUES (5, 'Martins', 'Zanovff', 32, 4)");
//		stmt.execute("INSERT INTO TableExample VALUES (6, 'Marting', 'Zanovot', 10, 0)");



		ResultSet rs = stmt.executeQuery("SELECT * FROM TableExample");
//		ResultSet rs = stmt.executeQuery("SELECT * FROM TableExample WHERE age < 29 AND age > 16");
//		ResultSet rs = stmt.executeQuery("SELECT * FROM TableExample WHERE FirstName LIKE 'Martins%'");
		
		
		
		while (rs.next()) {
			int ID = rs.getInt("PersonID");
			String Fname = rs.getString("FirstName");
			String Lname = rs.getString("LastName");
			int Age = rs.getInt("Age");
			int Cars = rs.getInt("CarNumber");

			System.out.print("id = " + ID + " ; ");
			System.out.print("First name = " + Fname + " ; ");
			System.out.print("Last name = " + Lname + " ; ");
			System.out.print("Age = " + Age + " ; ");
			System.out.println("Cars = " + Cars + " ; ");

		}
	    System.out.println("---------------------------------------------------------------------------------");

	      stmt.executeUpdate("DELETE FROM TableExample WHERE FirstName = 'Martins' OR FirstName = 'Marting' ");
	      ResultSet rsNew = stmt.executeQuery("SELECT * FROM TableExample");

			while (rsNew.next()) {
				int ID = rsNew.getInt("PersonID");
				String Fname = rsNew.getString("FirstName");
				String Lname = rsNew.getString("LastName");
				int Age = rsNew.getInt("Age");
				int Cars = rsNew.getInt("CarNumber");

				System.out.print("id = " + ID + " ; ");
				System.out.print("First name = " + Fname + " ; ");
				System.out.print("Last name = " + Lname + " ; ");
				System.out.print("Age = " + Age + " ; ");
				System.out.println("Cars = " + Cars + " ; ");

			}
			
		  System.out.println("---------------------------------------------------------------------------------");

		  stmt.executeUpdate("UPDATE TableExample SET FirstName = 'RickRoss' WHERE LastName = 'Zanov'");
		  
		  ResultSet rsNewest = stmt.executeQuery("SELECT * FROM TableExample");

			while (rsNewest.next()) {
				int ID = rsNewest.getInt("PersonID");
				String Fname = rsNewest.getString("FirstName");
				String Lname = rsNewest.getString("LastName");
				int Age = rsNewest.getInt("Age");
				int Cars = rsNewest.getInt("CarNumber");

				System.out.print("id = " + ID + " ; ");
				System.out.print("First name = " + Fname + " ; ");
				System.out.print("Last name = " + Lname + " ; ");
				System.out.print("Age = " + Age + " ; ");
				System.out.println("Cars = " + Cars + " ; ");

			}
	}
	
}

