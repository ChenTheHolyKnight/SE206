package assignment.view;

import com.jfoenix.controls.JFXButton;

import assignment.MainApp;
import assignment.model.Level.Levels;
import assignment.model.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class StatsFrameController {

	@FXML
	private TableView<Player> _playerTable;

	@FXML
	private TableColumn<Player,String> _nameColumn;
	
	@FXML
	private TableColumn<Player,String> _scoreColumn;
	
	@FXML
	private TableColumn<Player,String> _attemptsColumn;

	@FXML
	private ObservableList<Player> _players=FXCollections.observableArrayList();
	
	@FXML
	private JFXButton _button;

	private MainApp _mainApp;

	@FXML
	public void initialize() {
		_nameColumn.setCellValueFactory(cellData->cellData.getValue().getNameProperty());
		_scoreColumn.setCellValueFactory(cellData->cellData.getValue().getScoreProperty());
		_attemptsColumn.setCellValueFactory(cellData->cellData.getValue().getAttemptProperty());
		
	}
	
	@FXML
	public void handleBackButton() {
		_mainApp.initMainFrame();
	}
	
	@FXML
	public void handleStayButton() {
		_mainApp.showGameFrame(_players.get(0).getLevel(), _players.get(0));;
	}

	public void setPlayer(Player player) {
		_players.add(player);
		if(player.getLevel().getLevels().equals(Levels.HARD)) {
				_button.setDisable(true);
				_button.setOpacity(0);			
		}else if(player.getScore()<8) {
				_button.setDisable(true);
		}
	}
	
	public void setMainApp(MainApp mainApp) {
		_mainApp=mainApp;
		_playerTable.setItems(_players);
	}
}
