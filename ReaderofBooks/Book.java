import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

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

public class Book implements BookInterface {

	//Private book attributes

	private String title;
	private String author;
	private String genre;
	private String filename;

	//Constructors

	public Book(String title, String author) 
	{
		this.title=title;
		this.author=author;


	}

	//Setters and getters


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}


	//Prints out attributes for book

	public String toString()
	{
		String str = "";

		str += "Title: "+ title + "\nAuthor: " + author + "\nGenre: " + genre+ "\nFilename: "+ filename;
		return str;

	}

	public boolean isValid()
	{
		if(title != null && author != null && genre != null && filename != null)
		{
			File file = new File(filename);
			if(file.isFile())
			{
				return true;
			}
			
		}

		return false;
		
	}

	
	public String getText()
	{
		
		
		File file = new File(filename);
		StringBuilder txt = new StringBuilder();
		try
		{
			Scanner fileScan = new Scanner(file);
			while(fileScan.hasNextLine())
			{
				txt.append(fileScan.nextLine()+"\n");
			}
			fileScan.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("There was no text found");
		}
		return txt.toString();
	}

	
	public BufferedReader getBookReader() 
	{
		
		BufferedReader newBookReader = null;
		try {
			 newBookReader = new BufferedReader(new FileReader(this.filename));
		} catch (FileNotFoundException e) {
			// Do nothing, we will return null if exception thrown
		}
		return newBookReader;
	}
	

}
