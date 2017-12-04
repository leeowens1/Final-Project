import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class SudokuGame{
	SudokuDB SDB = new SudokuDB();						
	SudokuGUI SGUID = new SudokuGUI();					
	ButtonListener listener = new ButtonListener();	// Create BUTT Listener Object
	
	
	public static void main(String args[]) {
		new SalesExpress();
	}
	
public SudokuGame(){
		SDB.connectDB();
		SDB.createTables();
		SGUID.ConstructGUI();

	
	
	
		
}