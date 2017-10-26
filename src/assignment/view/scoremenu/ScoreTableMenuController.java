package assignment.view.scoremenu;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

import javafx.collections.FXCollections;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import org.controlsfx.control.SegmentedButton;

import assignment.MainApp;
import assignment.model.Round;
import assignment.model.PlayerRecorder;
import assignment.model.Score;
import assignment.model.Attempts;
import assignment.model.Level.Levels;
import assignment.model.Player;
import assignment.view.Controller;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;

public class ScoreTableMenuController extends Controller{



	private ObservableList<Player> _recorder=PlayerRecorder.getInstance();
	private MainApp _mainApp;

	private Player _player;
	
	private ObservableList<Round> _rounds;

	@FXML
	private TableView<Round> _table;
	@FXML
	private TableColumn<Round,String> _startTimeColumn;
	@FXML
	private TableColumn<Round,String> _scoreColumn;
	@FXML
	private TableColumn<Round,String> _attemptsColumn;
	@FXML
	private TableColumn<Round,String> _timeColumn;
	@FXML
	private SegmentedButton _segmentedButton;

	@FXML
	private ToggleButton _b1 ;
	@FXML
	private ToggleButton _b2;
	@FXML
	private ToggleButton _b3;

	@FXML
	private ComboBox<String> _nameSelection;

	@FXML
	private Pane _pane;

	@FXML
	private  BarChart<String,Number> _barChart;

	
	
	
	
	@FXML
	public void initialize() {
		_pane.setOpacity(0);
		makeFadeIn(_pane);

		_segmentedButton.getButtons().addAll(_b1,_b2,_b3);
		_b1.setDisable(true);
		_b2.setDisable(true);
		_b3.setDisable(true);

		
		ArrayList<String> names=new ArrayList<String>();
		for(Player player: _recorder) {
			names.add(player.getName());
		}
	
		_nameSelection.getItems().addAll(names);

		_startTimeColumn.setCellValueFactory(cellData->cellData.getValue().getStartTimeProperty());
		_scoreColumn.setCellValueFactory(cellData-> cellData.getValue().getScoreProperty());
		_attemptsColumn.setCellValueFactory(cellData-> cellData.getValue().getAttemptProperty());
		_timeColumn.setCellValueFactory(cellDate->cellDate.getValue().getTimeProperty());

	}


	@FXML
	public void handleSelectedItem() {
		
		_b1.setDisable(false);
		_b2.setDisable(false);
		_b3.setDisable(false);
		String name=_nameSelection.getSelectionModel().getSelectedItem();
		for(Player player:_recorder) {
			if(player.getName().equals(name)) {
				_player=player;
			}
		}
		
		

	}

	@FXML
	public void backAction() {
		makeFadeOut(_pane,null,null,_mainApp,ControllerType.MAINMENU);
	}

	@FXML
	public void handleEasyButton() {
		_b1.setSelected(true);
		setTables(Levels.EASY);
		setBarChart(Levels.EASY);
	}

	@FXML
	public void handleHardButton() {
		_b2.setSelected(true);
		setTables(Levels.HARD);
		setBarChart(Levels.HARD);
	}

	@FXML
	public void handleArcade() {
		_b3.setSelected(true);
		setTables(Levels.CUSTOMIZE);
		setBarChart(Levels.CUSTOMIZE);
	}

	@FXML
	public void handleLeaderBoard(){
		makeFadeOut(_pane,null,null,_mainApp,ControllerType.LEADERBORAD);
	}

	@FXML
	public void handleReward(){
		makeFadeOut(_pane,null,null,_mainApp,ControllerType.AWARD);
	}


	
	private void setTables(Levels level) {
		_rounds=_player.getRounds(level);
		_table.setItems(null);
		_table.setItems(_rounds);
	}


	private void setBarChart(Levels level){
		BarChart.Series<String,Number> series=new BarChart.Series();
		series.setName(_player.getName());
		ObservableList<Round> rounds=_player.getRounds(level);
		for(Round round:rounds){
			series.getData().add(new BarChart.Data<>(round.getTime().getStart(), round.getScore()));
		}
		_barChart.getData().clear();
		_barChart.setAnimated(false);
		_barChart.getData().add(series);

	}

	public void setMainApp(MainApp mainApp) {
		_mainApp=mainApp;
	}
}
