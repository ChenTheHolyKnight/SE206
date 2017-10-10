package assignment.view.gameframe;




import org.controlsfx.control.Notifications;
import org.controlsfx.control.PopOver;

import com.jfoenix.controls.JFXTextField;

import assignment.MainApp;
import assignment.model.Arithmatic;
import assignment.model.Level;
import assignment.model.Player;
import assignment.util.Answer;
import assignment.util.Counter;
import assignment.util.Recorder;
import assignment.view.Controller;
import javafx.animation.FadeTransition;
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
//import sun.plugin.javascript.navig.Anchor;


public class GameFrameController extends Controller{

	//private variables for FXML file
	@FXML
	private Pane _Pane;

	@FXML
	private ImageView _imageView;

	@FXML
	private ImageView _imageView1;

	//buttons -> FXML file
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

	//vars for TextFields
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

	@FXML
	private Pane _rootPane;


	//private variables for functionality
	private Level _level;

	private MainApp _mainApp;

	//counter vars
	private Counter _frameCounter;

	private Counter _attemptCounter;

	private Counter _scoreCounter;

	private Counter _recCounter;

	//other vars
	private Player _player;

	private int _num = 0;

	
	
	
	//pop over is not shown currently
	//private boolean _isPopOverShown = false;

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
	}

	/**
	 * the handle next button handles the changing of the game frame which is based
	 * on creating a numeric and adding that to the label whenever the next button.
	 */
	@FXML
	public void handleNextButton() {
		//initializing the record counter
		_recCounter = new Counter();

		//setting the record button graphic
		Image reimage = new Image(getClass().getClassLoader().getResource("resources/record1.png").toString());
		_reBtn.setGraphic(new ImageView(reimage));

		//set the values of the text to nothing
		_playerAnswer.setText("");
		_correctAnswer.setText("");


		_frameCounter.increaseCounter();

		//check if the counter value is above 10 if not then consider to move and change the labels
		//if done then lock the buttons and move to the next frame
		if (_frameCounter.getCounter() < 10) {


			_correctnessImage.setImage(null);

			//locks the default buttons such as play , record
			lockSomeBtns();

			WritableImage image = _Pane.snapshot(new SnapshotParameters(), null);
			_imageView1.setImage(image);
			_imageView1.toFront();

			//generate the number which is to be said by the player
			//_num = _level.generateNumber();
			//_label.setText(Integer.toString(_num));
			setEquation(_level);

			//fade transition cause it looks cooler :P
			FadeTransition fadeout = new FadeTransition(Duration.millis(500), _imageView1);
			fadeout.setFromValue(1.0);
			fadeout.setToValue(0.0);
			fadeout.setOnFinished(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					_imageView1.setImage(null);
					fadeout.stop();
				}
			});
			fadeout.playFromStart();


		} else {

			//get the values which the player got from playing
			//the game
			_player.setScore(_scoreCounter.getCounter());
			_player.setAttempts(_attemptCounter.getCounter());

			_player.setLevel(_level);

			//this leads to the stats frame which shall show the values
			//of the player
			_mainApp.showStatsFrame(_player);

		}


	}

	/**
	 * handling of the back button which moves back to the previous frame
	 * which is the level frame while reseting the stats of the players since
	 * the player hasn't finished the game
	 */
	@FXML
	public void handleBackButton() {

		//resetting the players stats
		_player.resetStats();

		//show the level layout
		makeFadeOut(_rootPane,_player,_mainApp,ControllerType.LEVEL);

	}

	/**
	 * this handles the record button which shall start
	 * the working of the SwingWorker thread which shall work the
	 * htk methods in the background
	 */
	@FXML
	public void handleRecordButton() {
		//increase record counter
		_recCounter.increaseCounter();

		//text values to empty strings to erase prompt text
		_correctAnswer.setText("");
		_playerAnswer.setText("");

		//locks all the buttons
		lockAllBtns();

		//deset any correct image graphics and start the thread
		_correctnessImage.setImage(null);

		//swingWorker methods
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

		//disable the other buttons
		_nextButton.setDisable(false);
		_playBtn.setDisable(true);

		//checking the answer is correct
		Answer answer = new Answer();
		boolean correctness = answer.checkAnswer(_num);

		if (correctness) {
			Image image = new Image(getClass().getClassLoader().getResource("resources/correct.png").toString(), true);
			_correctnessImage.setImage(image);

			//checking if the recording has been acquired
			if (_recCounter.getCounter() == 1) {
				_scoreCounter.increaseCounter();
			}

			//gaining the string values and setting them to the textfields
			//to show the player
			String s = answer.getPLayerAnswer();
			_playerAnswer.setText(s);

			String correct = answer.getAnswer();
			_correctAnswer.setText(correct);

		} else {
			//setting the wrong icon if the answer is incorrect
			Image image = new Image(getClass().getClassLoader().getResource("resources/wrong.png").toString(), true);

			_correctnessImage.setImage(image);
			String s = answer.getPLayerAnswer();
			_playerAnswer.setText(s);

			//if the player is stuck on the same frame 3 times then it shall
			//show the correct answer
			if (_recCounter.getCounter() == 3) {
				//get the correct answer
				String correct = answer.getAnswer();
				_correctAnswer.setText(correct);
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
		//lock the buttons
		lockAllBtns();

		//swing Worker methods
		waitCursor();
		PlayWorker playWorker = new PlayWorker();
		Thread thread = new Thread(playWorker);
		thread.start();

	}

	//setter methods

	/**
	 * this method sets the level which is used to set the text based on the
	 * easy (1-10) and hard (11 - 99)
	 * @param level
	 */
	public void setLevel(Level level) {
		_level = level;

		//generating the number to set to the label
		//_num = level.generateNumber();
		//_label.setText(Integer.toString(_num));
		setEquation(level);

	}
	
	/**
	 * This is to set the correct number and the label of the image
	 */
	private void setEquation(Level level) {
		Arithmatic arith=new Arithmatic();
		String formula=level.generateFormula();
		while(arith.isOutOfBound(formula)) {
			formula=level.generateFormula();
		}
		_label.setText(formula);
		_num=arith.formulaToNumber(formula);
	}

	/**
	 * setting the MainApp.
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp){
		_mainApp=mainApp;
		normaliseCursor();
	}

	/**
	 * setting the player
	 * @param player
	 */
	public void setPlayer(Player player) {
		_player=player;
	}
	
	
	//idea we can use the popOver in the tutorial frame which i shall
	//implement after getting the gameFrameController done
	
	//need to be refactored -> split the to another method

	/**
	 * using the popOver which is from the controls fx library which basically
	 * gives a pop up message plan to use for the tutorial screen
	 */



	/**
	 * this is method which which carries out the FadeTransition by taking the
	 * parameter of Popover
	 */
	public void fadeTransitionPopOver(PopOver popover) {

		FadeTransition fade = new FadeTransition(Duration.seconds(1.0), popover.getRoot());
		fade.setFromValue(1);
		fade.setToValue(0);
		fade.setOnFinished(e->popover.hide());
		fade.play();
	}


	/**
	 * this method releases all the buttons
	 */
	public void releaseAllBtns() {

		//disable all buttons
		_playBtn.setDisable(false);
		_reBtn.setDisable(false);
		_submitBtn.setDisable(false);
		_backBtn.setDisable(false);
	}

	/**
	 * this method locks all the buttons
	 */
	public void lockAllBtns() {

		//lock every button
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

		//setting the buttons to disabled state
		_playBtn.setDisable(true);
		_submitBtn.setDisable(true);
		_nextButton.setDisable(true);
	}
	
	//a method to change the cursor to wait state

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


	
	//a method to change the cursor to normal state

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

					//check for a Recording
					Answer answer = new Answer();
					answer.checkAnswer(_num);

					if (answer.getPLayerAnswer().isEmpty()) {
						Notifications.create()
								.text("no voice detected, Please try Again")
								.position(Pos.CENTER)
								.hideAfter(Duration.seconds(1))
								.showWarning();
					}






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

			Platform.runLater(new Runnable() {
				@Override
				public void run() {

					//make this for doing other methods
					normaliseCursor();
					releaseAllBtns();


				}
			});


		}
		
		
	}

}
