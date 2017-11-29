/*
	Here is a program that can create a table (game1), add the values for the table, show the data, delete and update.
	The program starts with a main method and then references other methods in the class to perform the tasks.
	Next step is probably to link these methods with the ActionListener stuff, like we did for the calculator gui.
	Particularly the updateData() method should be useful for adding in values as users enter numbers
	
	In order to run this program, you have to compile like normal with javac,
	then to run it you have to reference the jdbc jar file
	To do this, assuming that the jdbc jar file is in the same directory as this program,
	enter java -classpath ".;sqlite-jdbc-3.21.0.jar" Sudoku1 (or whatever version your jar file is) 
	
	I am definitely open to any thoughts or criticism
	Let me know if anything doesn't make sense
	
	last edited 11/20/17
*/
import java.sql.*;

public class  Sudoku1{

	public static void main( String args[] ) {
		Connection c = null;
		Statement stmt = null;
		
		Sudoku1 object = new Sudoku1();
		
		try {
			Class.forName("org.sqlite.JDBC");
			// creates a database named Sud1.db
			c = DriverManager.getConnection("jdbc:sqlite:Sud1.db");
			System.out.println("---Database is now open---");
			
			stmt = c.createStatement();

			object.createTable(stmt);
			object.deleteData(stmt);
			object.addData(stmt);	
			object.fetchData(stmt);
			
			object.updateData(stmt, 3, "col1", "4");	
			object.fetchData(stmt);
			
			stmt.close();
			c.close();
		}
		catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		System.out.println("---operation successful---");
	}

	void createTable(Statement stmt) throws SQLException {
			String sql = "CREATE TABLE IF NOT EXISTS game1 " +
			"(id int primary key not null," +
			"col1	text, " +
			"col2	text, " +
			"col3	text, " +
			"col4	text, " +
			"col5	text, " +
			"col6	text, " +
			"col7	text, " +
			"col8	text, " +
			"col9	text)";
			stmt.executeUpdate(sql);
			System.out.println("---game1 created!---");				
	}
	
	void addData(Statement stmt) throws SQLException {		
		String sql = "INSERT INTO game1 (id, col1, col2, col3, col4, col5, col6, col7, col8, col9) " +
		"VALUES (1, '', '2', '', '', '', '4', '3', '', '');";
		stmt.executeUpdate(sql);
		
		sql = "INSERT INTO game1 (id, col1, col2, col3, col4, col5, col6, col7, col8, col9) " +
		"VALUES (2, '9', '', '', '', '2', '', '', '', '8');";
		stmt.executeUpdate(sql);
		
		sql = "INSERT INTO game1 (id, col1, col2, col3, col4, col5, col6, col7, col8, col9) " +
		"VALUES (3, '', '', '', '6', '', '9', '', '5', '');";
		stmt.executeUpdate(sql);
		
		
		sql = "INSERT INTO game1 (id, col1, col2, col3, col4, col5, col6, col7, col8, col9) " +
		"VALUES (4, '', '', '', '', '', '', '', '', '1');";
		stmt.executeUpdate(sql);
		
		sql = "INSERT INTO game1 (id, col1, col2, col3, col4, col5, col6, col7, col8, col9) " +
		"VALUES (5, '', '7', '2', '5', '', '3', '6', '8', '');";
		stmt.executeUpdate(sql);
		
		sql = "INSERT INTO game1 (id, col1, col2, col3, col4, col5, col6, col7, col8, col9) " +
		"VALUES (6, '6', '', '', '', '', '', '', '', '');";
		stmt.executeUpdate(sql);
		
		
		sql = "INSERT INTO game1 (id, col1, col2, col3, col4, col5, col6, col7, col8, col9) " +
		"VALUES (7, '', '8', '', '2', '', '5', '', '', '');";
		stmt.executeUpdate(sql);
		
		sql = "INSERT INTO game1 (id, col1, col2, col3, col4, col5, col6, col7, col8, col9) " +
		"VALUES (8, '1', '', '', '', '9', '', '', '', '3');";
		stmt.executeUpdate(sql);
		
		sql = "INSERT INTO game1 (id, col1, col2, col3, col4, col5, col6, col7, col8, col9) " +
		"VALUES (9, '', '', '9', '8', '', '', '', '6', '');";
		stmt.executeUpdate(sql);		
		
		System.out.println("---values added!---");		
	}
	
	void deleteData(Statement stmt) throws SQLException {
		String sql = " DELETE FROM game1 "; // deletes all record from game1
		stmt.executeUpdate(sql);
		
		System.out.println("---all records deleted---");	
	}
	
	void updateData(Statement stmt, int id, String column, String num) throws SQLException {
		String sql = " UPDATE game1 SET " + column + " = " + num + " WHERE id = " + id + ";";
		stmt.executeUpdate(sql);

		System.out.println("---data updated!---");
	}
	
	void fetchData(Statement stmt) throws SQLException {
		ResultSet rs = stmt.executeQuery ( "SELECT * FROM game1;" );	
		
		System.out.println( "id\tcol1\tcol2\tcol3\tcol4\tcol5\tcol6\tcol7\tcol8\tcol9" );
		
		while ( rs.next() ) {
			int id = rs.getInt("id");
			String col1 = rs.getString("col1");
			String col2 = rs.getString("col2");
			String col3 = rs.getString("col3");
			String col4 = rs.getString("col4");
			String col5 = rs.getString("col5");
			String col6 = rs.getString("col6");
			String col7 = rs.getString("col7");
			String col8 = rs.getString("col8");
			String col9 = rs.getString("col9");
			
			System.out.print( id + "\t" + col1 + "\t" + col2 + "\t" + col3 );
			System.out.print( "\t" + col4 + "\t" + col5 + "\t" + col6 );
			System.out.print( "\t" + col7 + "\t" + col8 + "\t" + col9 );
			System.out.println();
		  }
		rs.close();		
	}
}

/* Note: throws SQLExcetion does the same things as 
		try {
			stmt.exectueUpdate(sql);
			...		
		}
		catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}	
*/
