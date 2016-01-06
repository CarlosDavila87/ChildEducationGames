
public enum Difficulty {
	EASY("Easy",1,10), 
	MEDIUM("Medium",1,50), 
	HARD("Hard",1,100);
	
	private String diff;
	private int lbound, ubound;
	
	public int getLbound() {
		return lbound;
	}

	public void setLbound(int lbound) {
		this.lbound = lbound;
	}

	public int getUbound() {
		return ubound;
	}

	public void setUbound(int ubound) {
		this.ubound = ubound;
	}

	Difficulty(String diff, int lowerBound, int upperBound){
		this.diff = diff;
		this.lbound = lowerBound;
		this.ubound = upperBound;
	}
	
	public String getDifficulty(){
		return diff;
	}

	
	
}
