
import java.util.Random;
import java.lang.Math;
import java.util.ArrayList;

/**
 * Determines the computer's choice of Rock, Paper, Scissors, Lizard, or Spock.
 * @author Bora Elci
 */

public class Thrower {
	
	public String computerChoice;
	
	public Thrower() {
		
	}
	
	public String getChoice(Recorder record){	
		if (record.userThrowHistory.size() < 10) {	
			computerChoice = RandomStrategy();	//to collect enough game history for determining user's pattern
		}
		else {
			computerChoice = RevengeStrategy(record);
			//computerChoice = RecorderStrategy(record);
		}
		return computerChoice;
	}
	
	/**
	 * This method outputs the computer's "best" throw using the Recorder Strategy.
	 * It collaborates with the Recorder class to get the user throws history.
	 * The algorithm counts how many times each choice (RPSLK) is thrown by the user throughout the game.
	 * It transforms this number into a percentage by dividing it with the number of rounds played.
	 * Based on the user's tendency to throw certain choices more frequently, it calls the realWeigthed() method for computing the "best" counter-throw.
	 * 
	 * {@link realWeighted}
	 * 
	 * This strategy proved useful when playing against a user who prefers some choices over others.
	 * For the 100 rounds of testing, NOT FINISHED
	 * 
	 * @param record stores user throws history from the beginning of the game
	 * @return computer's "best" throw
	 */
	public String RecorderStrategy(Recorder record) {
		
		String computerChoice = "E";
		
		double rocksTotal = 0.0;
		double papersTotal = 0.0;
		double scissorsTotal = 0.0;
		double lizardsTotal = 0.0;
		double spocksTotal = 0.0;
		
		for(int j = 0; j < record.userThrowHistory.size(); j++) {
			String current = record.userThrowHistory.get(j);
			
			switch (current) {
			case "r":
				rocksTotal++;
				break;
			case "p":
				papersTotal++;
				break;
			case "s":
				scissorsTotal++;
				break;
			case "l":
				lizardsTotal++;
				break;
			case "k":
				spocksTotal++;
				break;
			}	
			}
			
			double perRocks = (rocksTotal)/(record.userThrowHistory.size())*100;
			double perPapers = (papersTotal)/(record.userThrowHistory.size())*100;
			double perScissors = (scissorsTotal)/(record.userThrowHistory.size())*100;
			double perLizards = (lizardsTotal)/(record.userThrowHistory.size())*100;
			double perSpocks = (spocksTotal)/(record.userThrowHistory.size())*100;
			
			computerChoice = realWeighted(perRocks, perPapers, perScissors, perLizards, perSpocks);
			
			return computerChoice;
			}
	
	
	/**
	 * This method takes in the percentages of throws played by the user from the beginning of the game.
	 * It creates an empty ArrayList.
	 * Computes one tenth of the percentage of a choice the user plays.
	 * Fills the ArrayList with this choice's counter throws as many times as one tenth of the percentage of the choice the user played.
	 * This increases the chance for the computer to pick a counter throw for the user's most frequent choices.
	 * It decreases the possibility that computer would pick a counter choice to throws that user less frequently plays.
	 * In the end, the computer picks a random choice from the ArrayList; however, it tends to counter the user's most frequent throws.
	 * 
	 * @return the computer's best possible throw
	 */
	public String realWeighted(double perRocks, double perPapers, double perScissors, double perLizards, double perSpocks) {
		
		ArrayList<String> realWeightedArray = new ArrayList<String>();
		
		int n = 0;
		
		int intRocks = (int)Math.round(perRocks)/10;
		int intPapers = (int)Math.round(perPapers)/10;
		int intScissors = (int)Math.round(perScissors)/10;
		int intLizards = (int)Math.round(perLizards)/10;
		int intSpocks = (int)Math.round(perSpocks)/10;
		
		for (int k = 0; k < (intRocks); k++) {
			realWeightedArray.add("k");
			realWeightedArray.add("p");
			n = k;	
		}
		
		for (int k = n; k < (intRocks + intPapers); k++) {
			realWeightedArray.add("l");
			realWeightedArray.add("s");
			n = k;	
		}
		
		for (int k = n; k < (intRocks + intPapers + intScissors); k++) {
			realWeightedArray.add("k");
			realWeightedArray.add("r");
			n = k;
		}
		
		for (int k = n; k < (intRocks + intPapers + intScissors + intLizards); k++) {	
			realWeightedArray.add("r");
			realWeightedArray.add("s");
			n = k;
		}
		
		for (int k = n; k < (intRocks + intPapers + intScissors + intLizards + intSpocks); k++) {
			realWeightedArray.add("p");
			realWeightedArray.add("l");
			n=k;
		}
		
		Random rand = new Random();
		int computerRandom = rand.nextInt(realWeightedArray.size());
		
		String computerChoice = "E";
		
		computerChoice = realWeightedArray.get(computerRandom);
							
		return computerChoice;
		
	}
	
