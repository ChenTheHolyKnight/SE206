package assignment.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LeaseRecorder {
	private static ObservableList<Player> _playerRecorder= FXCollections.observableArrayList();
	
	private LeaseRecorder() {
		
	}
	
	public void addPlayer(Player player) {
		_playerRecorder.add(player);
	}
	
	public void deletePlayer(Player player) {
		_playerRecorder.remove(player);
	}
	
	
	
	
	public static ObservableList<Player> getInstance(){
        return _playerRecorder;
    }
}
