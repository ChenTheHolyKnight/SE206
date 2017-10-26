package assignment.view.rewardframe;

import assignment.MainApp;
import assignment.model.Level;
import assignment.model.Player;
import assignment.model.PlayerRecorder;
import assignment.view.Controller;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


import java.util.ArrayList;

public class RewardController extends Controller{
    private MainApp _mainApp;
    private ObservableList<Player> _recorder= PlayerRecorder.getInstance();
    private Player _player;

    @FXML private Pane _pane;
    @FXML private ComboBox<String> _nameSelection;
    @FXML private ImageView _imageView;

    @FXML
    public void initialize(){
        ArrayList<String> names=new ArrayList<String>();
        for(Player player: _recorder) {
            names.add(player.getName());
        }
        _nameSelection.getItems().addAll(names);
        Image image = new Image(getClass().getClassLoader().getResource("resources/question.png").toString());
        _imageView.setImage(image);

    }

    @FXML
    public void handleBack(){
        makeFadeOut(_pane,null,null,_mainApp,ControllerType.SCORE);
    }

    @FXML
    public  void handleSelectedItem(){
        String name=_nameSelection.getSelectionModel().getSelectedItem();
        for(Player player:_recorder) {
            if(player.getName().equals(name)) {
                _player=player;
            }
        }

       int num= _player.getHighestScore(Level.Levels.HARD);
        if(num==10){
            Image image = new Image(getClass().getClassLoader().getResource("resources/trophy.jpeg").toString());
            _imageView.setImage(image);
        }
    }



    public void setMainApp(MainApp mainApp) {
        _mainApp = mainApp;
    }
}
