package assignment.view;

import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 * this is a controller for the simple exit dialog which is prompted when a user exits
 * the game system asking if they are sure they want to exit
 */
public class ExitFrameController {


    //private variable
    private Stage _dialogStage;

    /**
     * the method when the ok button is pressed which quits the entire application
     */
    @FXML
    public void okController() {

        //exit the application
        System.exit(0);
    }

    /**
     * the method when the cancel button is pressed which just quits the dialog
     */
    public void cancelController() {

        //exit the dialog
        _dialogStage.close();

    }

    /**
     * set the stage of setMainApp to that of the dialog
     */
    public void setMainApp(Stage stage) {

        _dialogStage = stage;

    }










}
