/**
 * @author Bora Elci
 * @version Final
 */

/**
 *Keywords "Rock", "Paper", "Scissors", "Lizard, "Spock" are shortened as 'r', 'p', 's', 'l', 'k' respectively throughout the program.
 *This is the main class and it collaborates with Talker, Thrower, Select, Recorder, and Sim classes.
 */
public class Runner {
	
/**
 * This main method initiates objects of rest of the classes and calls their methods in the correct order for the game to be properly played.
 * 
 * This main method initiates an object of Talker class.
 * It calls this class's displayText() method for showing a welcome text to the user.
 * 
 * Objects of Thrower, Select, Recorder, and Sim classes are initiated.
 * 
 * For a specified of rounds, the game is consecutively played in a for loop.
 * Gets the computer choice from the Thrower class.
 * Gets the user choice from the Select class.
 * Gets the outcome of the current round from comparison of user and computer throws.
 * Saves the user's recent throw in the Recorder class.
 * Saves the computer's recent throw in the Recorder class.
 * After the for loop terminates, this method gets the overall result of the game.
 * This result includes the counts and percentages of wins, losses, and ties from the user's perspective.
 * 
 * Test cases of each strategy of computer and user throws are documented in the corresponding method's javadoc portion.
 * 
 * @param rounds number of rounds to be consecutively played
 */
	public static void main(String[] args) {
		
		double ROUNDS = 1000.0;
		
		System.out.println("Developed by Bora Elci");
		
		Talker welcome = new Talker();
		welcome.displayText();
		
		Thrower computer = new Thrower();
		Select user = new Select();
		Recorder record = new Recorder();
		Sim simUser = new Sim();
		
		for(int i=0; i<ROUNDS; i++) {
		
		String computerChoice = computer.getChoice(record);
		String userChoice = user.getChoice(simUser, record);
		
		user.compareThrows(computerChoice, userChoice);
		
		record.saveUserThrow(userChoice);
		record.saveRecentComputerThrow(computerChoice);	
		}
		
		user.getResults(ROUNDS);
	}
}
