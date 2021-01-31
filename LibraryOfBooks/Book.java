import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * @author Alex Acevedo
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


}
