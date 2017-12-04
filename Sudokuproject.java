import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


// Basic Jpanel to show the cells//
public class Sudokuproject extends JPanel{
private static final long 
serialVersionUID = 1L;

Sudokuproject(GridGrid) {
        RowColReg[] region = grid.getRegion();
		     int size = (int)
		Math.sqrt((double) region.length);
	
	public class GridGrid {
	public static void main(String[] args) {
        UserInput input = new UserInput();
        input.name();
    }
}
		
	//main panel to house the size x size regions 
	    setLayout(new GridLayout(size, size));
	// other panels one for each region 
	    for(int i = 0; i< region.length; i++) {
		  JPanel p = new 
		  JPanel(new GridLayout(size,size));
		     p.setBorder(BorderFactory.createLineBorder(Color.BLACK));
             Cell[] cell = region[i].getCells();
             for(int j = 0; j < cell.length; j++) { p.add(cell[j]);
			 }
			 add(p);
			 }
		}
	

public static void main(String[] atgs) {
   JFrame frame = new JFrame("First Sudoku game");
                        frame.setDefaultCloseOperatin(JFrame.Dispose_On_Close);
						GridGrid = new Grid (9);
						Problems.setProblem3(grid);
						grid.registerForKeyboardEvent();
						 Sudokuproject ggo = new SudokuProject (grid);
						 frame.add(ggo);
						   frame.setVisible(true);
						   frame.pack();
				}
}	