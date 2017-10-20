package assignment.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Score {
	private int _score;
	public Score(int score) {
		_score=score;
	}
	
	
	public StringProperty getScoreProperty() {
		String score=Integer.toString(_score);
		return new SimpleStringProperty(score);
	}
}
