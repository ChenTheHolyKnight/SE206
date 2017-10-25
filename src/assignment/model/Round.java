package assignment.model;

import assignment.model.Level.Levels;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Round {
	
	private int _score=0;
	private int _attempts=0;
	private Level _level;
	private Time _time;

	public Time getTime() {
		return _time;
	}

	public void setTime(Time time) {
		_time = time;
	}
	public StringProperty getTimeProperty() {
		String time=_time.calculate();
		return new SimpleStringProperty(time);
	}
	public StringProperty getStartTimeProperty(){
		String time=_time.getStart();
		return new SimpleStringProperty(time);
	}




	public int getScore() {
		return _score; 
	}

	public void setScore(int score) {
		_score=score;
	}

	public StringProperty getScoreProperty() {
		return new SimpleStringProperty(Integer.toString(_score)+" out of 10");
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
