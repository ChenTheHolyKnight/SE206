package assignment.view;

import assignment.MainApp;
import javafx.fxml.FXML;

public class LevelLayoutController {
	private MainApp _mainApp;
	@FXML
	public void handleEasyButton() {
		_mainApp.initMainFrame();
		
	}
	
	
	public void setMainApp(MainApp mainApp) {
		_mainApp=mainApp;
	}
	
}
