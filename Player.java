
public class Player {
	private String name;
	private int score;
	private Difficulty difficulty;
	
	public Player(String name, Difficulty difficulty){
		this.name = name;
		this.score = 0;
		this.difficulty = difficulty;
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

}
