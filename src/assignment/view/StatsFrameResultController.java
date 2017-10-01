package assignment.view;

import assignment.MainApp;
import assignment.model.Level;
import assignment.model.Player;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class StatsFrameResultController {

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

    private Level _level;

    @FXML
    public void initialize() {
        _rootPane.setOpacity(0);
        makeFadeIn();


    }

    @FXML
    public void handleBackButton() {
        makeFadeOutBack();
    }

    @FXML
    public void handlePlayAgainButton() {
        makeFadeOutPlayAgain();

    }

    public void setPlayer(Player player) {
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

    /**
     * this is the Fade In transition for the frame
     */
    public void makeFadeIn() {

        FadeTransition fadeout = new FadeTransition();
        fadeout.setDuration(Duration.millis(750));
        fadeout.setNode(_rootPane);
        fadeout.setFromValue(0.0);
        fadeout.setToValue(1.0);
        fadeout.play();

    }

    public void makeFadeOutPlayAgain() {

        FadeTransition fadeout = new FadeTransition();
        fadeout.setDuration(Duration.millis(750));
        fadeout.setNode(_rootPane);
        fadeout.setFromValue(1.0);
        fadeout.setToValue(0.0);
        fadeout.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                _mainApp.showGameFrame(_players.getLevel(), _players);
            }
        });
        fadeout.play();
    }

    public void makeFadeOutBack() {

        FadeTransition fadeout = new FadeTransition();
        fadeout.setDuration(Duration.millis(750));
        fadeout.setNode(_rootPane);
        fadeout.setFromValue(1.0);
        fadeout.setToValue(0.0);
        fadeout.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                _mainApp.initMainFrame();
            }
        });
        fadeout.play();


    }






}
