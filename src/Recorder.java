import java.util.ArrayList;

/**
 * This class stores the user throw history and computer throw history of the game.
 * @author Bora Elci
 */
public class Recorder {
	
	public ArrayList<String> userThrowHistory;
	public String recentComputerThrow;
	public ArrayList<String> computerThrowHistory;
	public int currentRound;
	
	/**
	 * This method records the history of user and computer throws.
	 * Initiates one ArrayList for user throws and one for computer throws.
	 * Increments the current round by one at the end of each round to update the correct index of the ArrayLists.
	 * ArrayList is used for dynamic re-sizing, as well as to serve other Thrower and Select classes' need to access elements by their index reference.
	 * The most recent computer throw is also stored in a single variable for the RecorderStrategy of the Thrower class to easily access it.
	 */
	public Recorder() {	
		userThrowHistory = new ArrayList<String>();
		recentComputerThrow = "r";
		computerThrowHistory = new ArrayList<String>();
		currentRound = 0;	
	}
	
	/**
	 * This method saves the user throw into the ArrayList.
	 * @param userChoice user's choice of RPSLK
	 */
	public void saveUserThrow(String userChoice) {		
		userThrowHistory.add(userChoice);	
		}
	
	/**
	 * This method saves the most recent computer throw both into the variable and into the ArrayList.
	 * @param computerChoice computer's choice of RPSLK
	 */
	public void saveRecentComputerThrow(String computerChoice) {		
		recentComputerThrow = computerChoice;
		computerThrowHistory.add(computerChoice);		
	}	
}
