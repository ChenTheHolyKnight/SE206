package assignment.view;

import assignment.MainApp;
import assignment.model.Level;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GameFrame2Controller {
	private MainApp _mainApp;
	private int _num;
	private Level _level;
	@FXML
	private Label _label;
	
	
	
	
	@FXML
	public void handleTryAgainButton() {
		_mainApp.showGameFrame1(_num,_level);
	}
	
	@FXML
	public void handleNextButton() {
		int num=_level.generateNumber();
		_mainApp.showGameFrame1(num, _level);
	}
	
	@FXML
	public void handleBackButton() {
		_mainApp.showLevelLayout();
	}
	
	
	public void setLabel(int num) {	
		_label.setText(Integer.toString(num));
		_num=num;	
	}
	
	public void setLevel(Level level) {
		_level=level;
	}
	
	
	
	
	public void setMainApp(MainApp mainApp) {
		_mainApp=mainApp;
	}
}
