package assignment.view;




import org.controlsfx.control.Notifications;
import org.controlsfx.control.PopOver;

import com.jfoenix.controls.JFXTextField;

import assignment.MainApp;
import assignment.model.Level;
import assignment.model.Player;
import assignment.util.Answer;
import assignment.util.Counter;
import assignment.util.Recorder;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
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
	private Button _playBtn;
	@FXML
	private Button _backBtn;
	@FXML
	private JFXTextField _playerAnswer;
	@FXML
	private JFXTextField _correctAnswer;
	@FXML
	private ImageView _correctnessImage;


	@FXML
	private Label _label;

	@FXML
	private AnchorPane _anchorPane;



	private Level _level;

	private MainApp _mainApp;

	private Counter _frameCounter;

	private Counter _attemptCounter;

	private Counter _scoreCounter;
	
	private Counter _recCounter;

	private Player _player;

	private int _num=0;
	
	
	
	
	private boolean _isPopOverShown=false;

	@FXML
	public void initialize() {
		Image image=new Image(getClass().getClassLoader().getResource("resources/gameImage.jpg").toString());
		_imageView.setImage(image);
		_frameCounter=new Counter(10);
		_attemptCounter=new Counter();
		_scoreCounter=new Counter(10);
		_recCounter=new Counter();
		
		
		Image reImage=new Image(getClass().getClassLoader().getResource("resources/record2.png").toString());
		_reBtn.setGraphic(new ImageView(reImage));
		Image playImage=new Image(getClass().getClassLoader().getResource("resources/play1.png").toString());
		_playBtn.setGraphic(new ImageView(playImage));
		Image subImage=new Image(getClass().getClassLoader().getResource("resources/submit.png").toString());
		_submitBtn.setGraphic(new ImageView(subImage));
		
		_nextButton.setDisable(true);
		_submitBtn.setDisable(true);
		_playBtn.setDisable(true);
	}

	@FXML
	public void handleNextButton() {
		_recCounter=new Counter();
		Image reimage=new Image(getClass().getClassLoader().getResource("resources/record1.png").toString());
		_reBtn.setGraphic(new ImageView(reimage));		
		_playerAnswer.setText("");
		_correctAnswer.setText("");
		_playBtn.setDisable(true);
		_frameCounter.increaseCounter();
		if(_frameCounter.getCounter()<10) {
			_correctnessImage.setImage(null);
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
			_player.setScore(_scoreCounter.getCounter());
			_player.setAttempts(_attemptCounter.getCounter());
			_player.setLevel(_level);
			_mainApp.showStatsFrame(_player);
		}

	}


	@FXML
	public void handleBackButton() {
		_player.resetStats();
		_mainApp.showLevelLayout(_player);
	}

	@FXML
	public void handleRecordButton() {
		_recCounter.increaseCounter();
		_correctAnswer.setText("");
		_playerAnswer.setText("");
		_nextButton.setDisable(true);
		_playBtn.setDisable(true);
		_submitBtn.setDisable(true);
		_backBtn.setDisable(true);
		_correctnessImage.setImage(null);
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
		_playBtn.setDisable(true);
		Answer answer=new Answer();
		boolean correctness=answer.checkAnswer(_num);
		if(correctness) {
			Image image=new Image(getClass().getClassLoader().getResource("resources/correct.png").toString(),true);
			_correctnessImage.setImage(image);
			
			if(_recCounter.getCounter()==1) { ///bugs here
				_scoreCounter.increaseCounter();
			}
			String s=answer.getPLayerAnswer();
			_playerAnswer.setText(s);
			String correct=answer.getAnswer();
			_correctAnswer.setText(correct);
		}else {
			Image image=new Image(getClass().getClassLoader().getResource("resources/wrong.png").toString(),true);
			_correctnessImage.setImage(image);
			String s=answer.getPLayerAnswer();
			_playerAnswer.setText(s);

		}
		_submitBtn.setDisable(true);
	}
	
	@FXML
	public void handlePlayBtn() {
		_playBtn.setDisable(true);
		_reBtn.setDisable(true);
		_submitBtn.setDisable(true);
		_nextButton.setDisable(true);
		_backBtn.setDisable(true);
		PlayWorker playworker=new PlayWorker();
		Thread thread=new Thread(playworker);
		thread.start();
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
	//need to be refactored
	public void showPopOver() {

		Label label=new Label();
		label.setText("Press play to play your recording");
		
		PopOver popover=new PopOver(label);
		popover.setFadeOutDuration(new Duration(1000));
		popover.setArrowLocation(PopOver.ArrowLocation.TOP_CENTER);
		popover.show(_playBtn);

		FadeTransition fade=new FadeTransition(Duration.seconds(5),popover.getRoot());
		fade.setFromValue(1);
		fade.setToValue(0);
		fade.setOnFinished(e->popover.hide());
		fade.play();
	}


	//this is the worker class that is used to record recordings
	class DoWork extends Task<Void>{

		@Override
		protected Void call() throws Exception {
			_reBtn.setDisable(true);
			Recorder recorder=new Recorder();
			recorder.record();		
			recorder.recordToWord();
			return null;
		}


		@Override
		protected void done() {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					//_reBtn.setText("Try Again");
					Image image=new Image(getClass().getClassLoader().getResource("resources/replay1.png").toString());
					_reBtn.setGraphic(new ImageView(image));
					
					_playBtn.setDisable(false);
					_mainApp.getPrimaryStage().getScene().setCursor(Cursor.DEFAULT);
					_anchorPane.setCursor(Cursor.DEFAULT);
					_reBtn.setDisable(false);
					_submitBtn.setDisable(false);
					_backBtn.setDisable(false);
					Answer answer=new Answer();
					answer.checkAnswer(_num);
					if(answer.getPLayerAnswer().isEmpty()) {
						Notifications.create()
									.text("no voice detected,please try again")
									.position(Pos.CENTER)
									.hideAfter(Duration.seconds(1))
									.showWarning();						
					}
					if(!_isPopOverShown) {
						showPopOver();
						_isPopOverShown=true;
					}
				}
			});
		}
	}
	
	class PlayWorker extends Task<Void>{
		@Override
		protected Void call() throws Exception {
			Recorder recorder=new Recorder();
			recorder.playRecord();
			return null;
		}
		
		
		@Override
		protected void done() {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					_playBtn.setDisable(false);
					_reBtn.setDisable(false);
					_submitBtn.setDisable(false);
					_backBtn.setDisable(false);
				}
			});
		}
		
		
	}

}
