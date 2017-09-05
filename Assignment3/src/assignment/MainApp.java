package assignment;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application{
	private Stage _primaryStage;
	private BorderPane _rootLayout;
	@Override
	public void start(Stage primaryStage) throws Exception {
		_primaryStage=primaryStage;
		_primaryStage.setTitle("Tatai");

		initRootLayout();
		initMainFrame();
	}
	private void initMainFrame() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("view/MainFrame.fxml"));
			AnchorPane anchorPane=(AnchorPane) loader.load();
			
			_rootLayout.setCenter(anchorPane);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void initRootLayout() {	
		try {
			FXMLLoader loader =new FXMLLoader();
			loader.setLocation(getClass().getResource("view/RootLayout.fxml"));
			_rootLayout = (BorderPane) loader.load();
			
			Scene scene=new Scene(_rootLayout);
			_primaryStage.setScene(scene);
			_primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	public static void main(String[] args) {
		launch();
	}

}
