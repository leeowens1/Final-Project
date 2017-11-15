import java.sql.*;
/*
First attempt at java class for creating our Sudoku tables and populating them with the starting values
Values used from this solved puzzle https://www.andrew.cmu.edu/user/kkuan/finalWriteup.html
Last edited 11/14/17 by amy
*/

public class SudokuDB {
		Connection c = null;
		
		// connecting to the data base file 
		public void connectDB(){
			try {
				Class.forName("org.sqlite.JDBC");
				c = DriverManager.getConnection("jdbc:sqlite:Sudoku.db");
			} catch ( Exception e ) {
				System.err.println( e.getClass().getName() + ": " + e.getMessage() );
				System.exit(0);
				}
		}
		
		public void createTables(){
			Statement stmt = null;
			
			// Sudoku
			try {
				stmt = c.createStatement();
				String sql = "(id integer primary key autoincrement, \n" +
					" column1	int," +
					" column2	int," +
					" column3	int," +
					" column4	int," +
					" column5	int," +
					" column6	int," +
					" column7	int," +
					" column8	int," +
					" column9	int)";
				stmt.executeUpdate(sql);
				stmt.close();
			} catch ( Exception e ) {
				System.err.println( e.getClass().getName() + ": " + e.getMessage() );
				System.exit(0);
			}
		
		}
		
		// Adds data to the sudoku table
		public void addDataToSudokuTable(String a, String b, String c, String d, String e, String f, String g, String h, String i){
			Statement stmt = null;
			// 'sudoku' would have to be out table name. Or we can change it
			try {
				stmt = c.createStatement();
				String sql = "insert into sudoku * " +
							"values ('" + a + "', '" + b + "', '" + c + "', '" + d + 
							"', '" + e + "', '" + f + "', '" + g + "', '" + h + "', '" + i + "');";
				stmt.executeUpdate(sql);
				stmt.close();
			} catch ( Exception e ) {
				System.err.println( e.getClass().getName() + ": " + e.getMessage() );
				System.exit(0);
				
      // there is no "null" value for int so i tried changing them to int				
			SudokuDB.addDataToSudokuTable("", "2", "", "", "", "4", "3", "", "");
			SudokuDB.addDataToSudokuTable("9", "", "", "", "2", "", "", "", "8");
			SudokuDB.addDataToSudokuTable("", "", "", "6", "", "9", "", "5", "");
			SudokuDB.addDataToSudokuTable("", "", "", "", "", "", "", "", "1");
			SudokuDB.addDataToSudokuTable("", "7", "2", "5", "", "3", "6", "8", "");
			SudokuDB.addDataToSudokuTable("6", "", "", "", "", "", "", "", "");
			SudokuDB.addDataToSudokuTable("", "8", "", "2", "", "5", "", "", "");
			SudokuDB.addDataToSudokuTable("1", "", "", "", "9", "", "", "", "3");
			SudokuDB.addDataToSudokuTable("", "", "9", "8", "", "", "", "6", "");
			}
		}
			
}


