package assignment.view;

import assignment.MainApp;
import assignment.model.Level;
import assignment.model.Player;
import assignment.model.PlayerRecorder;

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

    @FXML
    private Player _players;

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
        makeFadeOut(null,null,_mainApp,ControllerType.MAINMENU);
    }

    @FXML
    public void handlePlayAgainButton() {
        makeFadeOut(_rootPane,_players,_mainApp,ControllerType.GAME);

    }

    public void setPlayer(Player player) {
    	ObservableList<Player> recorder=PlayerRecorder.getInstance();
    	recorder.add(player);
        _players = player;
        _playerName.setText(_players.getName());
        _scoreResult.setText(Integer.toString(_players.getScore()));
        _attempts.setText(Integer.toString(_players.getAttempts()));
        if(player.getLevel().getLevels().equals(Level.Levels.HARD)) {
            _button.setDisable(true);
            _button.setOpacity(0);
        }else if(player.getScore()<8) {
            _button.setDisable(true);
        }
    }

    public void setMainApp(MainApp mainApp) {
        _mainApp=mainApp;

    }







}
