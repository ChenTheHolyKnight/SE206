package assignment.view;

import assignment.MainApp;
import assignment.model.EasyLevel;
import assignment.model.HardLevel;
import assignment.model.Level;
import assignment.model.Player;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * this is the controller for the Level Layout Frame
 */
public class LevelLayoutFrameController {

    //intializing the private variables required
    private MainApp _mainapp;
    private Level _level;
    private Player _player;

    @FXML
    private Pane _pane;


    public void initialize() {
        _pane.setOpacity(0);
        makeFadeIn();


    }



    /**
     * this is the action for the back button which returns user to the nameframe
     */
    @FXML
    public void backButtonAction() {
        //calling the userName frame
        makeFadeOutUserName();

    }

    /**
     * This is the action button for the user when they click the easy button which is to go to
     * game frame which starts the easy game
     */
    @FXML
    public void easyButtonAction() {
        //set the level to easy
        _level = new EasyLevel();

        //show the corresponding game frame
        makeFadeOutGameFrame();
    }

    /**
     * This is the Action button for the user to handle the hard button which moves the user to the
     * gameframe which consitutes the hardmode.
     */
    public void hardButtonAction() {
        //set the level to hard
        _level = new HardLevel();

        makeFadeOutGameFrame();
    }

    /**
     * this is the tutorial button which moves the player to the tutorial frame which is a sort
     * of an unlimited game which has popovers everytime
     */
    public void tutorialButtonAction() {

        _level = new EasyLevel();

        makeFadeOutTutorial();

    }

    //here are some getter and setter methods
    public Level getLevel() {
        return _level;
    }

    public void setMainApp(MainApp mainapp) {
        _mainapp = mainapp;
    }

    public void setPlayer(Player player) {
        _player = player;
    }

    /**
     * this is the fade in transition for the pane to add a sort of aesthetic effect
     */
    public void makeFadeIn() {

        FadeTransition fadeout = new FadeTransition();
        fadeout.setDuration(Duration.millis(750));
        fadeout.setNode(_pane);
        fadeout.setFromValue(0.0);
        fadeout.setToValue(1.0);
        fadeout.play();


    }


    /**
     * this are the fade in and fade out methods for the aesthetics
     */
    public void makeFadeOutUserName() {

        FadeTransition fadeout = new FadeTransition();
        fadeout.setDuration(Duration.millis(750));
        fadeout.setNode(_pane);
        fadeout.setFromValue(1.0);
        fadeout.setToValue(0.0);
        fadeout.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                _mainapp.showUserNameFrame();
            }
        });
        fadeout.play();

    }

    public void makeFadeOutGameFrame() {

        FadeTransition fadeout = new FadeTransition();
        fadeout.setDuration(Duration.millis(750));
        fadeout.setNode(_pane);
        fadeout.setFromValue(1.0);
        fadeout.setToValue(0.0);
        fadeout.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                _mainapp.showGameFrame(_level, _player);
            }
        });
        fadeout.play();



    }

    public void makeFadeOutTutorial() {

        FadeTransition fadeout = new FadeTransition();
        fadeout.setDuration(Duration.millis(750));
        fadeout.setNode(_pane);
        fadeout.setFromValue(1.0);
        fadeout.setToValue(0.0);
        fadeout.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                _mainapp.showTutorialFrame(_level, _player);
            }
        });
        fadeout.play();

    }








}
