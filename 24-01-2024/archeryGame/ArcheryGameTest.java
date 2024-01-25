import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class ArcheryGameTest{

	private int[][] testScoreBoard = new int[][]{{-1,-1,-1}, {-1,-1,-1}, {-1,-1,-1}, {-1,-1,-1}};


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
	public void testThatGameCanGenerateScores(){
		ArcheryGame archeryGame = new ArcheryGame(); 
		int score = archeryGame.generateScore();
		
		boolean isScoreBetweenZeroAndTen = score>=0 && score<=10;
		assertTrue(isScoreBetweenZeroAndTen);
	
	}

	@Test
	public void testThatBoardIsFilledWithDummyValuesByDefault(){
		ArcheryGame archeryGame = new ArcheryGame();

		int[][] scoreBoard = archeryGame.getScoreBoard();

		assertArrayEquals(testScoreBoard, scoreBoard);
	}

	@Test
	public void 



	@Test
	public void testThatPlayer1CanPlayGame(){
		ArcheryGame archeryGame = new ArcheryGame();
		Player[] players = archeryGame.getPlayers();
	
		Player playerOne = players[0];	

		playerOne.play();

		int[][] scoreBoard = archeryGame.getScoreBoard();
		int playerOneFirstScore = scoreBoard[0][0];
		assertNotEquals(-1, playerOneFirstScore);

		playerOne.play();
		int playerOneSecondScore = scoreBoard[0][1];
		assertNotEquals(-1, playerOneSecondScore);


		playerOne.play();
		int playerOneThirdScore = scoreBoard[0][2];
		assertNotEquals(-1, playerOneThirdScore);		
	}





}