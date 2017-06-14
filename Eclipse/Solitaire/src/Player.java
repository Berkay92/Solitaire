
public class Player {

	private int score;
	private String name;
	
	public Player(String name, String score) {
		
		this.score = Integer.parseInt(score);
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
