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
	int but_width = 100;
	int but_height = 50;
	JButton bCheck = new JButton("Check");
	JButton bNewGame = new JButton("New Game");
		
	
	
	JTextField a0 = new JTextField();
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
		bCheck.setBounds(but_x_base + 50,but_y_pos - 30,but_width,but_height);
		bNewGame.setBounds(but_x_base + 150,but_y_pos - 30,but_width,but_height);
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
		
		for(int i=0; i<9; i++) {
		for(int j=0; j<9; j++) {
			box[i][j].setSize(50, 50);
			box[i][j].setFont(new Font("Lucinda", Font.BOLD, 15));
			box[i][j].setBackground(Color.BLACK);
			box[i][j].setForeground(Color.WHITE);
			box[i][j].setBounds(20 + 50*j, 20+50*i, 50, 50);
			f.add(box[i][j]);
			box[i][j].setHorizontalAlignment(JTextField.CENTER);
		}
		}	
		
	}
	
public static void main(String[] args) throws SQLException {
		new PracGui2();		
	}
	
class ButtonListener implements ActionListener { 
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				sqliteClass ob = new sqliteClass();
				Statement stmt = ob.connectDB();
				
				if (e.getSource() == bNewGame) {
					ob.startGame(stmt, "game1", box);
				} 
				else if (e.getSource() == bCheck) {
					if ( ob.checkData(stmt, "game1", box) == 2 ) {
					System.out.println("Hooray! correct! hehe");
					} else if ( ob.checkData(stmt, "game1", box) == 1) {
					System.out.println("right so far!");
					} else {
					System.out.println("not quite...");
					}
				}
			}
			catch ( Exception x ) {
				System.err.println( x.getClass().getName() + ": " + x.getMessage() );
				System.exit(0);
			}	
			
		}
	
	}
	
}
