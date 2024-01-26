import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class ArcheryGameTest{

	private int[][] testScoreBoard = 
			new int[][]{{-1,-1,-1}, {-1,-1,-1}, {-1,-1,-1}, {-1,-1,-1}};


	@Test
	public void testArcheryGameExists(){

		ArcheryGame archeryGame = new ArcheryGame(); 

		assertNotNull(archeryGame);


	}


	@Test
	public void testThatThereAreFourPlayersInGame(){

		ArcheryGame archeryGame = new ArcheryGame(); 

		Player[] players = archeryGame.getPlayers();
		int numberOfPlayers = players.length;

		assertEquals(4, numberOfPlayers);

	}


	@Test
	public void testThatGameHasScoreBoard(){

		ArcheryGame archeryGame = new ArcheryGame(); 

		int[][] scoreBoard = archeryGame.getScoreBoard();

		assertArrayEquals(testScoreBoard, scoreBoard);

	}




	@Test
	public void testThatBoardIsFilledWithDummyValuesByDefault(){
		ArcheryGame archeryGame = new ArcheryGame();

		int[][] scoreBoard = archeryGame.getScoreBoard();

		assertArrayEquals(testScoreBoard, scoreBoard);
	}


	@Test
	public void testThatGameScoreBoardCanBeMarked(){
		ArcheryGame archeryGame = new ArcheryGame();
		Player player = archeryGame.getPlayers()[1];
		archeryGame.markScoreBoard(player.getId());
		int score = archeryGame.getScoreBoard()[1][0];
		archeryGame.markScoreBoard(player.getId());
		assertNotEquals(-1, score);
		
	}



	@Test
	public void testThatPlayer1CanPlayGame(){
		ArcheryGame archeryGame = new ArcheryGame();
		Player[] players = archeryGame.getPlayers();
		
		Player playerOne = players[0];	

		playerOne.play(archeryGame);

		int[][] scoreBoard = archeryGame.getScoreBoard();
		int playerOneFirstScore = scoreBoard[0][0];
		assertNotEquals(-1, playerOneFirstScore);

		playerOne.play(archeryGame);
		int playerOneSecondScore = scoreBoard[0][1];
		assertNotEquals(-1, playerOneSecondScore);


		playerOne.play(archeryGame);
		int playerOneThirdScore = scoreBoard[0][2];
		assertNotEquals(-1, playerOneThirdScore);		
	}



	@Test
	public void testThatGameCanDetermineWinner(){
		ArcheryGame archeryGame = new ArcheryGame();

		for(Player player:archeryGame.getPlayers()){
			for(int counter =0; counter< 3; counter++) 
				player.play(archeryGame);

		}
		System.out.println(Arrays.deepToString(archeryGame.getScoreBoard()));
		assertNotNull(archeryGame.getWinner());

	}	



	public void showBoardTest(){

		ArcheryGame game = new ArcheryGame();

		int[] board = game.getScoreBoard()[0];
		String horizontal = "=".repeat(17);
		String vertical = "|";
		String blank = " ";
		String row = "%s\n%s%s%d%s%s%s%d%s%s%s%d%s%s";
		String firstRow = String.format(row, horizontal, vertical, blank, 9, blank, vertical, blank, 9, blank, vertical, blank, 9, blank, vertical);
		String secondRow = String.format(row, horizontal, vertical, blank, 9, blank, vertical, blank, 9, blank, vertical, blank, 9, blank, vertical);
		String thirdRow = String.format(row, horizontal, vertical, blank, 9, blank, vertical, blank, 9, blank, vertical, blank, 9, blank, vertical);
		System.out.println(firstRow);
		System.out.println(secondRow);
		System.out.println(thirdRow);
		System.out.println(horizontal);

	}





}