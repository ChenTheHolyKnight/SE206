package assignment;

import java.io.IOException;

import assignment.view.DeletionDialogController;
import assignment.view.LevelLayoutController;
import assignment.view.MainFrameController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application{
	private Stage _primaryStage;
	private BorderPane _rootLayout;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		_primaryStage=primaryStage;
		_primaryStage.setTitle("Tatai");

		
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
			loader.setLocation(getClass().getResource("view/DeletionDialog.fxml"));
			AnchorPane anchorPane=(AnchorPane) loader.load();
			
			Stage dialog=new Stage();
			dialog.setTitle("Deletion Dialog");
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(_primaryStage);
			
			Scene scene = new Scene(anchorPane);
			dialog.setScene(scene);
			
			DeletionDialogController deletion =loader.getController();
			deletion.setMainApp(dialog);
			
			dialog.showAndWait();
			
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
	
	
	
	
	public static void main(String[] args) {
		launch();
	}

}
