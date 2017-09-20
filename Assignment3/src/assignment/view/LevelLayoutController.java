package assignment.view;

import assignment.MainApp;
import assignment.model.EasyLevel;
import assignment.model.HardLevel;
import assignment.model.Level;
import javafx.fxml.FXML;

public class LevelLayoutController {
	private MainApp _mainApp;
	private Level _level;
	@FXML
	public void handleBackButton() {
		_mainApp.showUserNameFrame();
		
	}
	@FXML
	public void handleEasyButton() {
		_level=new EasyLevel();
		int num=_level.generateNumber();
		//_mainApp.showGameFrame1(num,_level);
		_mainApp.showGameFrame(_level);
	}
	
	@FXML
	public void handleHardButton() {
		_level=new HardLevel();
		int num=_level.generateNumber();
		_mainApp.showGameFrame1(num,_level);
	}
	
	public Level getLevel() {
		return _level;
	}
	
	public void setMainApp(MainApp mainApp) {
		_mainApp=mainApp;
	}
	
}
