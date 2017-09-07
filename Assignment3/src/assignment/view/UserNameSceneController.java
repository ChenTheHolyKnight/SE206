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
	public void handleButton() {
		if(_textField.getText()!=null&&!_textField.getText().equals("")) {
			_button.setDisable(false);
			_mainApp.showLevelLayout();
		}
	}

	public Button getButton() {
		return _button;

	}

	public TextField getText() {
		return _textField;

	}

}
