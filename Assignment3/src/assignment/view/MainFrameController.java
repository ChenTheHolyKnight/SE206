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
		//_mainApp.showLevelLayout();
		_mainApp.showUserNameFrame();
		
	}
	
	@FXML
	public void handleExitButton() {
		_mainApp.showExitDialog();
		/*Dialogs.create()
        .owner(_mainApp)
        .title("Information Dialog")
        .masthead("Look, an Information Dialog")
        .message("I have a great message for you!")
        .showInformation();*/
	}
	
	@FXML
	public void handleTutorialButton() {
		_mainApp.showTutorialFrame();
	}
	
	
	@FXML
	public void handleScoreButton() {
		_mainApp.showScoreFrame();
	}
	
	public void setMainApp(MainApp mainApp) {
		_mainApp=mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
}
