package assignment.view.customizegameframe;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import assignment.MainApp;
import assignment.model.Player;
import assignment.model.Round;
import assignment.view.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;


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
	public void initialize() {
		_grid.setOpacity(0);
		_nextButton.setOpacity(0);
	}

	@FXML
	public void handleBackButton() {
		makeFadeOut(_rootPane,_player,_round,_mainApp,ControllerType.LEVEL);
	}
	
	@FXML
	public void handleManualButton() {
		_grid.setOpacity(1);
	}
	
	@FXML
	public void handleEnterButton() {
		_nextButton.setOpacity(1);
	}

	@FXML
	public void handleBackSpaceButton() {
		String text=_textField.getText();
		if(text.length()>0) {
			StringBuffer sb=new StringBuffer(text);
			sb.deleteCharAt(text.length()-1);
			_textField.setText(sb.toString());
		}
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void handelButtonsInTheGridPane(Button button) {
		String text=_textField.getText();
		_textField.setText(text+button.getText());
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
