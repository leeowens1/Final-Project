/*
This is the main GUI program file for our Sudoku game

Make sure the file sqliteClass.java is in the same folder as this file
Still need to run this file with java -classpath ".;sqlite-jdbc-[version].jar" PracGui2

Prepare for WOW

Last edited 12/04/2017
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

public class PracGui2 extends JFrame {

	// creates buttons
	
	int but_x_base = 575;
	int but_y_pos = 600;
	int but_width = 200;
	int but_height = 50;
	JButton bCheck = new JButton("Check");
	JButton bNewGame = new JButton("New Game");
		
	// text boxes for game data to be input
	
	JTextField Title = new JTextField("Prepare for WOW!");
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
	
	// arranging JTextFields into an array:
	JTextField[][] box = { { a1, a2, a3, a4, a5, a6, a7, a8, a9},
								{b1, b2, b3, b4, b5, b6, b7, b8, b9},
								{c1, c2, c3, c4, c5, c6, c7, c8, c9},
								{d1, d2, d3, d4, d5, d6, d7, d8, d9},
								{e1, e2, e3, e4, e5, e6, e7, e8, e9},
								{f1, f2, f3, f4, f5, f6, f7, f8, f9},
								{g1, g2, g3, g4, g5, g6, g7, g8, g9},
								{h1, h2, h3, h4, h5, h6, h7, h8, h9},
								{i1, i2, i3, i4, i5, i6, i7, i8, i9} };
								
	// class for setting the limit of JTextFields in the grid to 1 character
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
	
	// constructor
	public PracGui2() {		
	
		// This defines the JFrame
		JFrame f = new JFrame("Sudoku");
		f.setSize(750,850);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // needed for closing the process
	    f.getContentPane().setBackground(Color.CYAN);
		f.setVisible(true);	
		
		
		//Defines buttons
		bCheck.setBounds(but_x_base - 250,but_y_pos + 150,but_width,but_height);
		bCheck.setBackground(Color.BLACK);
		bCheck.setFont(new Font("Bradley Hand ITC",Font.BOLD,30));
		bCheck.setForeground(Color.WHITE);
		bNewGame.setBounds(but_x_base - 450,but_y_pos + 150,but_width,but_height);
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
		
		// set properties for the grid JTextFields		
		for(int i=0; i<9; i++) {
		for(int j=0; j<9; j++) {
			int boxsize = 75;
			box[i][j].setSize(boxsize, boxsize);
			box[i][j].setFont(new Font("Lucinda", Font.BOLD, 20));
			box[i][j].setBackground(Color.BLACK);
			box[i][j].setForeground(Color.WHITE);
			box[i][j].setBounds(20 + boxsize*j, 70 + boxsize*i, boxsize, boxsize);
			f.add(box[i][j]);
			box[i][j].setHorizontalAlignment(JTextField.CENTER);
			box[i][j].setDocument(new JTextFieldLimit(1));
		}
		}
	
		f.add(Title);
		Title.setBounds(20,20,675,50);
		Title.setBackground(Color.BLACK);
		Title.setForeground(Color.CYAN);
		Title.setFont(new Font("Bradley Hand ITC",Font.BOLD,30));
		Title.setHorizontalAlignment(JTextField.CENTER);
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
						// then user's input is completely correct!
					} else if ( ob.checkData(stmt, "game1", box) == 1) {
						// then everything the user has entered so far is correct
					} else if ( ob.checkData(stmt, "game1", box) == 0){
						// then the user's input has some errors
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
