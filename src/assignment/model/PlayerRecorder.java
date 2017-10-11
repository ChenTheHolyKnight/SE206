package assignment.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PlayerRecorder {
	private static ObservableList<Player> _playerRecorder= FXCollections.observableArrayList();
	
	private PlayerRecorder() {
		
	}
	
	
	
	public static ObservableList<Player> getInstance(){
        return _playerRecorder;
    }
	
	
}
