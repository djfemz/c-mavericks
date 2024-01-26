public class Player{

	private int id;

	public Player(int id){

		this.id = id;
	}


	public void play(ArcheryGame archeryGame){
		archeryGame.markScoreBoard(this.id);
	}


	public int getId(){


		return id;
	}


}