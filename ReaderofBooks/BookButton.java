import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;

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

public class BookButton extends JButton{
	
	//Makes variable global
	private Book books;
	
	public BookButton(Book books)
	{
		this.books=books;
		
		//If the title of the book is more that 19 characters, it will be condensed to 19
		if (books.getTitle().length() < 19)
		{
		setText(books.getTitle());
		this.setToolTipText(books.toString());
		this.setMaximumSize(new Dimension(400,40));
		this.setAlignmentX(CENTER_ALIGNMENT);
		}
		
		//If the title of the book isn't more than 19 characters, then nothing will happen to its text
		else
		{
			setText(books.getTitle().substring(0, 19));
			this.setToolTipText(books.toString());
			this.setMaximumSize(new Dimension(400,40));
			this.setAlignmentX(CENTER_ALIGNMENT);
		}
		
		
		
	}

	//New methods that will help get the book's title, text, and author in the readerofbookspanel()
	public BufferedReader getReaderOfBooks () {
		return this.books.getBookReader();
	}

	public String getNewBookText () {
		return this.books.getText();
	}
	

	public String getNewBookTitle () {
		return this.books.getTitle();
	}
	

	public String getNewBookAuthor () {
		return this.books.getAuthor();
	}
}
