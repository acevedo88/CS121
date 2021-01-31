import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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


public class Library implements LibraryInterface {

	//Private Attributes
 
	private ArrayList<Book> bookList = new ArrayList<Book>();

	//Constructors.  There should be none.


	//Methods
	public ArrayList<Book> getBooks() {
		ArrayList<Book> copy = new ArrayList<Book>();
		
		for(Book book: bookList)
		{
			copy.add(book);
		}
		
		return copy;
	}

	public void addBook(Book book)
	{
		this.bookList.add(book);
	}

	public void removeBook(int index)
	{
		if(index<bookList.size()-1)
			bookList.remove(index);
	}

	public Book getBook(int index)
	{
		if(!bookList.isEmpty()&&index>=0&&index<bookList.size())
			return bookList.get(index);
		else
		{
		return null;
		}
	}

	public String toString()
	{
		String results = " \n";
		for(Book books: bookList)
		{
			
			results+=books.toString()+"\n";
		}
		return results;
		
	}


	public int size()
	{
		return bookList.size();
	}

	//How the csv file is stored into the array and its contents
	@Override
	public void loadLibraryFromCSV(String csvFilename) 
	{
		
		File file = new File(csvFilename);
		final String DELIMITERS = "[,\n]";
		if(file.exists() && file.isFile())
		{	

			try 
			{
				Scanner fileScan = new Scanner(file);

				while(fileScan.hasNextLine()&&fileScan.hasNext())
				{

					fileScan.useDelimiter(DELIMITERS);
					String title = fileScan.next();
					String author = fileScan.next();
					String genre = fileScan.next();
					String fileName = fileScan.next();

					Book tempFile = new Book(title,author);
					tempFile.setGenre(genre);
					tempFile.setFilename(fileName);
					bookList.add(tempFile);

				}
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
		}
		
	}
}
