package assignment.view.gameframe;




import assignment.model.*;
import javafx.scene.control.ProgressBar;
import org.controlsfx.control.Notifications;

import com.jfoenix.controls.JFXTextField;

import assignment.MainApp;
import assignment.util.Answer;
import assignment.util.Counter;
import assignment.util.Recorder;
import assignment.view.Controller;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.concurrent.Task;
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
import java.util.ArrayList;
import java.util.List;


public class GameFrameController extends Controller{

	//private variables for FXML file
	@FXML private Pane _Pane;

	@FXML private ImageView _imageView;

	@FXML private ImageView _imageView1;

	//buttons -> FXML file
	@FXML private Button _nextButton;

	@FXML private Button _reBtn;

	@FXML private Button _submitBtn;

	@FXML private Button _playBtn;

	@FXML private Button _backBtn;

	//vars for TextFields
	@FXML private JFXTextField _playerAnswer;

	@FXML private JFXTextField _correctAnswer;

	@FXML private ImageView _correctnessImage;

	@FXML private Label _label;

	@FXML private AnchorPane _anchorPane;

	@FXML private Pane _rootPane;

	@FXML private ProgressBar _bar0;
	@FXML private ProgressBar _bar1;
	@FXML private ProgressBar _bar2;
	@FXML private ProgressBar _bar3;
	@FXML private ProgressBar _bar4;
	@FXML private ProgressBar _bar5;
	@FXML private ProgressBar _bar6;
	@FXML private ProgressBar _bar7;
	@FXML private ProgressBar _bar8;
	@FXML private ProgressBar _bar9;
	private List<ProgressBar> _bars=new ArrayList<>();






	//private variables for functionality
	private Level _level;

	private MainApp _mainApp;

	//counter vars
	private Counter _frameCounter;

	private Counter _attemptCounter;

	private Counter _scoreCounter;

	private Counter _recCounter;

	private boolean _isIncreased=false;

	//other vars
	private Round _round;
	
	private Player _player;

	private int _num = 0;



	/**
	 * initialize method for the GameFrame , initializes the counters and
	 * sets the image graphics on the buttons also locks certain buttons which
	 * can only be used after certain functionality has been attained
	 * play and submit is locked if record hasn't been pressed
	 */
	@FXML
	public void initialize() {
		//setting the fade in transition
		_rootPane.setOpacity(0);
		makeFadeIn(_rootPane);



		//initialize the counters which is are required
		_frameCounter = new Counter(10);
		_attemptCounter = new Counter();
		_scoreCounter = new Counter(10);
		_recCounter = new Counter();

		//loading the game back view
		Image image = new Image(getClass().getClassLoader().getResource("resources/gameImage.jpg").toString());
		_imageView.setImage(image);

		//loading image icons on the buttons
		Image reImage = new Image(getClass().getClassLoader().getResource("resources/record2.png").toString());
		_reBtn.setGraphic(new ImageView(reImage));

		Image playImage = new Image(getClass().getClassLoader().getResource("resources/play1.png").toString());
		_playBtn.setGraphic(new ImageView(playImage));

		Image subImage = new Image(getClass().getClassLoader().getResource("resources/submit.png").toString());
		_submitBtn.setGraphic(new ImageView(subImage));

		//locks the base buttons before the record button is pressed
		lockSomeBtns();

		addBars();

	}

	private void addBars() {
		_bars.add(_bar0);
		_bars.add(_bar1);
		_bars.add(_bar2);
		_bars.add(_bar3);
		_bars.add(_bar4);
		_bars.add(_bar5);
		_bars.add(_bar6);
		_bars.add(_bar7);
		_bars.add(_bar8);
		_bars.add(_bar9);
	}

