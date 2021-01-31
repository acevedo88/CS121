import java.util.Scanner;
import java.applet.AudioClip;
import java.applet.Applet;
import java.io.File;
import java.net.URL;
import java.text.DecimalFormat;

public class PlayList {
	
	public static void main(String[] args)
	{
		Scanner song = new Scanner(System.in);
		
		//First Song User Input
		System.out.println("Please enter the following information for your Playlist:\n");
		System.out.print("Song Title: ");
		String title1 = song.nextLine();
		
		System.out.print("Song Artist: ");
		String artist1 = song.nextLine();
		
		System.out.print("Song Play Time (mm:ss): ");
		String playTime1 = song.nextLine();
		
		System.out.print("Song File Name: ");
		String fileName1 = song.nextLine();
		
		//Substring function to find the colon and than convert minutes to seconds
		int colon1 = playTime1.indexOf(":");
		String minutes1 = playTime1.substring(0,colon1);
		String seconds1 = playTime1.substring(colon1+1);
		
		int totalTime1 = (Integer.parseInt(minutes1))*60+Integer.parseInt(seconds1);
		
		//Stores the values inputed for the song and stores them 
		Song song1 = new Song(title1, artist1, totalTime1, fileName1);
		
		//Prints out what the user inputed
		System.out.println("\nTitle: "+song1.getTitle());
		System.out.println("Artist: "+song1.getArtist());
		System.out.println("Play Time: "+song1.getPlayTime()+" seconds");
		System.out.println("File Path: "+song1.getFilePath());
		
		//Second Song User Input
		System.out.println("\n=========================================================");
		
		System.out.println("Please enter the following information for your Playlist:\n");
		System.out.print("Song Title: ");
		String title2 = song.nextLine();
		
		System.out.print("Song Artist: ");
		String artist2 = song.nextLine();
		
		System.out.print("Song Play Time (mm:ss): ");
		String playTime2 = song.nextLine();
		
		System.out.print("Song File Name: ");
		String fileName2 = song.nextLine();
		
		//Substring function to find the colon and than convert minutes to seconds
		int colon2 = playTime2.indexOf(":");
		String minutes2 = playTime2.substring(0,colon2);
		String seconds2 = playTime2.substring(colon2+1);
		
		int totalTime2 = (Integer.parseInt(minutes2))*60+Integer.parseInt(seconds2);
		
		//Stores the values inputed for the song and stores them 
		Song song2 = new Song(title2, artist2, totalTime2, fileName2);
		
		//Prints out what the user inputed
		System.out.println("\nTitle: "+song2.getTitle());
		System.out.println("Artist: "+song2.getArtist());
		System.out.println("Play Time: "+song2.getPlayTime()+" seconds");
		System.out.println("File Path: "+song2.getFilePath());
		
		//Third Song User Input
		System.out.println("\n=========================================================");
		
		System.out.println("Please enter the following information for your Playlist:\n");
		System.out.print("Song Title: ");
		String title3 = song.nextLine();
		
		System.out.print("Song Artist: ");
		String artist3 = song.nextLine();
		
		System.out.print("Song Play Time (mm:ss): ");
		String playTime3 = song.nextLine();
		
		System.out.print("Song File Name: ");
		String fileName3 = song.nextLine();
		
		//Substring function to find the colon and than convert minutes to seconds
		int colon3 = playTime2.indexOf(":");
		String minutes3 = playTime3.substring(0,colon3);
		String seconds3 = playTime3.substring(colon3+1);
		
		int totalTime3 = (Integer.parseInt(minutes3))*60+Integer.parseInt(seconds3);
		
		//Stores the values inputed for the song and stores them 
		Song song3 = new Song(title3, artist3, totalTime3, fileName3);
		
		//Prints out what the user inputed
		System.out.println("\nTitle: "+song3.getTitle());
		System.out.println("Artist: "+song3.getArtist());
		System.out.println("Play Time: "+song3.getPlayTime()+" seconds");
		System.out.println("File Path: "+song3.getFilePath());
		
		//Stores average play time after its calculated into a float
		float averagePlayTime = ((float)(song1.getPlayTime()+song2.getPlayTime()+song3.getPlayTime()))/3;
		
		//Formates average play time and places two decimal places
		DecimalFormat average = new DecimalFormat("#.00");
		
		System.out.println("\n=========================================================");
		
		System.out.println("\nAverage Play Time: " +average.format(averagePlayTime)+" seconds");
		
		//Uses stored song play times and finds whats the closest to 240 seconds
		int goal = 240;
		
		double song1Time = Math.abs(song1.getPlayTime()-goal);
		double song2Time = Math.abs(song2.getPlayTime()-goal);
		double song3Time = Math.abs(song3.getPlayTime()-goal);
		
		System.out.println("\n====================================================================================");
		if (song1Time <= song2Time && song1Time <= song3Time)
		{
			System.out.println("\nSong Play with playtime closest to 240 seconds is: "+title1);
		}
		else if (song2Time <= song3Time && song2Time <= song1Time)
		{
			System.out.println("\nSong Play with playtime closest to 240 seconds is: "+title2);
		}
		else if (song3Time <= song1Time && song3Time <= song2Time)			
		{
			System.out.println("\nSong Play with playtime closest to 240 seconds is: "+title3);
		}
		else
		{
			System.out.println("Some of the songs have equal the same distance to 240 seconds");
		}
		
		//Formats songs in order closest to 240 and prints out an output according to assignment display
		
		String titles = "Title";
		String artists = "Artist";
		String fPaths = "FilePath";
		String pTimes = "PlayTime";
		
		System.out.println ("\n==============================================================================");
		
		System.out.println ("Title"+"\t\t     "+"Artist"+"\t\t  "+"FilePath"+"\t\t      "+"PlayTime");
		
		System.out.println ("==============================================================================");
		
		if(song1Time <= song2Time && song2Time <= song3Time)
		{
			System.out.println (String.format("%-20s %-20s %-25s %10d", title1, artist1, fileName1, totalTime1));
			System.out.println (String.format("%-20s %-20s %-25s %10d", title2, artist2, fileName2, totalTime2));
			System.out.println (String.format("%-20s %-20s %-25s %10d", title3, artist3, fileName3, totalTime3));
			System.out.println ("==============================================================================");
		}
		else if (song1Time <= song3Time && song3Time <=song2Time)
		{
			System.out.println (String.format("%-20s %-20s %-25s %10d", title1, artist1, fileName1, totalTime1));
			System.out.println (String.format("%-20s %-20s %-25s %10d", title3, artist3, fileName3, totalTime3));
			System.out.println (String.format("%-20s %-20s %-25s %10d", title2, artist2, fileName2, totalTime2));
			System.out.println ("==============================================================================");
		}
		else if (song2Time <= song1Time && song1Time <= song3Time)
		{
			System.out.println (String.format("%-20s %-20s %-25s %10d", title2, artist2, fileName2, totalTime2));
			System.out.println (String.format("%-20s %-20s %-25s %10d", title1, artist1, fileName1, totalTime1));
			System.out.println (String.format("%-20s %-20s %-25s %10d", title3, artist3, fileName3, totalTime3));
			System.out.println ("==============================================================================");
		}
		else if (song2Time <= song3Time && song3Time <= song1Time)
		{
			System.out.println (String.format("%-20s %-20s %-25s %10d", title2, artist2, fileName2, totalTime2));
			System.out.println (String.format("%-20s %-20s %-25s %10d", title3, artist3, fileName3, totalTime3));
			System.out.println (String.format("%-20s %-20s %-25s %10d", title1, artist1, fileName1, totalTime1));
			System.out.println ("==============================================================================");
		}
		else if (song3Time <= song2Time && song2Time <= song1Time)
		{
			System.out.println (String.format("%-20s %-20s %-25s %10d", title3, artist3, fileName3, totalTime3));
			System.out.println (String.format("%-20s %-20s %-25s %10d", title2, artist2, fileName2, totalTime2));
			System.out.println (String.format("%-20s %-20s %-25s %10d", title1, artist1, fileName1, totalTime1));
			System.out.println ("==============================================================================");
		}
		else if (song3Time <= song1Time && song1Time <= song2Time)
		{
			System.out.println (String.format("%-20s %-20s %-25s %10d", title3, artist3, fileName3, totalTime3));
			System.out.println (String.format("%-20s %-20s %-25s %10d", title1, artist1, fileName1, totalTime1));
			System.out.println (String.format("%-20s %-20s %-25s %10d", title2, artist2, fileName2, totalTime2));
			System.out.println ("==============================================================================");
		}
		else
		{
			System.out.println("There was an error with one of you inputs!!!");
			System.out.println ("==============================================================================");
		}
		
	}
	
}
