package assignment.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Player {
	private String _name;
	private int _score=0;
	private int _attempts=0;
	private Level _level;
	
	
	public String getName() {
		return _name;
	}
	
	public void setName(String name) {
		_name=name;
	}
	public StringProperty getNameProperty() {
		return new SimpleStringProperty(_name);
	}
	
	
	public int getScore() {
		return _score; 
	}
	
	public void setScore(int score) {
		_score=score;
	}
	
	public StringProperty getScoreProperty() {
		return new SimpleStringProperty(Integer.toString(_score));
	}
	
	
	public int getAttempts() {
		return _attempts;
	}
	public void setAttempts(int attempts) {
		_attempts=attempts;
	}
	public StringProperty getAttemptProperty() {
		return new SimpleStringProperty(Integer.toString(_attempts));
	}
	
	
	public Level getLevel() {
		return _level;
	}
	
	public void setLevel(Level level) {
		_level=level;
	}
	
	public void resetStats() {
		_score=0;
		_attempts=0;
	}

}
