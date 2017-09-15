package assignment.view;

import assignment.MainApp;
import assignment.util.Recorder;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameFrame1Controller {
	private MainApp _mainApp;
	
	
	@FXML
	private ImageView _imageView;
	
	@FXML
	private Label _label;
	
	@FXML
	public void initialize() {
		//System.out.println(getClass().getClassLoader().getResource("resources/tutorial1.jpg").toString());
		Image image=new Image(getClass().getClassLoader().getResource("resources/Maori.jpg").toString());
		_imageView.setImage(image);
		 //this is just for experiment further changes needs to be done on that 

	}
	
	@FXML
	public void handleBackButton() {
		_mainApp.showLevelLayout();
	}
	
	@FXML
	public void handleRecordButton() {
		//need to use Task to make record button functional.
		//_mainApp.showRecordDialog();
		DoWork dowork=new DoWork();
		Thread thread=new Thread(dowork);
		thread.start();
	}
	
	
	
	public void setLabel(int num) {
		_label.setText(Integer.toString(num));
	}
	
	
	public void setMainApp(MainApp mainApp) {
		_mainApp=mainApp;
	}
	
	
	
	
	
	class DoWork extends Task<Void>{

		@Override
		protected Void call() throws Exception {
			System.out.println("start");
			_mainApp.getPrimaryStage().getScene().setCursor(Cursor.WAIT);
			Recorder recorder=new Recorder();
			recorder.record();		
			recorder.recordToWord();			
			System.out.println("finish");
			
			
			return null;
			
			
		}
		
		@Override
		protected void done() {
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						_mainApp.getPrimaryStage().getScene().setCursor(Cursor.DEFAULT);
						_mainApp.showRecordDialog();
						
					}
					
				});
			
		}
		
	}
	
	
	
	
	
}
