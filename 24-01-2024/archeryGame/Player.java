public class Player{

	public void play(ArcheryGame archeryGame, int player, int chance){
		int score = archeryGame.generateScore();
		archeryGame.setScoreBoard(player, chance, score);		

	}



}
