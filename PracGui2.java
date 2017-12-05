/*
This is a sample practice gui for Sudoku final project

My idea of the process:
	generate the inital table/starting game
	user enters in some numbers
	Hit a "check" button
	numbers entered by user are added to the table. If they are correct, then yay. If not, output an error
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.sql.*;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.text.PlainDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.AttributeSet;


public class PracGui2 extends JFrame /*implements ActionListener */{

	// things in the class
	// creates buttons
	
	int but_x_base = 450;
	int but_y_pos = 450;
	int but_width = 200;
	int but_height = 50;
	JButton bCheck = new JButton("Check");
	JButton bNewGame = new JButton("New Game");
		
	// text boxes for game data to be input//
	
	JTextField Title = new JTextField("Sudoku");
	JTextField a1 = new JTextField();
	JTextField a2 = new JTextField();
	JTextField a3 = new JTextField();
	JTextField a4 = new JTextField();
	JTextField a5 = new JTextField();
	JTextField a6 = new JTextField();
	JTextField a7 = new JTextField();
	JTextField a8 = new JTextField();
	JTextField a9 = new JTextField();
	
	JTextField b1 = new JTextField();
	JTextField b2 = new JTextField();
	JTextField b3 = new JTextField();
	JTextField b4 = new JTextField();
	JTextField b5 = new JTextField();
	JTextField b6 = new JTextField();
	JTextField b7 = new JTextField();
	JTextField b8 = new JTextField();
	JTextField b9 = new JTextField();
	
	JTextField c1 = new JTextField();
	JTextField c2 = new JTextField();
	JTextField c3 = new JTextField();
	JTextField c4 = new JTextField();
	JTextField c5 = new JTextField();
	JTextField c6 = new JTextField();
	JTextField c7 = new JTextField();
	JTextField c8 = new JTextField();
	JTextField c9 = new JTextField();
	
	JTextField d1 = new JTextField();
	JTextField d2 = new JTextField();
	JTextField d3 = new JTextField();
	JTextField d4 = new JTextField();
	JTextField d5 = new JTextField();
	JTextField d6 = new JTextField();
	JTextField d7 = new JTextField();
	JTextField d8 = new JTextField();
	JTextField d9 = new JTextField();
	
	JTextField e1 = new JTextField();
	JTextField e2 = new JTextField();
	JTextField e3 = new JTextField();
	JTextField e4 = new JTextField();
	JTextField e5 = new JTextField();
	JTextField e6 = new JTextField();
	JTextField e7 = new JTextField();
	JTextField e8 = new JTextField();
	JTextField e9 = new JTextField();
	
	JTextField f1 = new JTextField();
	JTextField f2 = new JTextField();
	JTextField f3 = new JTextField();
	JTextField f4 = new JTextField();
	JTextField f5 = new JTextField();
	JTextField f6 = new JTextField();
	JTextField f7 = new JTextField();
	JTextField f8 = new JTextField();
	JTextField f9 = new JTextField();
	
	JTextField g1 = new JTextField();
	JTextField g2 = new JTextField();
	JTextField g3 = new JTextField();
	JTextField g4 = new JTextField();
	JTextField g5 = new JTextField();
	JTextField g6 = new JTextField();
	JTextField g7 = new JTextField();
	JTextField g8 = new JTextField();
	JTextField g9 = new JTextField();
	
	JTextField h1 = new JTextField();
	JTextField h2 = new JTextField();
	JTextField h3 = new JTextField();
	JTextField h4 = new JTextField();
	JTextField h5 = new JTextField();
	JTextField h6 = new JTextField();
	JTextField h7 = new JTextField();
	JTextField h8 = new JTextField();
	JTextField h9 = new JTextField();
	
	JTextField i1 = new JTextField();
	JTextField i2 = new JTextField();
	JTextField i3 = new JTextField();
	JTextField i4 = new JTextField();
	JTextField i5 = new JTextField();
	JTextField i6 = new JTextField();
	JTextField i7 = new JTextField();
	JTextField i8 = new JTextField();
	JTextField i9 = new JTextField();	
	
	// Now arrange into an array:
	JTextField[][] box = { { a1, a2, a3, a4, a5, a6, a7, a8, a9},
								{b1, b2, b3, b4, b5, b6, b7, b8, b9},
								{c1, c2, c3, c4, c5, c6, c7, c8, c9},
								{d1, d2, d3, d4, d5, d6, d7, d8, d9},
								{e1, e2, e3, e4, e5, e6, e7, e8, e9},
								{f1, f2, f3, f4, f5, f6, f7, f8, f9},
								{g1, g2, g3, g4, g5, g6, g7, g8, g9},
								{h1, h2, h3, h4, h5, h6, h7, h8, h9},
								{i1, i2, i3, i4, i5, i6, i7, i8, i9} };
	
	// constructor
	
class JTextFieldLimit extends PlainDocument {
  private int limit;
  JTextFieldLimit(int limit) {
    super();
    this.limit = limit;
  }

