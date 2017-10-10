package assignment.view.scoremenu;

import assignment.MainApp;
import assignment.model.Player;
import assignment.model.PlayerRecorder;
import assignment.view.Controller;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

public class ScoreTableMenuController extends Controller{
	private ObservableList<Player> _recorder=PlayerRecorder.getInstance();
	private MainApp _mainApp;

	@FXML
	private TableView<Player> _table;
	@FXML
	private TableColumn<Player,String> _nameColumn;
	@FXML
	private TableColumn<Player,String> _scoreColumn;
	@FXML
	private TableColumn<Player,String> _attemptsColumn;

	@FXML
	private Pane _pane;

	@FXML
	public void initialize() {
		
		_pane.setOpacity(0);
        makeFadeIn(_pane);
        _nameColumn.setCellValueFactory(cellData-> cellData.getValue().getNameProperty());
        _scoreColumn.setCellValueFactory(cellData-> cellData.getValue().getScoreProperty());
        _attemptsColumn.setCellValueFactory(cellData-> cellData.getValue().getAttemptProperty());
	}

	@FXML
	public void backAction() {
		//_mainApp.initMainFrame();
		makeFadeOut(_pane,null,_mainApp,ControllerType.MAINMENU);
	}



	public void setMainApp(MainApp mainApp) {
		_mainApp=mainApp;
		_table.setItems(_recorder);
	}
}
