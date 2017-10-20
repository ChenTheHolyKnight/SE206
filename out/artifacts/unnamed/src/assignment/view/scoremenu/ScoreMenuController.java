package assignment.view.scoremenu;

import assignment.MainApp;
import javafx.fxml.FXML;

public class ScoreMenuController {
		private MainApp _mainApp;
		
		
		
		
		
		
		
		
		@FXML
		public void handleBackButton() {
			_mainApp.initMainFrame();
		}
		
		
		
		public void setMainApp(MainApp mainApp) {
			_mainApp=mainApp;
		}
}
