/**
 * This class simulates a human user's choice of RPSLK.
 * Reflector and Rotator strategies are used for this purpose.
 * @param N number of rounds for the same strategy to be used.
 * @param method the currently active strategy: 0 for Rotator, 1 for Reflector.
 * @param rotate number of possible choices (RPSLK)
 */
public class Sim {
	
	public String simChoice;
	public int rotate;
	public int N;
	public int thisRound;
	public int method;
	
	public Sim(){
	N = 1;
	thisRound = 0;	
	method = 0;
	rotate = 5;
	}
	
	/**
	 * This method determines the current computer choice based on which strategy is used for N number of consecutive rounds.
	 * N is specified by the developer. Test cases showed that an N closer to the total number of rounds played decreases the simulated user's chance of winning.
	 * An N too small significantly increases the simulated user's chance of winning. Therefore, an N in between one tenth and one fifth of the number of total rounds is found to be suitable for proper gameplay.
	 * For N number of times Rotator Strategy is played, then for N times the Reflector Strategy. This variation continues until the game ends.
	 * @param record history of the game stored in ArrayLists
	 * @return simulated user choice
	 */
	public String getSim(Recorder record) {
	if (method == 0) {	
		if (thisRound < N) {	
		RotatorStrategy();	
		}
		else {
		method = 1;
		thisRound = 0;
		ReflectorStrategy(record);	
		}
	}	
	else if (method == 1) {
		if(thisRound < N) {
			ReflectorStrategy(record);
		}	
		else {
			method = 0;
			thisRound = 0;
			RotatorStrategy();
		}
	}		
	thisRound++;
	return simChoice;
	}
	
	/**
	 * This method determines the computer's choice by rotating.
	 * Based on the current round of the game, the computer starts with R and rotates the possible choices in a pre-determined order of RPSLK.
	 * @author Bora Elci
	 */
	public void RotatorStrategy() {
		
		int current = rotate % 5;
		
		switch (current) {
		case 0:
			simChoice = "r";
			break;
		case 1:
			simChoice = "p";
			break;
		case 2:
			simChoice = "s";
			break;
		case 3:
			simChoice = "l";
			break;
		case 4:
			simChoice = "k";
			break;
		default:
			  System.out.println("An error has occurred. Restart.");
		}
		this.rotate++;	
	}
	
	/**
	 * This method determines the computer's choice by reflecting.
	 * Recent computer throw is requested from the record object of Recorder class.
	 * Simulated user's choice is set to the previous computer throw.
	 * @param record history of the game
	 */
	public void ReflectorStrategy(Recorder record) {	
		simChoice = record.recentComputerThrow;
	}
}
