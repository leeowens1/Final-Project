/*
	12/03/2017
	
	Table of Contents of Methods:
	- Statement connectDB() // returns the stmt for running all the other methods
	- startGame(Statement stmt, String game, JTextField[][] box) // game must be "game1" or "game2"
	- createTable(Statement stmt, String tableName) // creates an sqlite table
	- deleteData(Statement stmt, String tableName) // deletes all the data, in case it already existed, clean state
	- setFields(String stmt, String game, JTextField[][] field) // returns JTextFields with current info
	- updateData(Statement stmt, String game, int id, int column, String value) // enters updated values into the game table
	- checkData(Statement stmt, String game, JTextField[][] test) // checks user's values
		// Enters correct values into game table, enters "X" for incorrect values
		// returns 0 if any mistakes, 1 if correct so far, and 2 if completely correct puzzle
	- fetchData(Statement stmt, String tableName) // returns a String array with all of the values in the table			
	- addGame(Statement stmt, String tableName) // inputs the data into "game1" or "game2"
	- addAnswer(Statement stmt, String answer) // inputs the data into "answer1" or "answer2"	
*/

import java.sql.*;
import java.util.Arrays;
import javax.swing.*;
import java.awt.Color;

public class  sqliteClass extends JFrame {
	
	Statement connectDB() throws SQLException {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			// creates a database named Sud1.db
			c = DriverManager.getConnection("jdbc:sqlite:Sud1.db");
			System.out.println("---Database is now open---");
			
			stmt = c.createStatement();			
			//stmt.close();
			//c.close();
		}
		catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		return stmt;
	}

	void startGame(Statement stmt, String game, JTextField[][] box) throws SQLException{
		String answer = "";
		if ( game.equals("game1") ) {
			answer = "answer1";
		} if ( game.equals("game2") ) {
			answer = "answer2";
		}
			
		createTable(stmt, game);
		deleteData(stmt, game); // in case the table and data already exists
		addGame(stmt, game);
		setFields(stmt, game, box);
		
		createTable(stmt, answer);
		deleteData(stmt, answer);
		addAnswer(stmt, answer);
	}
	
	void createTable(Statement stmt, String tableName) throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " " +
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
			System.out.println("---table " + tableName + " created!---");				
	}
	
	void deleteData(Statement stmt, String tableName) throws SQLException {
		String sql = " DELETE FROM " + tableName + ";"; // deletes all record from tableName
		stmt.executeUpdate(sql);
		
		System.out.println("---all records from " + tableName + " deleted---");	
	}
	
	JTextField[][] setFields(Statement stmt, String tableName, JTextField[][] field) throws SQLException {
		System.out.println("Setting the fields with fetchData");
		String[][] box = fetchData(stmt, tableName);
		String text;
		for (int i=0; i<9; i++) {
		for (int j=0; j<9; j++) {
			text = field[i][j].getText();
			if ( box[i][j].equals("") | box[i][j].equals("X") ) {
				field[i][j].setForeground(Color.CYAN);
			}
			field[i][j].setText(box[i][j]);
		}
		}
		return field;
	}
	
	void updateData(Statement stmt, String game, int id, int column, String value) throws SQLException {
		String col = "col" + Integer.toString(column); 
		String sql = " UPDATE " + game + " SET " + col + " = '" + value + "' WHERE id = " + id + ";";
		stmt.executeUpdate(sql);
	}
	
	String[][] fetchData(Statement stmt, String tableName) throws SQLException {
		String[][] box = new String[9][9];
		ResultSet rs = stmt.executeQuery ( "SELECT * FROM " + tableName + ";");	
		
		System.out.println( "Data in " + tableName + " :");		
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
			
			// Putting the values into the boxes.
			
			box[id-1][0] = col1;
			box[id-1][1] = col2;
			box[id-1][2] = col3;
			box[id-1][3] = col4;
			box[id-1][4] = col5;
			box[id-1][5] = col6;
			box[id-1][6] = col7;
			box[id-1][7] = col8;
			box[id-1][8] = col9;
			
		  }
		rs.close();
		return box;
	}
	
	int checkData(Statement stmt, String game, JTextField[][] test) throws SQLException {
		int returnval = 2; // 0 - incorrect, 1 - correct so far, 2 - completely correct puzzle 
		boolean correct = true;
		String answer = "";				
		
		if ( game.equals("game1") ) {
			answer = "answer1";
		} if ( game.equals("game2") ) {
			answer = "answer2";
		}
		
		String[][] solution = fetchData(stmt, answer);
		
		// compares each entry in the the JTextField array to the solution array
		
		for (int i=0; i<9; i++) {
		for (int j=0; j<9; j++) {
			if ( (test[i][j].getText()).equals("") ) {
				returnval = 1;
			} else if ( (test[i][j].getText()).equals(solution[i][j]) ) {
				System.out.println(test[i][j]);
				updateData(stmt, game, (i+1), (j+1), test[i][j].getText()); // if correct, addes the value to the game table
			} else if ( !((test[i][j].getText()).equals(solution[i][j])) ) {
				System.out.println("this value unequal: " + test[i][j]);
				updateData(stmt, game, (i+1), (j+1), "X"); // reset the incorrect value to X
				correct = false;
			}
		}
		}
		
		setFields(stmt, game, test);

		if (correct) {
			return returnval; // if correct, returns either 2 for completely correct, or 1 for correct so far
		} else {
			return 0;
		}	
	}
	
	void addGame(Statement stmt, String tableName) throws SQLException {
		if ( tableName.equals("game1") ){
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
		}
		if( tableName.equals("game2") ) {
			String sql = "INSERT INTO game2 (id, col1, col2, col3, col4, col5, col6, col7, col8, col9) " +
			"VALUES (1, '', '9', '', '', '', '4', '3', '', '');";
			stmt.executeUpdate(sql);		
		}
		
		System.out.println("---" + tableName + " values added!---");		
	}
	
	void addAnswer(Statement stmt, String answer) throws SQLException {
		if ( answer.equals("answer1") ) {
			String sql = "INSERT INTO answer1 (id, col1, col2, col3, col4, col5, col6, col7, col8, col9) " +
			"VALUES (1, '8', '2', '7', '1', '5', '4', '3', '9', '6');";
			stmt.executeUpdate(sql);	
			
			sql = "INSERT INTO answer1 (id, col1, col2, col3, col4, col5, col6, col7, col8, col9) " +
			"VALUES (2, '9', '6', '5', '3', '2', '7', '1', '4', '8');";
			stmt.executeUpdate(sql);
			
			sql = "INSERT INTO answer1 (id, col1, col2, col3, col4, col5, col6, col7, col8, col9) " +
			"VALUES (3, '3', '4', '1', '6', '8', '9', '7', '5', '2');";
			stmt.executeUpdate(sql);
			
			
			sql = "INSERT INTO answer1 (id, col1, col2, col3, col4, col5, col6, col7, col8, col9) " +
			"VALUES (4, '5', '9', '3', '4', '6', '8', '2', '7', '1');";
			stmt.executeUpdate(sql);
			
			sql = "INSERT INTO answer1 (id, col1, col2, col3, col4, col5, col6, col7, col8, col9) " +
			"VALUES (5, '4', '7', '2', '5', '1', '3', '6', '8', '9');";
			stmt.executeUpdate(sql);
			
			sql = "INSERT INTO answer1 (id, col1, col2, col3, col4, col5, col6, col7, col8, col9) " +
			"VALUES (6, '6', '1', '8', '9', '7', '2', '4', '3', '5');";
			stmt.executeUpdate(sql);
			
			
			sql = "INSERT INTO answer1 (id, col1, col2, col3, col4, col5, col6, col7, col8, col9) " +
			"VALUES (7, '7', '8', '6', '2', '3', '5', '9', '1', '4');";
			stmt.executeUpdate(sql);
			
			sql = "INSERT INTO answer1 (id, col1, col2, col3, col4, col5, col6, col7, col8, col9) " +
			"VALUES (8, '1', '5', '4', '7', '9', '6', '8', '2', '3');";
			stmt.executeUpdate(sql);
			
			sql = "INSERT INTO answer1 (id, col1, col2, col3, col4, col5, col6, col7, col8, col9) " +
			"VALUES (9, '2', '3', '9', '8', '4', '1', '5', '6', '7');";
			stmt.executeUpdate(sql);							
			
		} if ( answer.equals("answer2") ) {
			String sql = "INSERT INTO answer2 (id, col1, col2, col3, col4, col5, col6, col7, col8, col9) " +
			"VALUES (1, '', '9', '', '', '', '4', '3', '', '');";
			stmt.executeUpdate(sql);
		}
		System.out.println("---" + answer + " values added---");	
	}

}
