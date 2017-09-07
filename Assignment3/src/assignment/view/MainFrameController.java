package assignment.view;

import assignment.MainApp;
import javafx.fxml.FXML;

public class MainFrameController {
	private MainApp _mainApp;
	
	@FXML
	public void handleStartButton() {
		//_mainApp.showLevelLayout();
		_mainApp.showUserNameFrame();
		
	}
	
	@FXML
	public void handleExitButton() {
		_mainApp.showExitDialog();
	}
	
	@FXML
	public void handleTutorialButton() {
		_mainApp.showTutorialFrame();
	}
	public void setMainApp(MainApp mainApp) {
		_mainApp=mainApp;
	}
	
	
}
