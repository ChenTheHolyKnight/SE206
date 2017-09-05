package assignment.view;

import assignment.MainApp;
import javafx.fxml.FXML;

public class MainFrameController {
	private MainApp _mainApp;
	
	@FXML
	public void handleStartButton() {
		_mainApp.showLevelLayout();
		
	}
	
	@FXML
	public void handleExitButton() {
		_mainApp.showExitDialog();
	}
	
	public void setMainApp(MainApp mainApp) {
		_mainApp=mainApp;
	}
	
	
}
