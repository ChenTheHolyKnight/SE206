package assignment.model;

import assignment.model.Level.Levels;
import javafx.beans.binding.IntegerExpression;
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


	private ObservableList<Score> _easyScoreRecord=FXCollections.observableArrayList();
	private ObservableList<Score> _hardScoreRecord=FXCollections.observableArrayList();
	private ObservableList<Score> _customizeScoreRecord=FXCollections.observableArrayList();


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
		if(_level.getLevels().equals(Levels.EASY)) {
			_easyScoreRecord.add(s);
		}
		if(_level.getLevels().equals(Levels.HARD)) {
			_hardScoreRecord.add(s);
		}
		if(_level.getLevels().equals(Levels.CUSTOMIZE)) {
			_customizeScoreRecord.add(s);
		}
	}

	public ObservableList<Score> getScoreRecord(Levels level) {
		
		
		if(level==Levels.EASY) {
			return _easyScoreRecord;
		}
		if(level==Levels.HARD) {
			return _hardScoreRecord;
		}
		if(level==Levels.CUSTOMIZE) {
			return _customizeScoreRecord;
		}
		return null;
	}

}
