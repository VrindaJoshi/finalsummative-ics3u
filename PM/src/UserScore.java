// object that stores player history

public class UserScore {
	
	// fields
	private String name;
	private int highScore;
	
	public UserScore(String name, int highScore) {
		super();
		this.name = name;
		this.highScore = highScore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHighScore() {
		return highScore;
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}

	@Override
	public String toString() {
		return "UserScore [name=" + name + ", highScore=" + highScore + ", getName()=" + getName() + ", getHighScore()="
				+ getHighScore() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	

}
