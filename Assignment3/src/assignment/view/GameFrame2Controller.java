package assignment.view;

import assignment.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GameFrame2Controller {
	private MainApp _mainApp;
	private int _num;
	@FXML
	private Label _label;
	
	
	
	
	@FXML
	public void handleTryAgainButton() {
		_mainApp.showGameFrame1(_num);
	}
	
	
	
	
	public void setLabel(int num) {	
		_label.setText(Integer.toString(num));
		_num=num;
		
	}
	
	
	
	
	public void setMainApp(MainApp mainApp) {
		_mainApp=mainApp;
	}
}
