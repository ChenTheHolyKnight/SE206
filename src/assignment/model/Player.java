package assignment.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This is a model class for player
 */
public class Player {
	private String _name;
	private int _score=0;
	private int _attempts=0;
	private Level _level;
	
	
	
	//Getters Setters for name
	public String getName() {
		return _name;
	}	
	public void setName(String name) {
		_name=name;
	}
	public StringProperty getNameProperty() {
		return new SimpleStringProperty(_name);
	}
	
	//Getters Setters for score
	public int getScore() {
		return _score; 
	}	
	public void setScore(int score) {
		_score=score;
	}	
	public StringProperty getScoreProperty() {
		return new SimpleStringProperty(Integer.toString(_score)+" out of 10");
	}
	
	//Getters Setters for attempts
	public int getAttempts() {
		return _attempts;
	}
	public void setAttempts(int attempts) {
		_attempts=attempts;
	}
	public StringProperty getAttemptProperty() {
		return new SimpleStringProperty(Integer.toString(_attempts));
	}
	
	//Getters Setters for level
	public Level getLevel() {
		return _level;
	}	
	public void setLevel(Level level) {
		_level=level;
	}

	
	/**
	 * This is a method to reset the data of a player
	 */
	public void resetStats() {
		_score=0;
		_attempts=0;
	}

}
