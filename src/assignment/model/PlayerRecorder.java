package assignment.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PlayerRecorder {
	private static ObservableList<Player> _playerRecorder= FXCollections.observableArrayList();
	private static PlayerRecorder _playerRecorderObj;
	
	private PlayerRecorder() {
		
	}
	
	
	
	public static ObservableList<Player> getInstance(){
		if(_playerRecorderObj==null){
			_playerRecorderObj=new PlayerRecorder();
		}
        return _playerRecorder;
    }
	public static void setList(ObservableList<Player> list){
		_playerRecorder=list;
	}

	public static PlayerRecorder getPlayerRecorder(){
		return _playerRecorderObj;
	}

	public ObservableList<Player> getPlayerList(){
		return _playerRecorder;
	}


	
}
