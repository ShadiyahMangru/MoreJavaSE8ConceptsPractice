import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.util.stream.Stream;
import java.util.function.*;

public class FlatMap{

	Path file = new File("C:\\Users\\593476\\Desktop\\Java Programs\\TabularHockeyData\\2019WSHStatsREV.txt").toPath();

	public BiPredicate<String, String[]> keepMatches = (input, matchThisArray) -> {
		if(matchThisArray.length==0){ //handles an ArrayIndexOutOfBoundsException
			return false;	
		}
		else if(matchThisArray.length==2){
			if(input.contains(matchThisArray[0]) | input.contains(matchThisArray[1])){
				return true;	
			}
			return false;	
		}
		else if(input.contains(matchThisArray[0])){
				return true;	
				
		}
		return false;
	};
	
	public void getMatchCount(String matchCategory, String... matchThis){
	try{
		long matches = 
		Files.lines(file)
		.flatMap(line -> Stream.of(line.split("\n"))) //reads in data line-by-line
		.filter(inputString -> keepMatches.test(inputString, matchThis))
		.peek(match -> {String[] matchArray = match.split(":");
			String ln = matchArray[1].trim();
			int pipeIndexLN = ln.indexOf("|");
			String position = matchArray[2].trim();
			int pipeIndexP = position.indexOf("|");
			HockeyPlayer hp = new HockeyPlayer(ln.substring(0, pipeIndexLN), position.substring(0, pipeIndexP), Integer.parseInt(matchArray[3].trim()), "WSH");
			System.out.println(hp);
			})
		.count();
	
		System.out.println("\n# of " + matchCategory + ": " + matches);
	}
	catch(Exception e){
		System.out.println("Exception: " + e);
	}
	}

	Supplier<String> dataTableHeader  = ()-> String.format("| %-4s | %-15s | %-4s | %-11s |", "TEAM", "PLAYER", "#", "POSITION") +
			"\n-----------------------------------------------";
	
	public void mainMenu(){
		System.out.println("\n\t**********************************************************");
		System.out.println(String.format("%1s %-53s %2s", "\t*", "***** Welcome to Hockey Data Filtering Wizard! *****", "*"));
		System.out.println(String.format("%1s %-53s %2s", "\t*", "", "*"));
		System.out.println(String.format("%1s %-53s %2s", "\t*", "     Query Current Roster to Determine Number of:", "*"));
		System.out.println(String.format("%1s %-53s %2s", "\t*", "      1.) Centers", "*"));
		System.out.println(String.format("%1s %-53s %2s", "\t*", "      2.) Left-Wingers", "*"));
		System.out.println(String.format("%1s %-53s %2s", "\t*", "      3.) Right-Wingers", "*"));
		System.out.println(String.format("%1s %-53s %2s", "\t*", "      4.) Wingers", "*"));
		System.out.println(String.format("%1s %-53s %2s", "\t*", "      5.) Forwards", "*"));
		System.out.println(String.format("%1s %-53s %2s", "\t*", "      6.) Defense", "*"));
		System.out.println(String.format("%1s %-53s %2s", "\t*", "      7.) Goalies", "*"));
		System.out.println(String.format("%1s %-53s %2s", "\t*", " ", "*"));
		System.out.println(String.format("%1s %-53s %2s", "\t*", "      8.) Exit", "*"));
		System.out.println(String.format("%1s %-53s %2s", "\t*", "", "*"));
		System.out.println("\t**********************************************************");
		Console console = System.console();
		String userInput = "";
		if(console != null){
			userInput = console.readLine();
			//console.writer().println("Your selection: " + userInput);
		}
		if(userInput.equals("8")){
			System.exit(0);
		}
		else if(userInput.equals("7")){
			System.out.println("*** Filter Selection: Goalies ***\n");
			System.out.println(dataTableHeader.get());
			getMatchCount("Goalies", "Goalie");
		}
		else if(userInput.equals("6")){
			System.out.println("*** Filter Selection: Defensemen ***\n");
			System.out.println(dataTableHeader.get());
			getMatchCount("Defensemen", "Defense");
		}
		else if(userInput.equals("5")){
			System.out.println("*** Filter Selection: Forwards ***\n");
			System.out.println(dataTableHeader.get());
			getMatchCount("Forwards", "Wing", "Center");
		}
		else if(userInput.equals("4")){
			System.out.println("*** Filter Selection: Wingers ***\n");
			System.out.println(dataTableHeader.get());
			getMatchCount("Wingers", "Wing");
		}
		else if(userInput.equals("3")){
			System.out.println("*** Filter Selection: Right-Wingers ***\n");
			System.out.println(dataTableHeader.get());
			getMatchCount("Right-Wingers", "Right");
		}
		else if(userInput.equals("2")){
			System.out.println("*** Filter Selection: Left-Wingers ***\n");
			System.out.println(dataTableHeader.get());
			getMatchCount("Left-Wingers", "Left");
		}
		else{
			System.out.println("*** Filter Selection: Centers ***\n");
			System.out.println(dataTableHeader.get());
			getMatchCount("Centers", "Center");
		}
		mainMenu();
	}
	
	public static void main(String... args){
		FlatMap fm = new FlatMap();
		fm.mainMenu();
	}

}
