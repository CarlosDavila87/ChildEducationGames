
public enum Difficulty {
	EASY("Easy", 10), 
	MEDIUM("Medium", 50), 
	HARD("Hard", 100);
	
	private String diff;
	private int bound;

	public int getBound() {
		return bound;
	}

	public void setBound(int ubound) {
		this.bound = ubound;
	}

	Difficulty(String diff, int upperBound){
		this.diff = diff;
		this.bound = upperBound;
	}
	
	public String getDifficulty(){
		return diff;
	}
}