	/**
	 * the handle next button handles the changing of the game frame which is based
	 * on creating a numeric and adding that to the label whenever the next button.
	 */
	@FXML
	public void handleNextButton() {
		_isIncreased=false;

		_reBtn.setDisable(false);
		//initializing the record counter
		_recCounter = new Counter();


		//setting the record button graphic
		Image reimage = new Image(getClass().getClassLoader().getResource("resources/record1.png").toString());
		_reBtn.setGraphic(new ImageView(reimage));

		//set the values of the text to nothing
		_playerAnswer.setText("");
		_correctAnswer.setText("");


		_frameCounter.increaseCounter();


		if (_frameCounter.getCounter() < 10) {


			_correctnessImage.setImage(null);

			lockSomeBtns();

			WritableImage image = _Pane.snapshot(new SnapshotParameters(), null);
			_imageView1.setImage(image);
			_imageView1.toFront();

			setEquation(_level);

			FadeTransition fadeout = new FadeTransition(Duration.millis(500), _imageView1);
			fadeout.setFromValue(1.0);
			fadeout.setToValue(0.0);
			fadeout.setOnFinished(event -> {
                _imageView1.setImage(null);
                fadeout.stop();
            });
			fadeout.playFromStart();


		} else {

			_round.setScore(_scoreCounter.getCounter());
			_round.setAttempts(_attemptCounter.getCounter());

			_round.setLevel(_level);

			_mainApp.showStatsFrame(_round,_player);

		}


	}

	/**
	 * handling of the back button which moves back to the previous frame
	 * which is the level frame while reseting the stats of the players since
	 * the player hasn't finished the game
	 */
	@FXML
	public void handleBackButton() {
		_round.resetStats();
		makeFadeOut(_rootPane,_player,_round,_mainApp,ControllerType.LEVEL);
	}

	/**
	 * this handles the record button which shall start
	 * the working of the SwingWorker thread which shall work the
	 * htk methods in the background
	 */
	@FXML
	public void handleRecordButton() {
		_recCounter.increaseCounter();

		_correctAnswer.setText("");
		_playerAnswer.setText("");

		lockAllBtns();
		_correctnessImage.setImage(null);

		waitCursor();
		DoWork doWork = new DoWork();
		Thread thread = new Thread(doWork);
		thread.start();
	}

	/**
	 * the submit button is used to check the the voice recording that was attained
	 * based on the string values with what the actual values of the string is
	 */
	@FXML
	public void handleSubmitBtn() {
		//increase attempt counter
		_attemptCounter.increaseCounter();
		_submitBtn.setDisable(true);
		//disable the other buttons
		_nextButton.setDisable(false);
		_nextButton.requestFocus();
		_playBtn.setDisable(true);

		//checking the answer is correct
		Answer answer = new Answer();
		boolean correctness = answer.checkAnswer(_num);

		boolean isAnswerValid=answer.isGrammarCorrect(_num);
		if(!isAnswerValid){
			Notifications.create()
						.text("Please check the connection of your microphone")
						.position(Pos.CENTER).hideAfter(Duration.seconds(1)).showWarning();
		}

		ProgressBar bar=_bars.get(_frameCounter.getCounter());
		bar.setProgress(1);

		if (correctness) {
			Image image = new Image(getClass().getClassLoader().getResource("resources/correct.png").toString(), true);
			_correctnessImage.setImage(image);
			bar.setStyle("-fx-accent:green");
			//checking if the recording has been acquired
			if (!_isIncreased) {
				_isIncreased=true;
				_scoreCounter.increaseCounter();
			}

			//gaining the string values and setting them to the textfields
			//to show the player
			String s = answer.getPLayerAnswer();
			_playerAnswer.setText(s);

			String correct = answer.getAnswer();
			_correctAnswer.setText(correct);

		} else {
			if(!_isIncreased)
			bar.setStyle("-fx-accent:red");
			//setting the wrong icon if the answer is incorrect
			Image image = new Image(getClass().getClassLoader().getResource("resources/wrong.png").toString(), true);

			_correctnessImage.setImage(image);
			String s = answer.getPLayerAnswer();
			_playerAnswer.setText(s);

			//if the player is stuck on the same frame 3 times then it shall
			//show the correct answer
			if (_recCounter.getCounter() == 3) {
				String correct = answer.getAnswer();
				_correctAnswer.setText(correct);
				_label.setText(Integer.toString(_num));
				_reBtn.setDisable(true);
			}

		}
	}

