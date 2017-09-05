package assignment.view;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class DeletionDialogController {

	private Stage _dialogStage;
	
	@FXML
	public void okController() {
		System.exit(0);
	}
	@FXML
	public void cancelController() {
		_dialogStage.close();
	}
	
	public void setMainApp(Stage stage) {
		_dialogStage=stage;
	}
}
