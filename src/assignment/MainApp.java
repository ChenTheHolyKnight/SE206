package assignment;

import java.io.IOException;

import assignment.model.Level;
import assignment.model.Player;
import assignment.view.customizegameframe.CustomizeGameFrameController;
import assignment.view.exitdialog.ExitFrameController;
import assignment.view.gameframe.GameFrameController;
import assignment.view.levellayout.LevelLayoutFrameController;
import assignment.view.mainframe.MainFrameController;
import assignment.view.scoremenu.ScoreTableMenuController;
import assignment.view.statsresult.StatsFrameResultController;
import assignment.view.tutorial.TutFrameController;
import assignment.view.username.UserNameFrameController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application{
	private Stage _primaryStage;
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		_primaryStage=primaryStage;
		_primaryStage.setTitle("Tātai");
		_primaryStage.setResizable(false);

		initMainFrame();

	}
	public void initMainFrame() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("view/mainframe/MainFrame2.fxml"));
			AnchorPane anchorPane=(AnchorPane) loader.load();
			Scene scene=new Scene(anchorPane);
			_primaryStage.setScene(scene);
			_primaryStage.show();
			MainFrameController controller=loader.getController();
			controller.setMainApp(this);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void showExitDialog() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("view/exitdialog/ExitDialog.fxml"));
			AnchorPane anchorPane=(AnchorPane) loader.load();

			Stage dialog=new Stage();
			dialog.setTitle("Deletion Dialog");
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(_primaryStage);
			dialog.setResizable(false);

			Scene scene = new Scene(anchorPane);
			dialog.setScene(scene);

			ExitFrameController deletion =loader.getController();
			deletion.setMainApp(dialog);

			dialog.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Enter name frame
	public void showUserNameFrame() {

		try {
			FXMLLoader loader =new FXMLLoader();
			loader.setLocation(getClass().getResource("view/username/UserNameFrame.fxml"));
			AnchorPane anchorPane= (AnchorPane) loader.load();
			Scene scene=new Scene(anchorPane);
			_primaryStage.setScene(scene);
			_primaryStage.show();
			UserNameFrameController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	//Level Layout
	public void showLevelLayout(Player player) {
		try {
			FXMLLoader loader =new FXMLLoader();
			loader.setLocation(getClass().getResource("view/levellayout/LevelLayoutFrame.fxml"));
			AnchorPane anchorPane = (AnchorPane) loader.load();

			Scene scene=new Scene(anchorPane);
			_primaryStage.setScene(scene);
			_primaryStage.show();
			LevelLayoutFrameController controller = loader.getController();
			controller.setMainApp(this);
			controller.setPlayer(player);

		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	//Show GameFrame
	public void showGameFrame(Level level,Player player) {
		try {
		
			FXMLLoader loader =new FXMLLoader();
			loader.setLocation(getClass().getResource("view/gameframe/GameFrame2.fxml"));
			AnchorPane anchorPane = (AnchorPane) loader.load();

			Scene scene=new Scene(anchorPane);
			_primaryStage.setScene(scene);
			_primaryStage.show();
			GameFrameController controller = loader.getController();
			controller.setMainApp(this);
			controller.setLevel(level);
			controller.setPlayer(player);
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Show Stats Frame
	public void showStatsFrame(Player player) {
		try {
			
			FXMLLoader loader =new FXMLLoader();
			loader.setLocation(getClass().getResource("view/statsresult/StatsResultsFrame.fxml"));
			AnchorPane anchorPane = (AnchorPane) loader.load();

			Scene scene=new Scene(anchorPane);
			_primaryStage.setScene(scene);
			_primaryStage.show();
			StatsFrameResultController controller = loader.getController();
			controller.setPlayer(player);
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	//Tutorial frame

	public void showTutorialFrame(Level level, Player player) {
		try {

			FXMLLoader loader =new FXMLLoader();
			loader.setLocation(getClass().getResource("view/tutorial/TutFrame.fxml"));
			AnchorPane anchorPane = (AnchorPane) loader.load();

			Scene scene=new Scene(anchorPane);
			_primaryStage.setScene(scene);
			_primaryStage.show();
			TutFrameController controller = loader.getController();
			controller.setMainApp(this);
			controller.setLevel(level);
			controller.setPlayer(player);


		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Customize game Frame
	public void showCustomizeGameFrame(Player player) {
		try {

			FXMLLoader loader =new FXMLLoader();
			loader.setLocation(getClass().getResource("view/customizegameframe/CustomizeGameFrame.fxml"));
			AnchorPane anchorPane = (AnchorPane) loader.load();

			Scene scene=new Scene(anchorPane);
			_primaryStage.setScene(scene);
			_primaryStage.show();
			CustomizeGameFrameController controller = loader.getController();
			controller.setMainApp(this);
			controller.setPlayer(player);


		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
		


	//Score frame
	public void showScoreFrame() {
		try {
			FXMLLoader loader =new FXMLLoader();
			loader.setLocation(getClass().getResource("view/scoremenu/ScoreTableMenu.fxml"));
			AnchorPane anchorPane = (AnchorPane) loader.load();

			Scene scene=new Scene(anchorPane);
			_primaryStage.setScene(scene);
			_primaryStage.show();
			ScoreTableMenuController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();

		}
	}
	
	
	
	//get the PrimaryStage
	public Stage getPrimaryStage() {
		return _primaryStage;
	}

	public static void main(String[] args) {
		launch();
	}

}
