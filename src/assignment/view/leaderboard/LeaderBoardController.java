package assignment.view.leaderboard;

import assignment.MainApp;
import assignment.model.Level;
import assignment.model.Player;
import assignment.model.PlayerRecorder;
import assignment.view.Controller;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class LeaderBoardController extends Controller{

    @FXML private Pane _pane;
    @FXML private ComboBox<String> _nameSelection;
    @FXML private ComboBox<String> _levelSelection;
    @FXML private JFXTextField _textField;
    private MainApp _mainApp;
    private ObservableList<Player> _recorder= PlayerRecorder.getInstance();
    private Player _player;


    @FXML
    public void initialize(){
        makeFadeIn(_pane);

        ArrayList<String> names=new ArrayList<String>();
        for(Player player: _recorder) {
            names.add(player.getName());
        }
        _nameSelection.getItems().addAll(names);

        _levelSelection.getItems().addAll("Easy","Hard","Arcade");
        _levelSelection.setDisable(true);
    }
    @FXML
    public void handleBackButton(){
        makeFadeOut(_pane,null,null,_mainApp,ControllerType.SCORE);
    }
    
    @FXML
    public void handleNameSelection(){
        _levelSelection.setDisable(false);
        String name=_nameSelection.getSelectionModel().getSelectedItem();
        for(Player player:_recorder) {
            if(player.getName().equals(name)) {
                _player=player;
            }
        }
    }

    @FXML
    public void handleLevelSelection(){
        String level=_levelSelection.getSelectionModel().getSelectedItem();
        int num=0;
        if(_player!=null){
            if(level.equals("Easy")){
                num=_player.getHighestScore(Level.Levels.EASY);
            }
            if(level.equals("Hard")){
                num=_player.getHighestScore(Level.Levels.HARD);
            }
            if(level.equals("Arcade")){
                num=_player.getHighestScore(Level.Levels.CUSTOMIZE);
            }
            _textField.setText(Integer.toString(num));
        }
    }

    public void setMainApp(MainApp mainApp) {
        _mainApp = mainApp;
    }
}
