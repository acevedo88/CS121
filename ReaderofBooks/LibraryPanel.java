import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
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

public class LibraryPanel extends JPanel{

	//Makes the panels and buttons global
	JTextField importDescription;
	JScrollPane bookScrollPane;
	JPanel bookPane;
	Library myLibrary;
	JButton addBook;

	public LibraryPanel(String name)
	{
		
		//Sets the main panel and its layout
		myLibrary = new Library();
		setLayout(new BorderLayout());
		this.setBackground(Color.red);

		//Makes a nice border with a label
		this.setBorder(BorderFactory.createTitledBorder("Library"));

		//Scroll Panel where all book buttons will be added to and on a Y axis set up
		bookPane = new JPanel();
		bookPane.setBackground(Color.green);
		bookPane.setLayout(new BoxLayout(bookPane, BoxLayout.Y_AXIS));

		//Makes a scroll pane that will allow the user to scroll through all the books
		bookScrollPane = new JScrollPane(bookPane);
		bookScrollPane.setBackground(Color.green);
		bookScrollPane.setBorder(BorderFactory.createTitledBorder("Book List"));
		bookScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		bookScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(bookScrollPane, BorderLayout.CENTER);

		//Import box where user will enter the books needed to be loaded
		JPanel importPane = new JPanel();
		importPane.setBackground(Color.red);
		importPane.setBorder(BorderFactory.createTitledBorder("Import Books"));
		
		//Makes a text field that will allow the user to input a description
		importDescription = new JTextField("etext/booklist-full.csv");
		importDescription.setColumns(15);

		//The load button the user will click to submit their entry
		addBook = new JButton("Load");
		importPane.add(importDescription);
		importPane.add(addBook);
		add(importPane, BorderLayout.SOUTH);



	}




}
