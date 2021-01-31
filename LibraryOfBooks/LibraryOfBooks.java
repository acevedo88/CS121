import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*CS 121 #3 Project 3: LibraryofBooks
 * 
 * This program uses multiple classes to store books into an encapsulated array.  The user can input a book that is valid
 * into the program and it can be printed or read.  The menu selection allows the user to select which task they 
 * wish to perform.  They are able to delete a book but not from the encapsulated array is they wish.  The entire 
 * book .txt file can be read.
 * 
 * @author Alex Acevedo
 * Fall 2018
 */


public class LibraryOfBooks {



	public static void main(String[] args) {

		//This will allow the user to store books but not allow them to alter the Books encapsualation
		Library library = new Library();

		//Main scanner that will be used throughout the program, the quit value, and number of imported songs
		//The inputed value from the user is changed to a lower case for ease of the program.

		Scanner scan = new Scanner(System.in);
		char quit = 'q';


		//Console main menu print out

		System.out.println("*****************************");
		System.out.println("*\tProgram Menu\t    *");
		System.out.println("*****************************");
		System.out.println("(P)rint Library Contents");
		System.out.println("(A)dd Book");
		System.out.println("(D)elete Book");
		System.out.println("(R)ead Book");
		System.out.print("\nPlease enter a command (press 'm' for Menu):");
		String input = scan.nextLine().toLowerCase();
		quit = input.charAt(0);


		//The while loop will continue to cycle through the menu unit the user enters q

		while(quit != 'q' )
			//The switch statement the uses the input of the user to enter into a case

			switch(input)
			{

			case "m":
				System.out.println("\n*****************************");
				System.out.println("*\tProgram Menu\t    *");
				System.out.println("*****************************");
				System.out.println("(P)rint Library Contents");
				System.out.println("(A)dd Book");
				System.out.println("(D)elete Book");
				System.out.println("(R)ead Book");
				System.out.print("\nPlease enter a command (press 'm' for Menu):");
				input = scan.nextLine().toLowerCase();
				quit = input.charAt(0);
				break;

			case "p":
				int index =0;
				
				//Will print out all the songs that are inputed from the load case
				System.out.println("\nBook Library Contains "+library.getBooks().size()+" Books!");
				System.out.println("------------------------------\n");
				
				for(Book books: library.getBooks())
				{
					
					System.out.println("Index: "+index+"\n"+library.getBook(index)+"\n");
					index ++;
				}
				
				System.out.print("\nPlease enter a command (press 'm' for Menu):");
				input = scan.nextLine().toLowerCase();
				quit = input.charAt(0);
				break;

			case "a":

				//The user will enter the book information into the console an it will be stored
				System.out.println("\nAdd Book Catalog...");
				System.out.println("-------------------\n");

				System.out.print("Please enter a Title Name: ");
				String title = scan.nextLine();

				System.out.print("Please enter the Authors Name: ");
				String author = scan.nextLine();


				System.out.print("Please enter the Book Genre: ");
				String genre = scan.nextLine();

				System.out.print("Please enter a Book Filename: ");

				String fileName = scan.nextLine();

				File file = new File(fileName);
				

				//If the file exist and it is a file than it will start the loading process.  If not, it prompts the user
				//saying it is invalid.

				if(file.exists() && file.isFile())
				{	
					Book tempFile = new Book(title,author);
					tempFile.setFilename(fileName);
					tempFile.setGenre(genre);
					library.addBook(tempFile);
					System.out.println("\nSucessfully loaded the "+fileName+" book!");
					
					//System.out.println(library.size());

				}
				else
				{
					System.out.println("\nThe book: " +file+" is not available.  Please return to the Main Menu.");
				}

				//Prints out how many songs were loaded

				System.out.print("\nPlease enter a command (press 'm' for Menu):");
				input = scan.nextLine().toLowerCase();
				quit = input.charAt(0);
				break;


			case "d":

				int value;
				int index1 =0;

				System.out.println("\nDelete a Book Catalog...");
				System.out.println("------------------------\n");

				//For each loop that prints out the booklist and its index so the user can select which one to delete.
				for(Book books: library.getBooks())
				{
					
					System.out.println("Index: "+index1+"\n"+library.getBook(index1)+"\n");
					index1++;
				}
				
								
				System.out.print("Which book number do you wish to delete? ");
				String number;
				number = scan.nextLine();
				value = Integer.parseInt(number);

				//if the index value meets the requirements, it will remove the file or book
				if(value < library.getBooks().size())
				{ 
					library.removeBook(value);
					System.out.println("\nSucessfully removed the book");
				}
				else
				{
					System.out.print("That is not a valid number.  Please try again from the main menu.\n");
				}


				System.out.print("\nPlease enter a command (press 'm' for Menu):");
				input = scan.nextLine().toLowerCase();
				quit = input.charAt(0);
				break;


			
			case "r":
				
				int books;
				int bookValue;
				int index2 =0;
				
				System.out.println("\nRead a Book Catalog...");
				System.out.println("----------------------\n");
				
				//Prints the book list so the user can select an option
				for(Book newbooks: library.getBooks())
				{
					
					System.out.println("Index: "+index2+"\n"+library.getBook(index2)+"\n");
					index2++;
					
				}
				
				//The section the user inputs will print the book it contains
				System.out.print("\nPlease select a number for which book you'd like to read: ");
				String selection;
				selection = scan.nextLine();
				bookValue = Integer.parseInt(selection);
				
				if(bookValue < library.getBooks().size())
				{ 
					System.out.println(library.getBooks().get(bookValue).getText());
				}
				else
				{
					System.out.print("That is not a valid number.  Please try again from the main menu.\n");
				}

				
				
				System.out.print("\nPlease enter a command (press 'm' for Menu):");
				input = scan.nextLine().toLowerCase();
				quit = input.charAt(0);
				break;
				
				
			default:
				System.out.println("\nInvalid Selection");
				System.out.print("\nPlease enter a command (press 'm' for Menu):");
				input = scan.nextLine().toLowerCase();
				quit = input.charAt(0);
				break;


			}
		System.out.println("\nThank you for using Library of Books!!! Goodbye.");
		scan.close();
	}
}
