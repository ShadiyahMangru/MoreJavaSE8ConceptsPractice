import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class FlatMap{

	Path file = new File("C:\\Users\\593476\\Desktop\\Java Programs\\TabularHockeyData\\2019WSHStats.txt").toPath();

	public void getMatchCount(String matchThis, String matchCategory){
	try{
		long matches = Files.lines(file)
		.flatMap(line -> Stream.of(line.split("\n"))) //reads in data line-by-line
		.filter(inputString -> inputString.contains(matchThis))
		.peek(s -> System.out.println("Match from Input File: " + s))
		.count();
	
		System.out.println("\n# of " + matchCategory + ": " + matches);
	}
	catch(Exception e){
		System.out.println("Exception: " + e);
	}
	}

	public void mainMenu(){
		System.out.println("\n\t**********************************************************");
		System.out.println(String.format("%1s %-53s %2s", "\t*", "***** Welcome to Hockey Roster Querying Wizard! *****", "*"));
		System.out.println(String.format("%1s %-53s %2s", "\t*", "", "*"));
		System.out.println(String.format("%1s %-53s %2s", "\t*", "     Query Current Roster to Determine Number of:", "*"));
		System.out.println(String.format("%1s %-53s %2s", "\t*", "      1.) Centers", "*"));
		System.out.println(String.format("%1s %-53s %2s", "\t*", "      2.) Left-Wingers", "*"));
		System.out.println(String.format("%1s %-53s %2s", "\t*", "      3.) Right-Wingers", "*"));
		System.out.println(String.format("%1s %-53s %2s", "\t*", "      4.) Wingers", "*"));
		System.out.println(String.format("%1s %-53s %2s", "\t*", "      5.) Defense", "*"));
		System.out.println(String.format("%1s %-53s %2s", "\t*", "      6.) Goalies", "*"));
		System.out.println(String.format("%1s %-53s %2s", "\t*", " ", "*"));
		System.out.println(String.format("%1s %-53s %2s", "\t*", "      7.) Exit", "*"));
		System.out.println(String.format("%1s %-53s %2s", "\t*", "", "*"));
		System.out.println("\t**********************************************************");
		Console console = System.console();
		String userInput = "";
		if(console != null){
			userInput = console.readLine();
			console.writer().println("Your selection: " + userInput);
		}
		if(userInput.equals("7")){
			System.exit(0);
		}
		else if(userInput.equals("6")){
			getMatchCount("Goalie", "Goalies");
		}
		else if(userInput.equals("5")){
			getMatchCount("Defense", "Defensemen");
		}
		else if(userInput.equals("4")){
			getMatchCount("Wing", "Wingers");
		}
		else if(userInput.equals("3")){
			getMatchCount("Right", "Right-Wingers");
		}
		else if(userInput.equals("2")){
			getMatchCount("Left", "Left-Wingers");
		}
		else{
			getMatchCount("Center", "Centers");
		}
		mainMenu();
	}
	
	public static void main(String... args){
		FlatMap fm = new FlatMap();
		fm.mainMenu();
	}

}