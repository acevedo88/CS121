import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
/**
 * CS 121 #3 Project 2: JukeboxHero
 * 
 * This project uses two song csv files to load into an array and stores the information.  With user input, they can
 * enter the menu and request either to search for a song, print the entire list, or analyze through the files that 
 * were imported.  This program will continue to run until the user quits the program or enters q.
 * 
 * @author alexacevedo
 * @version Fall 2018
 * 
 */


public class JukeboxHero {

	public static void main(String[] args) {


		//List of arrays the will store csv files when loaded

		ArrayList<Song> songList = new ArrayList<Song>();
		

		//Main scanner that will be used throughout the program, the quit value, and number of imported songs
		//The inputed value from the user is changed to a lower case for ease of the program.

		Scanner scan = new Scanner(System.in);
		char quit = 'q';
		

		//Console main menu print out

		System.out.println("*****************************");
		System.out.println("*\tProgram Menu\t    *");
		System.out.println("*****************************");
		System.out.println("(L)oad catalog");
		System.out.println("(S)earch catalog");
		System.out.println("(A)nalyze catalog");
		System.out.println("(P)rint catalog");
		System.out.println("(Q)uit");
		System.out.print("\nPlease enter a command (press 'm' for Menu):");
		String input = scan.nextLine().toLowerCase();
		quit = input.charAt(0);


		//The while loop will continue to cycle through the menu unit the user enters q

		while(quit != 'q' )

			//The switch statement the uses the input of the user to enter into a case

			switch(input)
			{

			//Main menu case statement. 

			case "m":
				System.out.println("*****************************");
				System.out.println("*\tProgram Menu\t    *");
				System.out.println("*****************************");
				System.out.println("(L)oad catalog");
				System.out.println("(S)earch catalog");
				System.out.println("(A)nalyze catalog");
				System.out.println("(P)rint catalog");
				System.out.println("(Q)uit");
				System.out.print("\nPlease enter a command (press 'm' for Menu):");
				input = scan.nextLine().toLowerCase();
				quit = input.charAt(0);
				break;

				//The load file case statement.  User enters one of the two stored files and will load them into the songList 
				//array.  It will then tell the user how many songs were loaded.  Uses a delimiter to scan through the file
				//and store each section into its own variable.
			case "l":

				System.out.println("\nLoad Catalog...");
				System.out.print("Please enter a Filename: ");

				String fileName = scan.nextLine();

				File file = new File(fileName);
				int songCount = 0 ;

				final String DELIMITERS = "[,\n]";	

				//If the file exist and it is a file than it will start the loading process.  If not, it prompts the user
				//saying it is invalid.

				if(file.exists() && file.isFile())
				{	

					//Clears the stored files from a previous entry

					songList.clear();

					try 
					{
						Scanner fileScan = new Scanner(file);


						//As long as there is a next line, the while loop will continue until it reaches the end and stores 
						//each value into its own variable

						while(fileScan.hasNextLine()&&fileScan.hasNext())
						{
							songCount++;


							fileScan.useDelimiter(DELIMITERS);
							String artist = fileScan.next();
							String album = fileScan.next();
							String title = fileScan.next();

							String time = fileScan.next();
							int seconds = Integer.parseInt(time);

							Song tempFile = new Song(title, artist, album, seconds);
							songList.add(tempFile);



						}
					} 
					catch (FileNotFoundException e) 
					{
						e.printStackTrace();
					}
				}
				else
				{
					System.out.println("Not a valid file: " +file);
				}

				//Prints out how many songs were loaded

				System.out.println("Sucessfully loaded "+songCount+" songs!");


				System.out.print("\nPlease enter a command (press 'm' for Menu):");
				input = scan.nextLine().toLowerCase();
				quit = input.charAt(0);
				break;

				//Search case

			case "s":
				
				//ArrayList that will store a user query if it is in the title of a song
				ArrayList<Song> searchResult = new ArrayList<Song>();
				
				System.out.println("\nSearch Catalog...");
				System.out.print("Please enter the search query: ");

				String search = scan.nextLine().toString().toLowerCase();
				
				//Walks throught the songList and if the search is contained within a title it will store it in the array
				for(Song result: songList)
				{
				
				
					if(result.getTitle().toLowerCase().contains(search))
					{
						searchResult.add(result);
					}
				
				}
				
				//Prints out how many songs that contained the users query.  
				System.out.println("\nFound " +searchResult.size()+" matches for the query.");
				System.out.println("----------------------------\n");
				
				for(Song newList: searchResult)
				{
					System.out.println(newList);
				}
				

				System.out.print("\n\nPlease enter a command (press 'm' for Menu):");
				input = scan.nextLine().toLowerCase();
				quit = input.charAt(0);
				break;

			case "a":
				//Analyze case
				
				//Arrays that will store how many artist there are and how many albums
				ArrayList<String> artistList = new ArrayList<String>();
				ArrayList<String> albumList = new ArrayList<String>();
				int songRunTime=0;
				
				//For each loops to go through the songList and store artists and albums.
				for(Song aList: songList)
				{

					if(!artistList.contains(aList.getArtist()))
					{
						artistList.add(aList.getArtist());
					}

				
				}
				for(Song bList: songList)
				{

					if(!albumList.contains(bList.getAlbum()))
					{
						albumList.add(bList.getAlbum());
					}

				
				}
				
				//For loop to get total play time for files
				for(Song runtime: songList)
				{
					songRunTime=songRunTime+runtime.getPlayTime();
				}

				//Prints out each lists
				System.out.println("\nCatalog Analysis...");
				System.out.println("\tNumber of Artist: "+artistList.size());
				System.out.println("\tNumber of Albums: "+albumList.size());
				System.out.println("\tNumber of Songs: "+songList.size());
				System.out.println("\tCatalog Playtime: "+songRunTime);
				
				
				System.out.print("\nPlease enter a command (press 'm' for Menu):");
				input = scan.nextLine().toLowerCase();
				quit = input.charAt(0);
				break;

			//Print case
			case "p":
				
				//Will print out all the songs that are inputed from the load case
				System.out.println("Song List Contains "+songList.size()+" songs!");
				System.out.println("----------------------------\n");

				for(Song s: songList)
				{
					System.out.println(s);
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







		System.out.println("\nThank you for using JukeboxHero!!!  Goodbye.");
	}

}