package assignment.view.mainframe;


import java.net.URL;
import java.util.ResourceBundle;



import assignment.MainApp;
import assignment.view.Controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

public class MainFrameController extends Controller implements Initializable {
	private MainApp _mainApp;

	@FXML
	private Pane _rootPane;

	@FXML
	public void initialize(){

	}

	@FXML
	public void handleStartButton() {

		
		makeFadeOut(_rootPane,null,null,_mainApp,ControllerType.USERNAME);
		
	}
	
	@FXML
	public void handleExitButton() {
		_mainApp.showExitDialog();
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
		_rootPane.setOpacity(0);
		makeFadeIn(_rootPane);




	}

}
