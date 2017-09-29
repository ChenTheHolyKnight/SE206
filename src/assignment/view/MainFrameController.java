package assignment.view;


import java.net.URL;
import java.util.ResourceBundle;



import assignment.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


public class MainFrameController implements Initializable{
	private MainApp _mainApp;
	
	@FXML
	public void handleStartButton() {
		// moves to the show userFrame
		_mainApp.showUserNameFrame();
		
	}
	
	@FXML
	public void handleExitButton() {
		_mainApp.showExitDialog();
	}
	
	
	public void setMainApp(MainApp mainApp) {
		_mainApp=mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
