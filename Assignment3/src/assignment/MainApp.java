package assignment;

import java.io.IOException;


import assignment.view.ExitDialogController;
import assignment.view.GameFrame1Controller;
import assignment.view.LevelLayoutController;
import assignment.view.MainFrameController;
import assignment.view.RecordDialogController;
import assignment.view.ScoreMenuController;
import assignment.view.TutorialFrameController;
import assignment.view.UserNameSceneController;
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
		_primaryStage.setTitle("Tatai");
		_primaryStage.setResizable(false);

		initMainFrame();

	}
	public void initMainFrame() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("view/MainFrame.fxml"));
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
			loader.setLocation(getClass().getResource("view/ExitDialog.fxml"));
			AnchorPane anchorPane=(AnchorPane) loader.load();

			Stage dialog=new Stage();
			dialog.setTitle("Deletion Dialog");
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(_primaryStage);

			Scene scene = new Scene(anchorPane);
			dialog.setScene(scene);

			ExitDialogController deletion =loader.getController();
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
			loader.setLocation(getClass().getResource("view/UserNameScene.fxml"));
			AnchorPane anchorPane= (AnchorPane) loader.load();
			Scene scene=new Scene(anchorPane);
			_primaryStage.setScene(scene);
			_primaryStage.show();
			UserNameSceneController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//Level Layout
	public void showLevelLayout() {
		try {
			FXMLLoader loader =new FXMLLoader();
			loader.setLocation(getClass().getResource("view/LevelLayout.fxml"));
			AnchorPane anchorPane = (AnchorPane) loader.load();

			Scene scene=new Scene(anchorPane);
			_primaryStage.setScene(scene);
			_primaryStage.show();
			LevelLayoutController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();

		}

	}
	//GameFrame1
	public void showGameFrame1(int num) {
		try {
			FXMLLoader loader =new FXMLLoader();
			loader.setLocation(getClass().getResource("view/GameFrame1.fxml"));
			AnchorPane anchorPane = (AnchorPane) loader.load();

			Scene scene=new Scene(anchorPane);
			_primaryStage.setScene(scene);
			_primaryStage.show();
			GameFrame1Controller controller = loader.getController();
			controller.setMainApp(this);
			controller.setLabel(num);

		} catch (IOException e) {
			e.printStackTrace();

		}

	}
	
	//Record Dialog
	public void showRecordDialog() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("view/RecordDialog.fxml"));
			AnchorPane anchorPane=(AnchorPane) loader.load();

			Stage dialog=new Stage();
			dialog.setTitle("Deletion Dialog");
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(_primaryStage);

			Scene scene = new Scene(anchorPane);
			dialog.setScene(scene);

			RecordDialogController record =loader.getController();
			record.setMainApp(dialog);

			dialog.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	//Tutorial frame

	public void showTutorialFrame() {
		try {
			FXMLLoader loader =new FXMLLoader();
			loader.setLocation(getClass().getResource("view/TutorialFrame.fxml"));
			AnchorPane anchorPane = (AnchorPane) loader.load();

			Scene scene=new Scene(anchorPane);
			_primaryStage.setScene(scene);
			_primaryStage.show();
			TutorialFrameController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();

		}
	}
	
		


	//Score frame
	public void showScoreFrame() {
		try {
			FXMLLoader loader =new FXMLLoader();
			loader.setLocation(getClass().getResource("view/ScoreMenu.fxml"));
			AnchorPane anchorPane = (AnchorPane) loader.load();

			Scene scene=new Scene(anchorPane);
			_primaryStage.setScene(scene);
			_primaryStage.show();
			ScoreMenuController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();

		}
	}
	
	

	public static void main(String[] args) {
		launch();
	}

}
