package assignment.view;

import assignment.MainApp;
import javafx.fxml.FXML;

public class LevelLayoutController {
	private MainApp _mainApp;
	@FXML
	public void handleBackButton() {
		_mainApp.showUserNameFrame();
		
	}
	@FXML
	public void handleEasyButton() {
		_mainApp.showGameFrame1();
	}
	
	@FXML
	public void handleHardButton() {
		_mainApp.showGameFrame1();
	}
	
	public void setMainApp(MainApp mainApp) {
		_mainApp=mainApp;
	}
	
}
