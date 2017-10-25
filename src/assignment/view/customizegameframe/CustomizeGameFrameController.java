package assignment.view.customizegameframe;




import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;

import assignment.model.Arithmatic;
import assignment.model.QuestionList;
import assignment.util.Counter;
import assignment.util.FileReader;
import assignment.util.JsonFileIO;
import com.google.gson.Gson;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;


import assignment.MainApp;
import assignment.model.Player;
import assignment.model.Round;
import assignment.view.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;



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
	@FXML private JFXButton _manualButton;
	@FXML private JFXButton _loadButton;
	@FXML private Button _enterBtn;
	@FXML private ProgressBar _bar1;
	@FXML private ProgressBar _bar2;
	@FXML private ProgressBar _bar3;
	@FXML private ProgressBar _bar4;
	@FXML private ProgressBar _bar5;
	@FXML private ProgressBar _bar6;
	@FXML private ProgressBar _bar7;
	@FXML private ProgressBar _bar8;
	@FXML private ProgressBar _bar9;
	@FXML private ProgressBar _bar0;
	private ArrayList<ProgressBar> _bars=new ArrayList<>();
	@FXML private ListView<String> _listView;



	@FXML
	public void initialize() {
		_questionList.clear();
		_nextButton.setVisible(false);
		_loadButton.setDisable(false);
		_manualButton.setDisable(false);
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
		_textField.setEditable(false);

		addBars();
		setBarsVisiblity(false);

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
		_loadButton.setDisable(true);
		setBarsVisiblity(true);
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
			setProgress();
			_enterBtn.setDisable(true);
			ObservableList<String> questions=FXCollections.observableArrayList(_questionList);
			_listView.setItems(questions);
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
		_enterBtn.setDisable(false);
		_textField.setText("");
		_counter.increaseCounter();
		if(_counter.getCounter()==10){
			JsonFileIO jf=new JsonFileIO();
			jf.writeFile("Question.json",_questionList);
			makeFadeOut(_rootPane,_player,_round,_mainApp,ControllerType.CUSTOMIZEGAME);
		}
		_textField.requestFocus();
		_nextButton.setVisible(false);
	}


	@FXML
	public void handleLoadButton(){
		_manualButton.setDisable(true);
		FileChooser fc=new FileChooser();
		fc.setTitle("FileChooser");
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Json Files", "*.json"));
		File selectedFile = fc.showOpenDialog(_mainApp.getPrimaryStage());
		if (selectedFile != null) {
			String fileName = selectedFile.getName();
			String fileExtension = fileName.substring(fileName.indexOf(".") + 1, selectedFile.getName().length());
			if(fileExtension.equals("txt")){
				try (Scanner scanner=new Scanner(selectedFile)){
					while(scanner.hasNextLine()) {
						_questionList.add(scanner.nextLine());
					}
				}catch(IOException e) {

				}
			}else{
					JsonFileIO jf=new JsonFileIO();
					List<String> questionList=jf.readQuestionFile(selectedFile);
					for(String s:questionList){
						_questionList.add(s);
					}

			}

			if(isValidQustionList(_questionList)){

				_listView.setItems(FXCollections.observableList(_questionList));
				_nextButton.setVisible(true);
				_counter.setCounter(9);
				_textField.setEditable(false);
			}else{
				Notifications.create().text("Invalid input questions.").position(Pos.CENTER).hideAfter(Duration.seconds(1)).showWarning();
				_manualButton.setDisable(false);
				_nextButton.setVisible(false);
				_questionList.clear();
			}
		}else{
			_manualButton.setDisable(false);
		}
	}

	private boolean isValidQustionList(List<String> list){
		if(list==null){
			return false;
		}
		if(list.size()!=10){
			return false;
		}
		Arithmatic arithmatic=new Arithmatic();
		for(String s:list){
			if(arithmatic.isOutOfBound(s)){
				return false;
			}
		}
		return true;
	}



	private void setProgress(){
		int num=_counter.getCounter();
		_bars.get(num).setProgress(1);
	}





	@FXML
	public void handleButtonsInTheGridPane(Event event) {
		Button button= (Button) event.getSource();
		String text=_textField.getText();
		_textField.requestFocus();
		if(button.getText().equals("Space")) {
			_textField.setText(text+" ");
		} else {
			_textField.setText(text+button.getText());
		}
		_textField.positionCaret(_textField.getText().length());
	}

	private void addBars(){
		_bars.add(_bar1);
		_bars.add(_bar2);
		_bars.add(_bar3);
		_bars.add(_bar4);
		_bars.add(_bar5);
		_bars.add(_bar6);
		_bars.add(_bar7);
		_bars.add(_bar8);
		_bars.add(_bar9);
		_bars.add(_bar0);
	}


	private void setBarsVisiblity(boolean b){
		for(ProgressBar bar:_bars){
			bar.setVisible(b);
		}
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
