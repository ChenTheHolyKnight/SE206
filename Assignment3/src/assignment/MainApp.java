package assignment;

import java.io.IOException;

import assignment.view.DeletionDialogController;
import assignment.view.LevelLayoutController;
import assignment.view.MainFrameController;
import assignment.view.TutorialFrameController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application{
	private Stage _primaryStage;
	private BorderPane _rootLayout;
	private int _counter=0;

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
			Image image=new Image(getClass().getClassLoader().getResource("resources/tutorial1.jpg").toString());
			controller.getImageView().setImage(image);

		} catch (IOException e) {
			e.printStackTrace();

		}
	}
	/**
	 * This is a method to increase the counter when the continue button in the tutorial frame is clicked
	 */
	public void increaseCounter(){
		if(_counter<2) {
			_counter++;
		}
		if(_counter>2) {
			_counter=2;
		}
	}	

	/**
	 * This is a method to decrease the counter when the back button in the tutorial frame is clicked
	 */
	public void decreaseCounter() {
		if(_counter>0) {
			_counter--;
		}
		if(_counter<0) {
			_counter=0;
		}
	}

	/**
	 * This is a method to get the counter
	 */
	public int getCounter() {
		return _counter;
	}



	public static void main(String[] args) {
		launch();
	}

}
