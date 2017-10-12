package assignment.view.customizegameframe;




import java.util.List;
import java.util.function.UnaryOperator;

import assignment.model.Arithmatic;
import assignment.model.QuestionList;
import assignment.util.Counter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;


import assignment.MainApp;
import assignment.model.Player;
import assignment.model.Round;
import assignment.view.Controller;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.omg.CORBA.PUBLIC_MEMBER;

import javax.management.Notification;


public class CustomizeGameFrameController extends Controller{
	private MainApp _mainApp;
	private Player _player;
	private Round  _round;
	private Counter _counter=new Counter();
	private List<String> _questionList=QuestionList.getInstance();

	@FXML private JFXTextField _textField;
	@FXML private Pane _rootPane;
	@FXML private GridPane _grid;
	@FXML private JFXButton _nextButton;
	@FXML private Button _btn0;
	@FXML private Button _btn1;
	@FXML private Button _btn2;
	@FXML private Button _btn3;
	@FXML private Button _btn4;
	@FXML private Button _btn5;
	@FXML private Button _btn6;
	@FXML private Button _btn7;
	@FXML private Button _btn8;
	@FXML private Button _btn9;
	@FXML private Button _multiBtn;
	@FXML private Button _addBtn;
	@FXML private Button _minusBtn;
	@FXML private Button _divisionBtn;
	@FXML private Button _leftBracketBtn;
	@FXML private Button _rightBracketBtn;
	@FXML private Button _spaceBtn;


	@FXML
	public void initialize() {
		_nextButton.setVisible(false);
		_grid.setVisible(false);
		_textField.setEditable(false);
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
		_textField.setEditable(true);
		_textField.requestFocus();
		_grid.setVisible(true);
		
	}

	@FXML
	public void handleEnterButton() {
		String s=_textField.getText();
		Arithmatic arith=new Arithmatic();
		int num=arith.formulaToNumber(s);
		if (num<1||num>99){
			Notifications.create().position(Pos.CENTER).text("Please enter a valid formula").hideAfter(Duration.seconds(1)).showWarning();
		}else {
			_questionList.add(s);
			_nextButton.setVisible(true);
		}

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

	@FXML
	public void handleNextButton(){
		_textField.setText("");
		_counter.increaseCounter();
		if(_counter.getCounter()==10){
			System.out.println("finish");
		}
		_textField.requestFocus();
		_nextButton.setVisible(false);
		//_textField.positionCaret(_textField.getText().length());
	}


	//handle the buttons inside the grid pane
	@FXML
	public void handleBtn1() {
		handleButtonsInTheGridPane(_btn1);
	}
	@FXML
	public void handleBtn2() {
		handleButtonsInTheGridPane(_btn2);
	}
	@FXML
	public void handleBtn3() {
		handleButtonsInTheGridPane(_btn3);
	}
	@FXML
	public void handleBtn4() {
		handleButtonsInTheGridPane(_btn4);
	}
	@FXML
	public void handleBtn5() {
		handleButtonsInTheGridPane(_btn5);
	}
	@FXML
	public void handleBtn6() {
		handleButtonsInTheGridPane(_btn6);
	}
	@FXML
	public void handleBtn7() {
		handleButtonsInTheGridPane(_btn7);
	}
	@FXML
	public void handleBtn8() {
		handleButtonsInTheGridPane(_btn8);
	}
	@FXML
	public void handleBtn9() {
		handleButtonsInTheGridPane(_btn9);
	}
	@FXML
	public void handleBtn0() {
		handleButtonsInTheGridPane(_btn0);
	}
	@FXML
	public void handleMultiBtn() {
		handleButtonsInTheGridPane(_multiBtn);
	}
	@FXML
	public void handleAddBtn() {
		handleButtonsInTheGridPane(_addBtn);
	}
	@FXML
	public void handleMinusBtn() {
		handleButtonsInTheGridPane(_minusBtn);
	}
	@FXML
	public void handleDivisionBtn() {
		handleButtonsInTheGridPane(_divisionBtn);
	}
	@FXML
	public void handleLeftBracketBtn() {
		handleButtonsInTheGridPane(_leftBracketBtn);
	}
	@FXML
	public void handleRightBracketBtn() {
		handleButtonsInTheGridPane(_rightBracketBtn);
	}
	@FXML
	public void handleSpaceBtn() {
		handleButtonsInTheGridPane(_spaceBtn);
	}

	private void handleButtonsInTheGridPane(Button button) {
		String text=_textField.getText();
		_textField.requestFocus();
		if(button.getText().equals("Space")) {
			_textField.setText(text+" ");
		} else {
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
