import java.util.Scanner;
import java.lang.Math;

/**
 * Determines the user's choice.<br>
 * Compares user's and computer's throws to decide on the result.<br>
 * Gives overall results of the 100 consecutively played games.
 * @author Bora Elci be2246
 */

public class Select {
	
	private int win;
	private int loss;
	private int tie;
	public boolean choiceIsValid;
	private String userChoice;
	
	public Select(){
		win = 0;
		loss = 0;
		tie = 0;	
	}
	
	/**
	 * 
	 * This method returns user's choice only if it is valid.<br>
	 * Validation of the choice is tested within a while loop.<br>
	 * If user's input equals any of the letters r, p, or s, choiceIsValid parameter is flagged true.<br>
	 * Else, the program continues to ask for a valid input.
	 * 
	 * @return user's choice if valid.<br>
	 */
	
	public String getChoice(Sim simUser, Recorder record) {
		
	userChoice = simUser.getSim(record);
	
	return userChoice;	
	}
	
	/**
	 * This method asks and waits for real human user input in the console.
	 * It returns user's choice only if it is valid.<br>
	 * Validation of the choice is tested within a while loop.<br>
	 * If user's input equals any of the letters r, p, or s, choiceIsValid parameter is flagged true.<br>
	 * Else, the program continues to ask for a valid input.
	 * 
	 * @return user's choice if valid.<br>
	 */
	public String realHumanChoice() {
		
		choiceIsValid = false;
		
		while (choiceIsValid == false) {
			
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nWhich one? 'r', 'p', 's', 'l', 'k' ");
		userChoice = scanner.nextLine();
		
		if (userChoice.equals("r") || userChoice.equals("p") ||
				userChoice.equals("s") || userChoice.equals("l") || userChoice.equals("k")) {		
			choiceIsValid = true;		
		}
		else {	
			System.out.println("\nInvalid user input. Try again!");
			choiceIsValid = false;			
		}
		}
		return userChoice;	
	}
	
	/**
	 * This method takes in to compare computer's choice and user's choice. <br>
	 * Based on the game of the rules, it decides on a win, loss, or tie situation.<br>
	 * The corresponding variable is incremented by one to keep track of the results.
	 * 
	 * @param computerChoice computer's choice of RPS.
	 * @param userChoice user's choice of RPS.
	 */
	
	public void compareThrows(String computerChoice, String userChoice) {
		
	switch(userChoice) {
	case "r":
		switch(computerChoice) {
		case "r":
			System.out.println("It is a tie! Both you and computer picked ROCK");
			tie++;
			break;
		case "p":
			System.out.println("You picked ROCK, computer picked PAPER");
			System.out.println("You Lose! Computer Wins! ");
			loss++;
			break;
		case "s":
			System.out.println("You picked ROCK, computer picked SCISSORS");
			System.out.println("You Win! Computer Loses!");
			win++;
			break;
		case "l":
			System.out.println("You picked ROCK, computer picked LIZARD");
			System.out.println("You Win! Computer Loses!");
			win++;
			break;
		case "k":
			System.out.println("You picked ROCK, computer picked SPOCK");
			System.out.println("You Lose! Computer Wins! ");
			loss++;
			break;
		}
	break;
	
	case "p":
		switch(computerChoice) {
		case "r":
			System.out.println("You picked PAPER, computer picked ROCK");
			System.out.println("You Win! Computer Loses!");
			win++;
			break;
		case "p":
			System.out.println("It is a tie! Both you and computer picked PAPER");
			tie++;
			break;
		case "s":
			System.out.println("You picked PAPER, computer picked SCISSORS");
			System.out.println("You Lose! Computer Wins! ");
			loss++;
			break;
		case "l":
			System.out.println("You picked PAPER, computer picked LIZARD");
			System.out.println("You Lose! Computer Wins! ");
			loss++;
			break;
		case "k":
			System.out.println("You picked PAPER, computer picked SPOCK");
			System.out.println("You Win! Computer Loses!");
			win++;
			break;
		}
	break;
	
	case "s":
		switch(computerChoice) {
		case "r":
			System.out.println("You picked SCISSORS, computer picked ROCK");
			System.out.println("You Lose! Computer Wins! ");
			loss++;
			break;
		case "p":
			System.out.println("You picked SCISSORS, computer picked PAPER");
			System.out.println("You Win! Computer Loses!");	
			win++;
			break;
		case "s":
			System.out.println("It is a tie! Both you and computer picked SCISSORS");
			tie++;
			break;
		case "l":
			System.out.println("You picked SCISSORS, computer picked LIZARD");
			System.out.println("You Win! Computer Loses!");
			win++;
			break;
		case "k":
			System.out.println("You picked SCISSORS, computer picked SPOCK");
			System.out.println("You Lose! Computer Wins! ");
			loss++;
			break;
		}
	break;
	
	case "l":
		switch(computerChoice) {
		case "r":
			System.out.println("You picked LIZARD, computer picked ROCK");
			System.out.println("You Lose! Computer Wins! ");
			loss++;
			break;
		case "p":
			System.out.println("You picked LIZARD, computer picked PAPER");
			System.out.println("You Win! Computer Loses!");	
			win++;
			break;
		case "s":
			System.out.println("You picked LIZARD, computer picked SCISSORS");
			System.out.println("You Lose! Computer Wins! ");
			loss++;
			break;
		case "l":
			System.out.println("It is a tie! Both you and computer picked LIZARD");
			tie++;
			break;
		case "k":
			System.out.println("You picked LIZARD, computer picked SPOCK");
			System.out.println("You Win! Computer Loses!");	
			win++;
			break;
		}
	break;
	
	case "k":
		switch(computerChoice) {
		case "r":
			System.out.println("You picked SPOCK, computer picked ROCK");
			System.out.println("You Win! Computer Loses! ");
			win++;
			break;
		case "p":
			System.out.println("You picked SPOCK, computer picked PAPER");
			System.out.println("You Lose! Computer Wins!");	
			loss++;
			break;
		case "s":
			System.out.println("You picked SPOCK, computer picked SCISSORS");
			System.out.println("You Win! Computer Loses!");
			win++;
			break;
		case "l":
			System.out.println("You picked SPOCK, computer picked LIZARD");
			System.out.println("You Lose! Computer Wins!");
			loss++;
			break;
		case "k":
			System.out.println("It is a tie! Both you and computer picked SPOCK");
			tie++;
			break;
		}
	break;
	
	default:
	  System.out.println("An error has occurred. Restart.");
	}
	System.out.println(""); //for better console view
	}
	
	/**
	 * Prints the overall result of 100 consecutively played rounds.<br>
	 * Both the count and percentage of the wins, losses, and ties are printed on the console.
	 * @param rounds number of consecutively played rounds (100)
	 * @param perWin percentage of wins in total
	 * @param perLoss percentage of losses in total
	 * @param perTie percentage of ties in total
	 */
	public void getResults(double ROUNDS) {
		
		double perWin = (this.win)/ROUNDS*100;
		double perLoss = (this.loss)/ROUNDS*100;
		double perTie = (this.tie)/ROUNDS*100;
		
		System.out.println("\nWins: " + this.win + ", Losses: " + this.loss + ", Ties: " + this.tie);
		System.out.println("Wins: " + Math.round(perWin) +"%"
				+ ", Losses: " + Math.round(perLoss) +"%" + ", Ties: " + Math.round(perTie) +"%");		
	}
}
