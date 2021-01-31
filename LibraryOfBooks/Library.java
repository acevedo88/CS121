import java.util.ArrayList;

/*
 * @author Alex Acevedo
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
}