	/**
	 * when the play button is pressed the voice that was captured for
	 * recording is played to the user so they can check if they got the correct
	 * answer
	 */
	@FXML
	public void handlePlayBtn() {
		lockAllBtns();
		waitCursor();
		PlayWorker playWorker = new PlayWorker();
		Thread thread = new Thread(playWorker);
		thread.start();
	}


	/**
	 * this method sets the level which is used to set the equations on the screen
	 */
	public void setLevel(Level level) {
		_level = level;
		setEquation(level);
	}
	
	/**
	 * This is to set the correct number and the label of the image
	 */
	private void setEquation(Level level) {
		Arithmatic arith=new Arithmatic();
		String formula;
		if(level.getLevels().equals(Level.Levels.CUSTOMIZE)){
			ArrayList<String> formulas= QuestionList.getInstance();
			formula=formulas.get(_frameCounter.getCounter());
		}else {
			formula = level.generateFormula();
			while (arith.isOutOfBound(formula)) {
				formula = level.generateFormula();
			}
		}
		_label.setText(formula);
		_num=arith.formulaToNumber(formula);
	}

	/**
	 * setting the MainApp.
	 */
	public void setMainApp(MainApp mainApp){
		_mainApp=mainApp;
		normaliseCursor();
	}

	/**
	 * setting the player
	 */
	public void setRound(Round round) {
		_round=round;
		_round.setTime(new Time());
		_round.getTime().start();
	}
	
	public void setPlayer(Player player) {
		_player=player;
	}
	



	/**
	 * this method releases all the buttons
	 */
	public void releaseAllBtns() {
		_playBtn.setDisable(false);
		_reBtn.setDisable(false);
		_submitBtn.setDisable(false);
		_backBtn.setDisable(false);
	}

	/**
	 * this method locks all the buttons
	 */
	public void lockAllBtns() {
		_playBtn.setDisable(true);
		_reBtn.setDisable(true);
		_submitBtn.setDisable(true);
		_backBtn.setDisable(true);
		_nextButton.setDisable(true);
	}

	/**
	 * all other buttons are locked except the back button
	 */
	public void lockSomeBtns(){
		_playBtn.setDisable(true);
		_submitBtn.setDisable(true);
		_nextButton.setDisable(true);
	}
	

	/**
	 * change the cursor to a wait state when the recording occurs such that
	 * it can't be used to disrupt the entire program
	 */
	public void waitCursor() {		

		//do this to the components of the scene
		_mainApp.getPrimaryStage().getScene().setCursor(Cursor.WAIT);
		_anchorPane.setCursor(Cursor.WAIT);
		_playerAnswer.setCursor(Cursor.WAIT);
		_correctAnswer.setCursor(Cursor.WAIT);
	}




	/**
	 * changing the cursor back to the normalise state where the cursor can be used
	 * once again
	 */
		public void normaliseCursor() {

			//get control of the cursor once again
			_mainApp.getPrimaryStage().getScene().setCursor(Cursor.DEFAULT);
			_anchorPane.setCursor(Cursor.DEFAULT);
			_playerAnswer.setCursor(Cursor.DEFAULT);
			_correctAnswer.setCursor(Cursor.DEFAULT);
		}






	/**
	 * this is a worker class which shall do the recording in the background
	 * whenever the record button is presed
	 */
	class DoWork extends Task<Void>{

		@Override
		protected Void call() throws Exception {

			//set the record to store the recording
			Recorder recorder = new Recorder();
			recorder.record();
			recorder.recordToWord();
			return null;
		}

		@Override
		protected void done() {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {

					//setting the new image which is replay
					Image image = new Image(getClass().getClassLoader().getResource("resources/replay1.png").toString());
					_reBtn.setGraphic(new ImageView(image));

					releaseAllBtns();
					normaliseCursor();
				}
			});
		}
	}

	/**
	 * play worker is the worker class which allows the playing of the
	 * recording when the play button is pressed in the background
	 */
	class PlayWorker extends Task<Void>{

		@Override
		protected Void call() throws Exception {
			Recorder recorder = new Recorder();
			recorder.playRecord();
			return null;
		}

		@Override
		protected  void done() {

			Platform.runLater(() -> {
                //make this for doing other methods
                normaliseCursor();
                releaseAllBtns();


            });


		}
		
		
	}

}
