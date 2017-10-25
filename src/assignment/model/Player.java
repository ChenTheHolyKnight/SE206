package assignment.model;

import assignment.model.Level.Levels;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Player {

	private String _name;

	private ObservableList<Round> _easyRoundRecords=FXCollections.observableArrayList();
	private ObservableList<Round> _hardRoundRecords=FXCollections.observableArrayList();
	private ObservableList<Round> _customizeRoundRecords=FXCollections.observableArrayList();

	//getters and setters for the player 
	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name=name;
	}
	public StringProperty getNameProperty() {
		return new SimpleStringProperty(_name);
	}

	public void addRound(Round round) {
		if(round.getLevel().getLevels()==Levels.EASY) {
			_easyRoundRecords.add(round);
		}
		if(round.getLevel().getLevels()==Levels.HARD) {
			_hardRoundRecords.add(round);
		}
		if(round.getLevel().getLevels()==Levels.CUSTOMIZE) {
			_customizeRoundRecords.add(round);
		}
	}

	public ObservableList<Round> getRounds(Levels levels){
		if(levels==Levels.EASY) {
			return _easyRoundRecords;
		}
		if(levels==Levels.HARD) {
			return _hardRoundRecords;
		}
		if(levels==Levels.CUSTOMIZE) {
			return _customizeRoundRecords;
		}
		return null;
	}

}
