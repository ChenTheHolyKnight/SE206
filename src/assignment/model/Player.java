package assignment.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Player {
	private String _name;
	private int _score=0;
	private int _attempts=0;
	private Level _level;
	
	
	private ObservableList<Score> _scoreRecord=FXCollections.observableArrayList();
	
	
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
		addScore(score);
	}
	
	public StringProperty getScoreProperty() {
		return new SimpleStringProperty(Integer.toString(_score)+" out of 10");
	}

	public String setToString(int integer) {
		//basically changing the integer values to that of a string
		String s = ""+ integer;
		return s;
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
	
	
	
	private void addScore(int score) {
		Score s=new Score(score);
		_scoreRecord.add(s);
	}
	
	public ObservableList<Score> getScoreRecord() {
		return _scoreRecord;
	}

}
