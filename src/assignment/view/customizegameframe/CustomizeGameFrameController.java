package assignment.view.customizegameframe;




import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;


import assignment.MainApp;
import assignment.model.Player;
import assignment.model.Round;
import assignment.view.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;


public class CustomizeGameFrameController extends Controller{
	private MainApp _mainApp;
	private Player _player;
	private Round  _round;


	@FXML
	private JFXTextField _textField;

	@FXML
	private Pane _rootPane;

	@FXML
	private GridPane _grid;

	@FXML
	private JFXButton _nextButton;


	@FXML
	private Button _btn0;

	@FXML
	private Button _btn1;

	@FXML
	private Button _btn2;

	@FXML
	private Button _btn3;

	@FXML
	private Button _btn4;

	@FXML
	private Button _btn5;

	@FXML
	private Button _btn6;


	@FXML
	private Button _btn7;

	@FXML
	private Button _btn8;

	@FXML
	private Button _btn9;

	@FXML
	private Button _multiBtn;

	@FXML
	private Button _addBtn;

	@FXML
	private Button _minusBtn;

	@FXML
	private Button _divisionBtn;

	@FXML
	private Button _leftBracketBtn;

	@FXML
	private Button _rightBracketBtn;

	@FXML
	private Button _spaceBtn;


	@FXML
	public void initialize() {
		//_textField.positionCaret(0);
		_nextButton.setVisible(false);
		_grid.setVisible(false);
		
		//TextFormatter formatter = new TextFormatter<String>(;
		
		//TextFormatter formatter = new TextFormatter<String>(null);
		UnaryOperator<Change> filter = change -> {
		    String text = change.getText();

		    if (text.matches("[*+-/()x0-9\\s]*")&&!text.matches("[.,]")) {
		        return change;
		    }

		    return null;
		};
		TextFormatter<String> formatter = new TextFormatter<String>(filter);
		_textField.setTextFormatter(formatter);
	}

	@FXML
	public void handleBackButton() {
		makeFadeOut(_rootPane,_player,_round,_mainApp,ControllerType.LEVEL);
	}

	@FXML
	public void handleManualButton() {
		_grid.setVisible(true);
		
	}

	@FXML
	public void handleEnterButton() {
		_nextButton.setVisible(true);

	}

	@FXML
	public void handleBackSpaceButton() {
		String text=_textField.getText();
		_textField.requestFocus();
		if(text.length()>0) {
			StringBuffer sb=new StringBuffer(text);
			sb.deleteCharAt(text.length()-1);
			_textField.setText(sb.toString());
		}
		_textField.positionCaret(_textField.getText().length());
	}


	//handle the buttons inside the grid pane
	@FXML
	public void handleBtn1() {
		handelButtonsInTheGridPane(_btn1);
	}
	@FXML
	public void handleBtn2() {
		handelButtonsInTheGridPane(_btn2);
	}
	@FXML
	public void handleBtn3() {
		handelButtonsInTheGridPane(_btn3);
	}
	@FXML
	public void handleBtn4() {
		handelButtonsInTheGridPane(_btn4);
	}
	@FXML
	public void handleBtn5() {
		handelButtonsInTheGridPane(_btn5);
	}
	@FXML
	public void handleBtn6() {
		handelButtonsInTheGridPane(_btn6);
	}
	@FXML
	public void handleBtn7() {
		handelButtonsInTheGridPane(_btn7);
	}
	@FXML
	public void handleBtn8() {
		handelButtonsInTheGridPane(_btn8);
	}
	@FXML
	public void handleBtn9() {
		handelButtonsInTheGridPane(_btn9);
	}
	@FXML
	public void handleBtn0() {
		handelButtonsInTheGridPane(_btn0);
	}
	@FXML
	public void handleMultiBtn() {
		handelButtonsInTheGridPane(_multiBtn);
	}
	@FXML
	public void handleAddBtn() {
		handelButtonsInTheGridPane(_addBtn);
	}
	@FXML
	public void handleMinusBtn() {
		handelButtonsInTheGridPane(_minusBtn);
	}
	@FXML
	public void handleDivisionBtn() {
		handelButtonsInTheGridPane(_divisionBtn);
	}
	@FXML
	public void handleLeftBracketBtn() {
		handelButtonsInTheGridPane(_leftBracketBtn);
	}
	@FXML
	public void handleRightBracketBtn() {
		handelButtonsInTheGridPane(_rightBracketBtn);
	}
	@FXML
	public void handleSpaceBtn() {
		handelButtonsInTheGridPane(_spaceBtn);
	}






	







	private void handelButtonsInTheGridPane(Button button) {
		String text=_textField.getText();
		_textField.requestFocus();
		if(button.getText().equals("Space")) {
			_textField.setText(text+" ");
		}else {
			_textField.setText(text+button.getText());
		}
		_textField.positionCaret(_textField.getText().length());
	}

	public void setMainApp(MainApp mainApp) {
		_mainApp=mainApp;
	}
	public void setPlayer(Player player) {
		_player=player;
	}
	public void setRound(Round round) {
		_round=round;
	}

}
