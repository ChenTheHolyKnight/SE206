package assignment.view;

import assignment.MainApp;
import assignment.model.Level;
import assignment.util.Recorder;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class GameFrame1Controller {
	private MainApp _mainApp;
	private Level _level;
	@FXML
	private Button _reBtn;
	
	@FXML
	private ImageView _imageView;
	
	@FXML
	private Label _label;
	
	@FXML
	private AnchorPane _anchorPane;
	
	@FXML
	public void initialize() {
		
		Image image=new Image(getClass().getClassLoader().getResource("resources/Maori.jpg").toString());
		_imageView.setImage(image);
	 

	}
	
	@FXML
	public void handleBackButton() {
		_mainApp.showLevelLayout();
	}
	
	@FXML
	public void handleRecordButton() {
		//need to use Task to make record button functional.
		
		DoWork dowork=new DoWork();
		Thread thread=new Thread(dowork);
		thread.start();
	}
	
	@FXML
	public void recordButtonClicked() {
		_mainApp.getPrimaryStage().getScene().setCursor(Cursor.WAIT);
		_anchorPane.setCursor(Cursor.WAIT);
	}
	
	
	
	
	public void setLabel(int num) {
		_label.setText(Integer.toString(num));
	}
	
	public void setLevel(Level level) {
		_level=level;
	}
	
	
	public void setMainApp(MainApp mainApp) {
		_mainApp=mainApp;
	}
	
	
	
	
	
	class DoWork extends Task<Void>{

		@Override
		protected Void call() throws Exception {
			//System.out.println("start");
			_reBtn.setDisable(true);
			Recorder recorder=new Recorder();
			recorder.record();		
			recorder.recordToWord();
			//recorder.deleteRecord();
			//System.out.println("finish");
			
			
			return null;
			
			
		}
		
		@Override
		protected void done() {
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						_mainApp.showRecordDialog(Integer.parseInt(_label.getText()),_level);
						_mainApp.getPrimaryStage().getScene().setCursor(Cursor.DEFAULT);
						_anchorPane.setCursor(Cursor.DEFAULT);
						_reBtn.setDisable(false);
					}
					
				});
			
		}
		
	}
	
	
	
	
	
}
