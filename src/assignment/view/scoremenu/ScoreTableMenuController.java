package assignment.view.scoremenu;

import org.controlsfx.control.SegmentedButton;

import assignment.MainApp;
import assignment.model.Player;
import assignment.model.PlayerRecorder;
import assignment.model.Score;
import assignment.view.Controller;
import javafx.beans.property.IntegerProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;

public class ScoreTableMenuController extends Controller{
	private ObservableList<Player> _recorder=PlayerRecorder.getInstance();
	private MainApp _mainApp;
	
	
	

	@FXML
	private TableView<Score> _table;
	@FXML
	private TableColumn<Player,String> _nameColumn;
	@FXML
	private TableColumn<Score,String> _scoreColumn;
	@FXML
	private TableColumn<Player,String> _attemptsColumn;
	@FXML
	private SegmentedButton _segmentedButton;
	
	@FXML
	private ToggleButton _b1 ;
	@FXML
	private ToggleButton _b2;
	@FXML
	private ToggleButton _b3;

	@FXML
	private Pane _pane;

	@FXML
	public void initialize() {
		
		_pane.setOpacity(0);
        makeFadeIn(_pane);
       // _nameColumn.setCellValueFactory(cellData-> cellData.getValue().getNameProperty());
       // _scoreColumn.setCellValueFactory(cellData-> cellData.getValue().getScoreProperty());
       // _attemptsColumn.setCellValueFactory(cellData-> cellData.getValue().getAttemptProperty());
        
        _segmentedButton.getButtons().addAll(_b1,_b2,_b3);
        
        
        //This is for testing
        	Player player=new Player();
        	player.setName("a");
        	player.setScore(10);
        	player.setScore(12);
        	ObservableList<Score> scores=player.getScoreRecord();
        	_scoreColumn.setCellValueFactory(cellData-> cellData.getValue().getScoreProperty());
        	_table.setItems(scores);
        	
        	
	}

	@FXML
	public void backAction() {
		//_mainApp.initMainFrame();
		makeFadeOut(_pane,null,_mainApp,ControllerType.MAINMENU);
	}
	
	@FXML
	public void handleEasyButton() {
		_b1.setSelected(true);
		
	}
	
	@FXML
	public void handleHardButton() {
		_b2.setSelected(true);
	}
	
	@FXML
	public void handleArcade() {
		_b3.setSelected(true);
	}



	public void setMainApp(MainApp mainApp) {
		_mainApp=mainApp;
		//_table.setItems(_recorder);
	}
}
