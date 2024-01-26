import java.security.SecureRandom;
import java.util.Arrays;

public class ArcheryGame{

	private Player[] players;
	private int[][] scoreBoard;
	private Player winner;
	private int[] totalScores;

	public ArcheryGame(){
		Player playerOne= new Player(1);
		Player playerTwo = new Player(2);
		Player playerThree = new Player(3);
		Player playerFour = new Player(4);

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

		totalScores = new int[4];


	}

	public Player[] getPlayers(){

		return players;

	}

	public int[][] getScoreBoard(){

		return scoreBoard;

	}


	public void markScoreBoard(int playerId){
		int score = generateScore();
		int playerRowOnScoreBoard = playerId-1;

		int[] playerRow = scoreBoard[playerRowOnScoreBoard];
		
		for(int index = 0; index < playerRow.length; index++){
			if (playerRow[index]==-1){
				playerRow[index] = score;
				break;

			}
		}

		if (scoreBoard[3][2]!=-1) {
			calculateScoreTotal();
			checkForWinner();		
		}

	}


	private void calculateScoreTotal(){
		for(int count = 0; count < scoreBoard.length; count++){
			for(int counter = 0; counter < scoreBoard[count].length; counter++){
				totalScores[count] += totalScores[count] + scoreBoard[count][counter];
			}
		}

	}

	private void checkForWinner(){
		int maxScore = 0;
		for(int index = 0; index < totalScores.length; index++){
			if (totalScores[index] > maxScore) {
				maxScore = totalScores[index];
				winner = players[index];
			}
			

		}


	}

	public Player getWinner(){
		return winner;

	}



	private int generateScore(){
		SecureRandom secureRandom = new SecureRandom();
		int score = secureRandom.nextInt(11);
		return score;
	}




}