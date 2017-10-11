package assignment.view.customizegameframe;

import assignment.MainApp;
import assignment.model.Player;
import assignment.view.Controller;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;


public class CustomizeGameFrameController extends Controller{
	private MainApp _mainApp;
	private Player _player;
	
	@FXML
	private Pane _rootPane;
	
	
	
	@FXML
	public void handleBackButton() {
		makeFadeOut(_rootPane,_player,_mainApp,ControllerType.LEVEL);
	}
	
	public void setMainApp(MainApp mainApp) {
		_mainApp=mainApp;
	}
	public void setPlayer(Player player) {
		_player=player;
	}

}
