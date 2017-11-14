import java.sql.*;

/*
This code is helpful to learn how to create JAVA code around SQLite
https://www.tutorialspoint.com/sqlite/sqlite_java.htm
This is the site where it explains how to use SQLite and interface app download 
https://sqlite.org/download.html
This is a site that has the JARs needed by JAVA to interface with SQLite
https://bitbucket.org/xerial/sqlite-jdbc/downloads/
*/


public class SudokuDB {
	Connection c = null;

	
	// connecting to the data base file 
	public void connectDB(){
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:Users.db");
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
	}
	
   
	public void createTables(){
		Statement stmt = null;
		
		// Customer Table
		try {
			stmt = c.createStatement();
			String sql = "create table if not exists customers \n" +
				"(id integer primary key autoincrement, \n" +
				" name           text    not null, \n" + 
				" address        char(50), \n" + 
				" city        	 char(50), \n" + 
				" state        	 char(50), \n" + 
				" zip        	 char(15), \n" +
				" phone        	 char(15))"; 
			stmt.executeUpdate(sql);
			stmt.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}

		// Customer Sales Table 
		try {
			stmt = c.createStatement();
			String sql = "create table if not exists sales(id integer primary key autoincrement, customer_id int not null, product int not null, ammount real)"; 
			stmt.executeUpdate(sql);
			stmt.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}	
	}

	
	// Adds data to the people table
	public void addDataToPeopleTable(String Name, int Age, String Address, String City, 
		String State, String Zip, Double Salery){
		Statement stmt = null;
		try {
			stmt = c.createStatement();
			String sql = "insert into people (name, age, address, city, state, zip, salary) " +
						"values ('" + Name + "'," + Age + ", '" + Address + "', '" + City + 
						"', '" + State + "', '" + Zip + "', " + Salery + ");"; 
			stmt.executeUpdate(sql);
			stmt.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
			
			
		// UDB.addDataToPeopleTable("Bob", 43, "123 Any St.", "Cleveland", "TN", "37320", 43000.25);
		// UDB.addDataToPeopleTable("Sandy", 25, "400 North Lee Hwy", "Cleveland", "TN", "37317", 16700.12);
		// UDB.addDataToPeopleTable("April", 49, "10 You Know It Drive", "Greensboro", "NC", "27012", 82000.00);
		}
	}

}