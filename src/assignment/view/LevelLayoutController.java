package assignment.view;

import assignment.MainApp;
import assignment.model.EasyLevel;
import assignment.model.HardLevel;
import assignment.model.Level;
import assignment.model.Player;
import javafx.fxml.FXML;

public class LevelLayoutController {
	private MainApp _mainApp;
	private Level _level;
	private Player _player;
	@FXML
	public void handleBackButton() {
		_mainApp.showUserNameFrame();
		
	}
	@FXML
	public void handleEasyButton() {
		_level=new EasyLevel();
		//int num=_level.generateNumber();
		//_mainApp.showGameFrame1(num,_level);
		_mainApp.showGameFrame(_level,_player);
	}
	
	@FXML
	public void handleHardButton() {
		_level=new HardLevel();
		//_mainApp.showGameFrame1(num,_level);
		_mainApp.showGameFrame(_level,_player);
	}
	
	public Level getLevel() {
		return _level;
	}
	
	public void setMainApp(MainApp mainApp) {
		_mainApp=mainApp;
	}
	
	public void setPlayer(Player player) {
		_player=player;
	}
	
}
