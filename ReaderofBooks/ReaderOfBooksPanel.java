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
import java.io.IOException;


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

//Main panel that implements buttons and listeners
public class ReaderOfBooksPanel extends JPanel {

	//Declares each panel as instances so they can be used globally
	ReaderPanel readPanel;
	LibraryPanel libraryPanel;

	public ReaderOfBooksPanel()
	{

		//Sets the size of the main JPanel
		this.setPreferredSize(new Dimension(950, 600));	
		setLayout(new BorderLayout());


		//Sets the library panel to the west part of the GUI and adds its title
		libraryPanel = new LibraryPanel("Library");
		add(libraryPanel, BorderLayout.WEST);
		
		//Makes a listener for the load button to add all the books to the panel
		libraryPanel.addBook.addActionListener(new addBookListener());

		//Sets the reader panel to the center of the GUI and labels it 
		readPanel = new ReaderPanel("Reader");
		add(readPanel, BorderLayout.CENTER);


	}


	//Book Button Listener to load texts into Content Pane
	private class BookButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			//Gets the source file for the book and displays its texts on the text field
			BookButton bookListButton = (BookButton) e.getSource();
			
			//Just for my sanity to see the button being clicked
			System.out.println("Clicked");

			//Sets the texts on the textfield and the display starts at the begining instead of the end
			readPanel.contentPane.setText(bookListButton.getNewBookText());
			readPanel.contentPane.setSelectionStart(0);
			readPanel.contentPane.setSelectionEnd(0);
			
			//Sets the new book title and author each time a new book is pressed
			readPanel.title.setText("Title: " + bookListButton.getNewBookTitle() + "     ");
			readPanel.by.setText("By: " + bookListButton.getNewBookAuthor() + "     ");

		}
	}

	//Book Load button that will check if files are valid and make book buttons
	private class addBookListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {

			String input = libraryPanel.importDescription.getText();

			File file = new File(input);

			if(file.isFile()&&file.exists())
			{
				System.out.println(file+" is a file.");


				libraryPanel.myLibrary.loadLibraryFromCSV(input);

				for(Book tempBook: libraryPanel.myLibrary.getBooks())
				{
					BookButton newBookButton = new BookButton(tempBook);
					newBookButton.setForeground(Color.BLACK);

					newBookButton.addActionListener(new BookButtonListener());

					libraryPanel.bookPane.add(newBookButton);

				}
				revalidate();
			}
			
			//Else statement the will display an error message saying the book file is incorrect if its not valid
			else
			{
				System.out.println(file+" is not a file.");
				JOptionPane.showMessageDialog(null, "That is not a valid book file", "ERROR", JOptionPane.ERROR_MESSAGE);
			}

		}

	}
}
