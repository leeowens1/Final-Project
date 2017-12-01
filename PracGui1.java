/*
This is a just a very basic gui to get some of the pieces
Specifically this creates a JFrame with all 81 textfields arranged in a square

I think we could combine this with what Emily is doing on the SudokuFrame
*/

import java.awt.*;
import javax.swing.*;
import java.util.Arrays;

public class PracGui1 extends JFrame {

	// creating the textfields	
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
	
	// I am just putting these into a 2-dimensional array. This is just useful for later
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
	public PracGui1() {		
	
		// defining the JFrame
		JFrame f = new JFrame("Sudoku Puzzle");
		f.setSize(800,700);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // needed for closing the process
		f.setBackground(new Color(255,255,255));
		f.setVisible(true);	

		// defining and arranging the textfields using a for each loop
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
			field.setSize(50, 50);
			field.setFont(new Font("Arial", Font.BOLD, 15));
			field.setBackground(new Color(220,220,220));
			field.setForeground(new Color(119,136,153));
			field.setBounds(20 + 50*x, 20+50*y, 50, 50);
			f.add(field);
			i++;
		}		
	}
	
	public static void main(String[] args) {
		new PracGui1();
	}
}
