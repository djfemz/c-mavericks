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

	public String finalScoreBoard(){
		String horizontal = "=".repeat(41);
		String horizontal2 = "-".repeat(41);
		String vertical = "|";
		String blank = " ";
		String column = "%s\n%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s";
		String row = "%s\n%s%s%4d%4s%s%s%4d%4s%s%s%4d%4s%s%s%4d%4s%s";

		String boardRow = String.format(column, horizontal, vertical, blank, "Player1", blank, vertical, blank,
				"Player2", blank, vertical, blank, "Player3", blank, vertical, blank, "Player4", blank, vertical);

		String firstRow = String.format(row, horizontal, vertical, blank, scoreBoard[0][0], blank, vertical, blank,
				scoreBoard[1][0], blank, vertical, blank, scoreBoard[2][0], blank, vertical, blank, scoreBoard[3][0],
				blank, vertical);
		String secondRow = String.format(row, horizontal2, vertical, blank, scoreBoard[0][1], blank, vertical, blank,
				scoreBoard[1][1], blank, vertical, blank, scoreBoard[2][1], blank, vertical, blank, scoreBoard[3][1],
				blank, vertical);
		String thirdRow = String.format(row, horizontal2, vertical, blank, scoreBoard[0][2], blank, vertical, blank,
				scoreBoard[1][2], blank, vertical, blank, scoreBoard[2][2], blank, vertical, blank, scoreBoard[3][2],
				blank, vertical);
		String total = String.format(row, horizontal, vertical, blank, totalOfScores[0], blank, vertical, blank,
				totalOfScores[1], blank, vertical, blank, totalOfScores[2], blank, vertical, blank, totalOfScores[3],
				blank, vertical);

		return String.format("%s%n%s%n%s%n%s%n%s%n%s%n", boardRow, firstRow, secondRow, thirdRow, totalRow, horizontal);
	}




}
