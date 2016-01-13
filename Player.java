
public class Player {
	private String name;
	private int score;
	private Difficulty difficulty;
	
	public Player(){
		this.name = "";
		this.score = 0;
		this.difficulty = Difficulty.EASY;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
	
	public void incrimentScore(){
		this.score+=1;
	}

}