  JTextFieldLimit(int limit, boolean upper) {
    super();
    this.limit = limit;
  }

  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
    if (str == null)
      return;

    if ((getLength() + str.length()) <= limit) {
      super.insertString(offset, str, attr);
    }
  }
}

	public PracGui2() {		
	
		// This defines the JFrame
		JFrame f = new JFrame("Sudoku");
		f.setSize(1000,800);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // needed for closing the process
	    f.getContentPane().setBackground(Color.CYAN);
		f.setVisible(true);	
		
		
		//Defines buttons
		bCheck.setBounds(but_x_base - 150,but_y_pos + 90,but_width,but_height);
		bCheck.setBackground(Color.BLACK);
		bCheck.setFont(new Font("Bradley Hand ITC",Font.BOLD,30));
		bCheck.setForeground(Color.WHITE);
		bNewGame.setBounds(but_x_base - 400,but_y_pos + 90,but_width,but_height);
		bNewGame.setBackground(Color.BLACK);
		bNewGame.setFont(new Font("Bradley Hand ITC",Font.BOLD,30));
		bNewGame.setForeground(Color.WHITE);
		ButtonListener listener = new ButtonListener();
		
		
		// Adds button listeners
		bCheck.addActionListener(listener);
		bNewGame.addActionListener(listener);
		
		
		//Adds buttons to Jframe
		f.add(bCheck);
		f.add(bNewGame);
		
		//Makes buttons visible
		f.setVisible(true);
		

		// defines objects on the JFrame
		JTextField[] allfields = {a1, a2, a3, a4, a5, a6, a7, a8, a9,
									b1, b2, b3, b4, b5, b6, b7, b8, b9,
									c1, c2, c3, c4, c5, c6, c7, c8, c9,
									d1, d2, d3, d4, d5, d6, d7, d8, d9,
									e1, e2, e3, e4, e5, e6, e7, e8, e9,
									f1, f2, f3, f4, f5, f6, f7, f8, f9,
									g1, g2, g3, g4, g5, g6, g7, g8, g9,
									h1, h2, h3, h4, h5, h6, h7, h8, h9,
									i1, i2, i3, i4, i5, i6, i7, i8, i9 };	
		int x = 0;
		int y = 0;
		int i = 0;
		for(JTextField field : allfields) {
			x = i%9;
			y = (int) Math.floor(i/9);
			field.setSize(200, 200);
			field.setFont(new Font("Lucinda", Font.BOLD, 20));
			field.setBackground(Color.BLACK);
			field.setForeground(Color.WHITE);
			field.setBounds(20 + 50*x, 70+50*y, 50, 50);
			f.add(field);
			field.setHorizontalAlignment(JTextField.CENTER);
			i++;
			field.setDocument(new JTextFieldLimit(1));
		}
	
	  f.add(Title);
          Title.setBounds(20,20,450,50);
	  Title.setBackground(Color.BLACK);
	  Title.setForeground(Color.CYAN);
	  Title.setFont(new Font("Bradley Hand ITC",Font.BOLD,30));
	  Title.setHorizontalAlignment(JTextField.CENTER);
      }
	
	

/* SQLITE STUFF
*/
/* Main method! Creates an object of the class so actually runs the program */
	public static void main(String[] args) {
		Connection c = null;
		Statement stmt = null;
		
		PracGui2 object = new PracGui2();
		
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
			
			// object.updateData(stmt, 3, "col1", "4");	
			// object.fetchData(stmt);
			
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
	}
	
	void deleteData(Statement stmt) throws SQLException {
		String sql = " DELETE FROM game1 "; // deletes all record from game1
		stmt.executeUpdate(sql);	
	}
	
	void updateData(int id, String column, String num) throws SQLException {
		Connection c = null;
		Statement stmt = null;
		c = DriverManager.getConnection("jdbc:sqlite:Sud1.db");		
		stmt = c.createStatement();
		
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
			
			// Putting the values into the boxes.
			
			box[id-1][0].setText(col1);
			box[id-1][1].setText(col2);
			box[id-1][2].setText(col3);
			box[id-1][3].setText(col4);
			box[id-1][4].setText(col5);
			box[id-1][5].setText(col6);
			box[id-1][6].setText(col7);
			box[id-1][7].setText(col8);
			box[id-1][8].setText(col9);
			
		  }
		  // Make the correct/original numbers a different color. Not working!
		  for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				if(box[i][j].getText() != "") {
					box[i][j].setForeground(Color.WHITE);
				} else {
					box[i][j].setForeground(Color.WHITE);
				}
			}
		  }
		rs.close();		
	}
	
	
		class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	/*
	//getting an error with this method...
	void actionPerformed(ActionEvent e) {			
		if (e.getSource() == bCheck) {
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					if(box[i][j].getText() != ""){
					String column = "col" + j;
					updateData(i+1, column, box[i][j].getText());
					}
				}
			}
		}
	}
	*/
}
