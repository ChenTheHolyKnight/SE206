package assignment.view;


import java.util.List;

import com.jfoenix.controls.JFXTextField;

import assignment.MainApp;
import assignment.model.Level;
import assignment.model.Player;
import assignment.util.Answer;
import assignment.util.Counter;
import assignment.util.FileReader;
import assignment.util.Recorder;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class GameFrameController {

	@FXML
	private Pane _Pane;
	@FXML
	private ImageView _imageView;
	@FXML
	private ImageView _imageView1;

	@FXML
	private Button _nextButton;
	@FXML
	private Button _reBtn;
	@FXML
	private Button _submitBtn;
	@FXML
	private JFXTextField _playerAnswer;
	@FXML
	private JFXTextField _correctAnswer;

	@FXML
	private Label _label;

	@FXML
	private AnchorPane _anchorPane;

	private Level _level;

	private MainApp _mainApp;
	
	private Counter _frameCounter;
	
	private Counter _attemptCounter;
	
	private Counter _scoreCounter;
	
	private Player _player;
	
	private int _num=0;

	@FXML
	public void initialize() {
		Image image=new Image(getClass().getClassLoader().getResource("resources/gameImage.jpg").toString());
		_imageView.setImage(image);
		_frameCounter=new Counter(10);
		_attemptCounter=new Counter();
		_scoreCounter=new Counter(10);
		_nextButton.setDisable(true);
		_submitBtn.setDisable(true);
	}

	@FXML
	public void handleNextButton() {
		_playerAnswer.setText("");
		_correctAnswer.setText("");
		_reBtn.setText("Record");
		_frameCounter.increaseCounter();
		if(_frameCounter.getCounter()<10) {
			_submitBtn.setDisable(true);
			_nextButton.setDisable(true);
			WritableImage image=_Pane.snapshot(new SnapshotParameters(),null);
			_imageView1.setImage(image);
			_imageView1.toFront();
			 _num=_level.generateNumber();
			_label.setText(Integer.toString(_num));
			TranslateTransition transition=new TranslateTransition(Duration.millis(500),_imageView1);
			transition.setByX(-500f);
			transition.setFromX(0);
			transition.setOnFinished(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					_imageView1.setImage(null);
					transition.stop();
				}

			});
			transition.playFromStart();	
		}else {
			//next frame needs to be implemented to show the statistic of this game
			Player player=new Player();
			player.setScore(_scoreCounter.getCounter());
			player.setAttempts(_attemptCounter.getCounter());
			player.setLevel(_level);
		}
		
	}
	
	
	@FXML
	public void handleBackButton() {
		_player.resetStats();
		_mainApp.showLevelLayout(_player);
	}

	@FXML
	public void handleRecordButton() {
		_correctAnswer.setText("");
		_playerAnswer.setText("");
		//_attemptCounter.increaseCounter();
		//System.out.println(_attemptCounter.getCounter());
		_mainApp.getPrimaryStage().getScene().setCursor(Cursor.WAIT);
		_anchorPane.setCursor(Cursor.WAIT);
		DoWork dowork=new DoWork();
		Thread thread=new Thread(dowork);
		thread.start();	
		
	}
	
	@FXML
	public void handleSubmitBtn() {
		_nextButton.setDisable(false);
		_attemptCounter.increaseCounter();
		Answer answer=new Answer();
		//System.out.println(_num);
		boolean correctness=answer.checkAnswer(_num);
		//System.out.println(correctness);
		if(correctness) {
			String s=answer.getPLayerAnswer();
			System.out.println(s);
			_playerAnswer.setText(s);
			String correct=answer.getAnswer();
			_correctAnswer.setText(correct);
		}else {
			String s=answer.getPLayerAnswer();
			System.out.println(s);
			_playerAnswer.setText(s);
			
		}
	}
	public void setLevel(Level level) {
		_level=level;
		_num=_level.generateNumber();
		_label.setText(Integer.toString(_num));
	}

	public void setMainApp(MainApp mainApp){
		_mainApp=mainApp;
	}	
	
	public void setPlayer(Player player) {
		_player=player;
	}
	/*
	private void checkAnswer() {
		//System.out.println("true");
		FileReader reader=new FileReader();
		List<String> answer=reader.getRecordFile();
		System.out.println(answer);
	}*/

	class DoWork extends Task<Void>{

		@Override
		protected Void call() throws Exception {
			_reBtn.setDisable(true);
			Recorder recorder=new Recorder();
			recorder.record();		
			recorder.recordToWord();
			recorder.playRecord();
			recorder.deleteRecord();
			return null;
		}


		@Override
		protected void done() {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					_reBtn.setText("Try Again");
					_mainApp.getPrimaryStage().getScene().setCursor(Cursor.DEFAULT);
					_anchorPane.setCursor(Cursor.DEFAULT);
					_reBtn.setDisable(false);
					_submitBtn.setDisable(false);
					//checkAnswer();
				}

			});
		}
		
		
		

	}

}
