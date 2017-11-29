import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SudokuFrame {

    private final JFrame frame = new JFrame("Sudoku ");
	    private Sudoku grid;

    public SudokuFrame() {
        frame.getContentPane().add(grid = new Sudoku(9));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildMenu();
        frame.pack();
        frame.setResizable(false);
        centerView();
        frame.setVisible(true);
    }

    private void buildMenu() {
        JMenuBar bar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem open   = new JMenuItem("Open");
        JMenuItem grid4  = new JMenuItem("4 times 4");
        JMenuItem grid9  = new JMenuItem("9 times 9");
        JMenuItem grid16 = new JMenuItem("16 times 16");

        JMenuItem about = new JMenuItem("About");

        fileMenu.add(open);
        fileMenu.addSeparator();
        fileMenu.add(grid4);
        fileMenu.add(grid9);
        fileMenu.add(grid16);
        fileMenu.addSeparator();
        fileMenu.add(about);

        bar.add(fileMenu);

        open.addActionListener((ActionEvent e) -> {
            JFileChooser chooser = new JFileChooser();
            int status = chooser.showOpenDialog(frame);

            if (status == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                grid.openFile(file);
            }
        });

        grid4.addActionListener((ActionEvent e) -> {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(grid = new Sudoku(4));
            frame.pack();
            centerView();
        });

        grid9.addActionListener((ActionEvent e) -> {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(grid = new Sudoku(9));
            frame.pack();
            centerView();
        });

        grid16.addActionListener((ActionEvent e) -> {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(grid = new Sudoku(16));
            frame.pack();
            centerView();
        });

        about.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(
                   
                    JOptionPane.INFORMATION_MESSAGE);
        });

        frame.setJMenuBar(bar);
    }

    private void centerView() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();

        frame.setLocation((screen.width - frameSize.width) >> 1,
                          (screen.height - frameSize.height) >> 1);
    }
}