	/**
	 * This method randomizes the computer's choice with the use of Random class in java.util library.
	 * Test cases showed an average of 40% win, 40% loss, and 20% tie from the user's perspective.
	 * This suggests that user and computer picks their choices almost randomly.
	 * @return computer's choice of RPSLK.
	 */
	public String RandomStrategy() {
		
		Random rand = new Random();
		int computerRandom = rand.nextInt(5);
		
		String computerChoice = "E";
		
		switch(computerRandom) {
		  case 0:
			  computerChoice = "r";
			  break;
		  case 1:
			  computerChoice = "p";
			  break;
		  case 2:
			  computerChoice = "s";
			  break;
		  case 3:
			  computerChoice = "l";
			  break;
		  case 4:
			  computerChoice = "k";
			  break;
		  default:
		    System.out.println("An error has occured. Restart.");
		}

		return computerChoice;	
	}
	
/**
 * This method counters the strategy of the simulated human user.
 * The computer has an unfair advantage against the user, since it knows about the user's two strategies (Rotator or Reflector) and how they are executed.
 * Considering the last three throws of the user, the algorithm deduces which pattern is currently used.
 * Until the pattern in the last three throws is broken, the algorithm picks counter-throws of the Rotator Strategy.
 * When the pattern is broken, and is not established for three rounds in a row, the algorithm picks counter-throws of the Reflector Strategy.
 * Therefore, the test cases show that over a long course of game, computer definitely wins with a significant win-loss gap.
 * The computer's win rate is well-over 98 percent because of its unfair advantage.
 * It is important to note that the test cases showed: as the number of rounds the user sticks with the same pattern approaches to minimum, the computer's win rate significantly drops to 70 percent.
 * @param record the history of the game
 * @return computer's choice
 */
public String RevengeStrategy(Recorder record) {
		
		boolean patternIsRotator = false;
		
		String computerChoice = "E";
		
		int size = record.userThrowHistory.size();
		
		int n = 3;

		String current = record.userThrowHistory.get(size - 1);
		String previous = record.userThrowHistory.get(size - 2);
		
		int currentInt = 0;
	
		String[] choices = new String[5];
		
		choices[0] = "r";
		choices[1] = "p";
		choices[2] = "s";
		choices[3] = "l";
		choices[4] = "k";
		
		boolean stop = false;
		
		while (stop == false) {
			switch (current) {
			case "r":
				currentInt = 5;
				break;
			case "p":
				currentInt = 1;
				break;
			case "s":
				currentInt = 2;
				break;
			case "l":
				currentInt = 3;
				break;
			case "k":
				currentInt = 4;
				break;
			}
			
			if (previous.equals(choices[currentInt - 1])) {
				current = previous;
				previous = record.userThrowHistory.get(size - n);
				n++;
			}	
			else {
				patternIsRotator = false;
				stop = true;
				break;
			}
			
			if (n == 6) {
				patternIsRotator = true;
				stop = true;
			}			
		}
		
		if (patternIsRotator == false) {		
			switch(record.recentComputerThrow) {
			  case "r":
				  computerChoice = "p";
				  break;
			  case "p":
				  computerChoice = "s";
				  break;
			  case "s":
				  computerChoice = "r";
				  break;
			  case "l":
				  computerChoice = "r";
				  break;
			  case "k":
				  computerChoice = "l";
				  break;
			  default:
			    System.out.println("An error has occured. Restart.");
			}	
		}
		
		if (patternIsRotator == true) {
			current = record.userThrowHistory.get(size - 1);
			switch (current) {
			case "r":
				computerChoice = "s";
				break;
			case "p":
				computerChoice = "k";
				break;
			case "s":
				computerChoice = "r";
				break;
			case "l":
				computerChoice = "l";
				break;
			case "k":
				computerChoice = "p";
				break;
			}
		}
			return computerChoice;
	}
}
