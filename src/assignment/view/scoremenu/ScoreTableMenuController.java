package assignment.view.scoremenu;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

import javafx.collections.FXCollections;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
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

	@FXML
	private BarChart<String, Integer> barChart;

	//this the x axis of the code
	@FXML
	private CategoryAxis xAxis;

	//observable list for all the dates that the player has played
	private ObservableList<String> startDates = FXCollections.observableArrayList();

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

		//I grabbed all the months since i couldn't really grab all the start times
		String[] months = DateFormatSymbols.getInstance(Locale.ENGLISH).getMonths();

		//convert the array into a list to add all the months to the observable list of months
		startDates.addAll(Arrays.asList(months));

	}

	@FXML
	/**
	 * Sets the player that is shown for the graph
	 */
	public void setPlayerData(ArrayList players) {
		//make a counter for the months
		int[] monthCounter = new int[12];

		//iterate across each player and check the start dates for each of the players we check for that particular date
		//then thats the date that the player played the game and it shows the players
		//score corresponding the dates that had been played at

		//having trouble getting the date and core values out the classes since the table has the property methods but
		//i have been trying heaps to get the values but i can't get anything

		//NEEEED HEEELLP


		




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
	}

	@FXML
	public void handleHardButton() {
		_b2.setSelected(true);
		setTables(Levels.HARD);
	}

	@FXML
	public void handleArcade() {
		_b3.setSelected(true);
		setTables(Levels.CUSTOMIZE);
	}

	
	private void setTables(Levels level) {
		_rounds=_player.getRounds(level);
		_table.setItems(null);
		_table.setItems(_rounds);
	}

	public void setMainApp(MainApp mainApp) {
		_mainApp=mainApp;
	}
}
