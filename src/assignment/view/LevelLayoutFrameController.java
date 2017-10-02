package assignment.view;

import assignment.MainApp;
import assignment.model.EasyLevel;
import assignment.model.HardLevel;
import assignment.model.Level;
import assignment.model.Player;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;


/**
 * this is the controller for the Level Layout Frame
 */
public class LevelLayoutFrameController extends Controller{

    //intializing the private variables required
    private MainApp _mainapp;
    private Level _level;
    private Player _player;

    @FXML
    private Pane _pane;


    public void initialize() {
        _pane.setOpacity(0);
        makeFadeIn(_pane);

    }



    /**
     * this is the action for the back button which returns user to the nameframe
     */
    @FXML
    public void backButtonAction() {
        //calling the userName frame
    	makeFadeOut(_pane,_player,_mainapp,ControllerType.USERNAME);
    }

    /**
     * This is the action button for the user when they click the easy button which is to go to
     * game frame which starts the easy game
     */
    @FXML
    public void easyButtonAction() {
        //set the level to easy
        _level = new EasyLevel();
        //set the level that the player chose
        _player.setLevel(_level);
        //show the corresponding game frame
        makeFadeOut(_pane,_player,_mainapp,ControllerType.GAME);
    }

    /**
     * This is the Action button for the user to handle the hard button which moves the user to the
     * gameframe which consitutes the hardmode.
     */
    public void hardButtonAction() {
        //set the level to hard
        _level = new HardLevel();
        //set the level that the player chose
        _player.setLevel(_level);
        makeFadeOut(_pane,_player,_mainapp,ControllerType.GAME);
    }

    /**
     * this is the tutorial button which moves the player to the tutorial frame which is a sort
     * of an unlimited game which has popovers everytime
     */
    public void tutorialButtonAction() {

        _level = new EasyLevel();
        
        //set the level that the player chose
        _player.setLevel(_level);

        makeFadeOut(_pane,_player,_mainapp,ControllerType.TUTORIAL);
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
