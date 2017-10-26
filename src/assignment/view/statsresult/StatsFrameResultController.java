package assignment.view.statsresult;

import assignment.MainApp;
import assignment.model.Level;
import assignment.model.Player;
import assignment.model.Round;
import assignment.model.PlayerRecorder;
import assignment.view.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;


public class StatsFrameResultController extends Controller{

    @FXML
    private Pane _rootPane;

    @FXML
    private JFXTextField _playerName;

    @FXML
    private JFXTextField _scoreResult;

    @FXML
    private JFXTextField _attempts;


    private Round _rounds;
    
    private Player _player;

    @FXML
    private JFXButton _button;

    private MainApp _mainApp;


    @FXML
    public void initialize() {
        _rootPane.setOpacity(0);
        makeFadeIn(_rootPane);

    }

    @FXML
    public void handleBackButton() {
        makeFadeOut(null,null,null,_mainApp,ControllerType.MAINMENU);
    }

    @FXML
    public void handlePlayAgainButton() {
        Level.Levels levels=_rounds.getLevel().getLevels();
        Round round=new Round();
        round.setLevel(_rounds.getLevel());
        makeFadeOut(_rootPane, _player, round, _mainApp, ControllerType.GAME);
    }

    public void setPlayer(Player player) {
    	//Find repeated item and delete it in the observable list
    	ObservableList<Player> rec=PlayerRecorder.getInstance();
    	Player player2=new Player();
    	for(Player player1:rec) {
    		if(player1.getName().equals(player.getName())) {
    			player2=player1;
    		}
    	}
    	rec.remove(player2);
    	rec.add(player);
    	
        _player = player;
        _player.addRound(_rounds);
        _playerName.setText(_player.getName());
        _scoreResult.setText(Integer.toString(_rounds.getScore()));
        _attempts.setText(Integer.toString(_rounds.getAttempts()));
        if(_rounds.getLevel().getLevels().equals(Level.Levels.HARD)) {
            _button.setDisable(true);
            _button.setOpacity(0);
        }else if(_rounds.getScore()<8) {
            _button.setDisable(true);
        }
    }

    public void setMainApp(MainApp mainApp) {
        _mainApp=mainApp;

    }
    
    public void setRound(Round round) {
    	_rounds=round;
        _rounds.getTime().end();
    }







}
