import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/*CS 121 #3 Project 4: ReaderOfBooks
* 
* This program uses a Graphical User Interface that will allow the user to input a .csv file which contains a list
* of Books.  The user can select a book once uploaded and read its texts which is displayed on another panel.  The
* interface displays the book information on top and the page number the user is currently on.  There are Navigation
* buttons that allow the user to go up or down a page if they wish to do so.
* 
* @author Alex Acevedo
* Fall 2018
*/


//Main Driver for the project
public class ReaderOfBooks
{ 
	
	public static void main(String[] args)
	{
		//The top name of the JPanel and action the GUI does when closed is clicked
		JFrame frame = new JFrame("Reader of Books");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Makes the main panel for each other panel to use
		ReaderOfBooksPanel panel = new ReaderOfBooksPanel();
		frame.getContentPane().add(panel);
		
		//Packs the entire code and displays the GUI
		frame.pack();
		frame.setVisible(true);
	}
}

