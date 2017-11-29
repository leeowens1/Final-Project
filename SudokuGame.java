import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.awt.event.KeyListener;

public class SudokuGame{
	SudokuDB SDB = new SudokuDB();						
	SudokuGUI SGUID = new SudokuGUI();					
	ButtonListener listener = new ButtonListener();	// Create BUTT Listener Object
	KeyListener listener = new KeyListener
	
	// Customer vars
	//int CustomerCount;
	//int CustomerPosition; 
	//int CustomerFormState = 0;  // 0 standard, 1 add, 2 edit
	//ArrayList<Integer> CustomerIds = new ArrayList<Integer>();
	
	public static void main(String args[]) {
		new SalesExpress();
	}
	
public SudokuGame(){
		SDB.connectDB();
		SDB.createTables();
		SGUID.ConstructGUI();
		
		
		
	SGUID.NewGameBut.addActionListener(listener);
	
		
	}