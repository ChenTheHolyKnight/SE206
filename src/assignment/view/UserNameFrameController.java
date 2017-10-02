package assignment.view;

import assignment.MainApp;
import assignment.model.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class UserNameFrameController extends Controller{

    //have to initialize private variables that have to be used
    @FXML
    private Button _button;

    @FXML
    private TextField _textfield;

    //the mainapp and the player classes
    private MainApp _mainapp;

    private Player _player;

    @FXML
    private Pane _pane;

    //setting the MainApp to what is given
    public void setMainApp(MainApp mainapp) {

        _mainapp = mainapp;

    }

    /**
     * we are going to initalize the user to have the continue button to disabled initially unless the player
     * types something into the text field which shall result in the button being able to send through into
     * the player class
     */
    @FXML
    public void initialize() {
        //setting the pane to not be present
        _pane.setOpacity(0);
        makeFadeIn(_pane);

        //here we set the button to disabled and then we initialize a player object
        _button.setDisable(true);
        _player = new Player();

    }



    @FXML
    public void handleButton() {
        //we need to check for the textfield input , therefore such that if there is no input which is
        //parsed then we make sure that the button has been disabled
        if ((_textfield.getText() != null) && (!_textfield.getText().equals(""))) {
            //set the button disable to false that means the button is now on
            _button.setDisable(false);
            //sets the text that is inputted into the field as the name of the player
            _player.setName(_textfield.getText());

            makeFadeOut(_pane,_player,_mainapp,ControllerType.LEVEL);

        }
    }

    @FXML
    public void BackButtonControl() {
        //fades out to the main menu frame
    	makeFadeOut(_pane,null,_mainapp,ControllerType.MAINMENU);
    }

    @FXML
    public void setButtonReleased() {
        //this is the string of the text
        String text = _textfield.getText();

        //we can have a boolean to check whether any text or anything has been inputted
        boolean isDisabled=text.isEmpty() || text.trim().isEmpty();

        //we can base the handling of the button on the boolean value
        _button.setDisable(isDisabled);

    }

    public String getName() {
        //we can get the name value from the textvalue which is attained
        return _textfield.getText();
    }

}
