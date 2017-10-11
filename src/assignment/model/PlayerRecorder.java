package assignment.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PlayerRecorder {
	private static ObservableList<Player> _playerRecorder= FXCollections.observableArrayList();
	
	private PlayerRecorder() {
		
	}
	
	/*
	public void addPlayer(Player player) {
		for(Player player1:_playerRecorder) {
			System.out.println(player1.getName());
			if(player1.getName().equals(player.getName())) {
				_playerRecorder.remove(player1);
			}
		}
		_playerRecorder.add(player);
	}
	
	public void deletePlayer(Player player) {
		_playerRecorder.remove(player);
	}
	*/
	
	public static ObservableList<Player> getInstance(){
        return _playerRecorder;
    }
	
	
}
