import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SudokuGame{
	SudokuDB SDB = new SudokuDB();						
	SudokuGUI SGUID = new SudokuGUI();					
	ButtonListener listener = new ButtonListener();		// Create BUTT Listener Object
	
	// Customer vars
	//int CustomerCount;
	//int CustomerPosition; 
	//int CustomerFormState = 0;  // 0 standard, 1 add, 2 edit
	//ArrayList<Integer> CustomerIds = new ArrayList<Integer>();
	
	public static void main(String args[]) {
		new SalesExpress();
	}
	
public SudokuExpress(){
		
		SDB.connectDB();
		SDB.createTables();
		SGUID.ConstructGUI();
	}