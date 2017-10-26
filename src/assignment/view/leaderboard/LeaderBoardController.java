package assignment.view.leaderboard;

import assignment.MainApp;
import assignment.view.Controller;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class LeaderBoardController extends Controller{

    @FXML private Pane _pane;
    private MainApp _mainApp;


    @FXML
    public void initialize(){
        makeFadeIn(_pane);
    }
    @FXML
    public void handleBackButton(){
        makeFadeOut(_pane,null,null,_mainApp,ControllerType.SCORE);
    }

    public void setMainApp(MainApp mainApp) {
        _mainApp = mainApp;
    }
}
