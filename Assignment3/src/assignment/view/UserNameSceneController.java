package assignment.view;

import assignment.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class UserNameSceneController {
	@FXML 
	private Button _button;
	@FXML
	private TextField _textField;

	private MainApp _mainApp;

	public void setMainApp(MainApp mainApp) {
		_mainApp=mainApp;
	}
	
	@FXML
	public void initialize() {
		_button.setDisable(true);
	}

	@FXML
	public void handleButton() {
		if(_textField.getText()!=null&&!_textField.getText().equals("")) {
			_button.setDisable(false);
			_mainApp.showLevelLayout();
		}
	}
	
	@FXML
	public void handleBackButton() {
		_mainApp.initMainFrame();
	}
	
	@FXML
	public void setButtonRealsed() {
		String text=_textField.getText();
		boolean isDisabled=text.isEmpty()||text.trim().isEmpty();
		_button.setDisable(isDisabled);
	}

	
	


}
