package assignment.view;


import java.net.URL;
import java.util.ResourceBundle;



import assignment.MainApp;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import org.controlsfx.control.PopOver;


public class MainFrameController implements Initializable{
	private MainApp _mainApp;

	@FXML
	private Pane _rootPane;
	
	@FXML
	public void handleStartButton() {
		makeFadeOutStart();

		
	}
	
	@FXML
	public void handleExitButton() {
		_mainApp.showExitDialog();
	}
	
	/**@FXML
	public void handleTutorialButton() {
		_mainApp.showTutorialFrame();
	}*/
	
	
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

	/**
	 * this is used to make a fadeOut Transition from the mainFrame and then shall be allowed to
	 * make a fadeIn transition to the next frame
	 */
	public void makeFadeOutStart() {
		FadeTransition fadeout = new FadeTransition();
		fadeout.setDuration(Duration.millis(750));
		fadeout.setNode(_rootPane);
		fadeout.setFromValue(1.0);
		fadeout.setToValue(0.0);
		fadeout.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				_mainApp.showUserNameFrame();
			}
		});
		fadeout.play();
	}
	
	
}
