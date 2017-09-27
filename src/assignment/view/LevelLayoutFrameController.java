package assignment.view;

import assignment.MainApp;
import assignment.model.EasyLevel;
import assignment.model.HardLevel;
import assignment.model.Level;
import assignment.model.Player;
import javafx.fxml.FXML;

/**
 * this is the controller for the Level Layout Frame
 */
public class LevelLayoutFrameController {

    //intializing the private variables required
    private MainApp _mainapp;
    private Level _level;
    private Player _player;


    /**
     * this is the action for the back button which returns user to the nameframe
     */
    @FXML
    public void backButtonAction() {
        //calling the userName frame
        _mainapp.showUserNameFrame();

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
        _mainapp.showGameFrame(_level, _player);
    }

    /**
     * This is the Action button for the user to handle the hard button which moves the user to the
     * gameframe which consitutes the hardmode.
     */
    public void hardButtonAction() {
        //set the level to hard
        _level = new HardLevel();

        _mainapp.showGameFrame(_level, _player);
    }

    public void tutorialButtonAction() {

        /**
         * shall show the tutorial frame when it is clicked in demonstrating how to play the
         * game
         */

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

}
