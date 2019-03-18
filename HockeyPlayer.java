import java.util.function.*;

/**
* The HockeyPlayer class provides a template for a HockeyPlayer object.
* The HockeyPlayer object has a last name, position, jersey number, and team.
* One must initialize a HockeyPlayer object with a last name, position, and jersey number;
* specifying the HockeyPlayer object's team upon object initialization is optional.
<p>
* setTeam() enables code flexibility.  This setter method enables change of the HockeyPlayer object's 
* team instance variable value after initialization.
* setTeamWSH() enables a HockeyPlayer object's team instance variable to easily equal WSH.
<p>
* getLastName(), getPosition(), getJersey(), getTeam() exist so that other classes may not have direct
* access to private fields of the HockeyPlayer class.  They return the curent last name, position, jersey, and team
* values of the HockeyPlayer object's instance variables.
<p>
* This class' utility Lambdas: 
* (i) filterOutGoalies / keepGoalies returns true if the HockeyPlayer is not / is a goalie.  The two Lambdas are static.
* (ii) evenNumberPlayers returns true if the HockeyPlayer wears an even-numbered jersey.
* (iii) assignTeam returns the "WSH" String.

* @author  Shadiyah Mangru
* @since   2019
*/
public class HockeyPlayer{
	//fields
	private String lastName;
	private String position;
	private int jersey;
	private String team;

	//constructors
	/**
	* This constructor initializes a HockeyPlayer object (an instance of the HockeyPlayer class).
	* The lastName, position, and jersey values are user-defined.
	* The team value defaults to 'undefined' 
	* @param lastName 
	* @param position 
	* @param jersey 
	*/
	//initialize HockeyPlayer object without a specific team
	public HockeyPlayer(String lastName, String position, int jersey){
		this.lastName = lastName;
		this.position = position;
		this.jersey = jersey;
		setTeam("undefined");
	}
	
	/**
	* This constructor initializes a HockeyPlayer object (an instance of the HockeyPlayer class).
	* The lastName, position, jersey, and team values are user-defined.
	* @param lastName 
	* @param position 
	* @param jersey 
	* @param team 
	*/
	//initialize HockeyPlayer object with a specific team
	public HockeyPlayer(String lastName, String position, int jersey, String team){
		this.lastName = lastName;
		this.position = position;
		this.jersey = jersey;
		this.team = team;
	}

	//setter
	/**
	* This setter sets the HockeyPlayer object's team instance variable to a user-defined value.
	* @param team 
	*/
	public void setTeam(String team){
		this.team = team;	
	}
	
	/**
	* This setter sets the HockeyPlayer object's team instance variable to WSH (Washington Capitals).
	*/
	public void setTeamWSH(){
		team = "WSH";	
	}
	
	//getters
	/**
	* This getter returns the current value of the HockeyPlayer object's last name instance variable value.
	* @return this HockeyPlayer object's last name (in the form of a String)
	*/
	public String getLastName(){
		return lastName;
	}
	
	/**
	* This getter returns the current value of the HockeyPlayer object's position instance variable value.
	* @return this HockeyPlayer object's position (in the form of a String)
	*/
	public String getPosition(){
		return position;
	}	
	
	/**
	* This getter returns the current value of the HockeyPlayer object's jersey instance variable value.
	* @return this HockeyPlayer object's jersey number (in the form of an int)
	*/
	public int getJersey(){
		return jersey;
	}
	
	/**
	* This getter returns the current value of the HockeyPlayer object's team instance variable value.
	* @return This HockeyPlayer object's team (in the form of a String)
	*/
	public String getTeam(){
		return team;	
	}
	
	/**
	* toString() returns the team, last name, jersey and position values of the HockeyPlayer object, formatted for a data table.
	* @return data table formatting of HockeyPlayer object's instance variable values (in the form of a String)
	*/
	@Override
	public String toString(){
		return String.format("| %-4s | %-15s | %-4s | %-11s |", team, lastName, jersey, position);
	}
	
	//utility Lambdas
	/**
	* This Lambda accepts a HockeyPlayer parameter and returns true if this HockeyPlayer is NOT a Goalie.
	* This lambda is static and therefore may be called without being tethered to a specific instance of the HockeyPlayer class.
	* @return T/F response to 'this HockeyPlayer object is NOT a goalie' (in the form of a boolean)
	*/
	public static Predicate<HockeyPlayer> filterOutGoalies = hp -> {
		if(!hp.getPosition().equals("Goalie")){
			return true;	
		}
		return false;	
	};
	
	/**
	* This Lambda accepts a HockeyPlayer parameter and returns true if this HockeyPlayer IS a Goalie.
	* This lambda is static and therefore may be called without being tethered to a specific instance of the HockeyPlayer class.
	* @return T/F response to 'this HockeyPlayer object IS a goalie' (in the form of a boolean)
	*/
	public static Predicate<HockeyPlayer> keepGoalies = hp -> {
		if(hp.getPosition().equals("Goalie")){
			return true;	
		}
		return false;	
	};
	
	/**
	* This Lambda accepts a HockeyPlayer parameter and returns true if this HockeyPlayer wears an even-numbered jersey
	* @return T/F response to 'this HockeyPlayer object wears an even-numbered jersey' (in the form of a boolean)
	*/
	public Predicate<HockeyPlayer> evenNumberPlayers = hp -> {
		if(hp.getJersey() % 2 == 0){
			return true;	
		}
		return false;	
	};
	
	/**
	* This lambda takes no parameters and returns the String "WSH".
	* @return the team WSH (in the form of a String)
	*/
	public Supplier<String> assignTeam = () -> {
		return "WSH";
	};
}