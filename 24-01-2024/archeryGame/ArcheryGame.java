import java.security.SecureRandom;
import java.util.Arrays;

public class ArcheryGame{

	private Player[] players;
	private int[][] scoreBoard;

	public ArcheryGame(){
		Player playerOne = new Player();
		Player playerTwo = new Player();
		Player playerThree = new Player();
		Player playerFour = new Player();

		players = new Player[4];
		players[0] = playerOne;
		players[1] = playerTwo;
		players[2] = playerThree;
		players[3] = playerFour; 

		scoreBoard = new int[4][3];

		for(int counter=0;counter<scoreBoard.length;counter++){
			for(int index=0;index<scoreBoard[counter].length;index++){
				scoreBoard[counter][index] = -1;
			}
		}


	}

	public Player[] getPlayers(){

		return players;

	}

	public int[][] getScoreBoard(){

		return scoreBoard;

	}

	public int generateScore(){
		SecureRandom secureRandom = new SecureRandom();
		int score = secureRandom.nextInt(11);
		return score;
	}




}