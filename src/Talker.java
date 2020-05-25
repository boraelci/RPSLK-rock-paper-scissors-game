/**
 * This class holds the message for greeting the user when the game starts.
 * @author Bora Elci
 */
public class Talker {
	
	public String welcomeText;

	/**
	 * @param welcomeText holds the welcome text to be displayed
	 */
	public Talker() {
		welcomeText = ("\nWelcome to the game of Rock Paper Scissors Lizard Spock!\n"
				+ "100 consecutive plays will be played in this game.");
	}
	/**
	 * Prints the welcome text to the console.
	 */	
	public void displayText() {	
		System.out.println(welcomeText);		
	}
}
