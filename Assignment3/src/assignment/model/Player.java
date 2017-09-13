package assignment.model;

public class Player {
	private String _name;
	private int _score;
	private int _attempts;
	private Level _level;
	
	
	public String getName() {
		return _name;
	}
	
	public void setName(String name) {
		_name=name;
	}
	
	public int getScore() {
		return _score; 
	}
	
	public void setScore(int score) {
		_score=score;
	}
	public int getAttempts() {
		return _attempts;
	}
	public void setAttempts(int attempts) {
		_attempts=attempts;
	}
	
	public Level getLevel() {
		return _level;
	}
	
	public void setLevel(Level level) {
		_level=level;
	}

}
