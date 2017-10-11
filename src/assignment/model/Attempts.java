package assignment.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Attempts {
	private int _attempt;
	public Attempts(int score) {
		_attempt=score;
	}
	
	
	public StringProperty getAttemptProperty() {
		String attempt=Integer.toString(_attempt);
		return new SimpleStringProperty(attempt);
	}
}
