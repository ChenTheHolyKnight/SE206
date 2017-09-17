package assignment.view;


import assignment.MainApp;
import assignment.model.Level;
import assignment.util.Recorder;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.stage.Stage;

public class RecordDialogController {
	
	private Stage _dialogStage;
	private MainApp _mainApp;
	private int _num=0;
	private Level _level;
	
	public void setDialog(Stage dialog) {
		_dialogStage=dialog;
	}
	
	@FXML
	public void handleRedo() {
		Record dowork=new Record();
		Thread thread=new Thread(dowork);
		thread.start();
		
	}
	
	@FXML
	public void handlePlay() {
		//Recorder recorder=new Recorder();
		//recorder.playRecord();
		Play play=new Play();
		Thread thread=new Thread(play);
		thread.start();
	}
	
	
	@FXML
	public void hanleSubmit() {
		//todo: read the output file when button is clicked 
		//show the correctness frame
		_mainApp.showGameFrame2(_num,_level);
		_dialogStage.close();
	}
	
	public void setNum(int num) {
		_num=num;
	}
	
	public void setLevel(Level level) {
		_level=level;
	}
	
	public void setMainApp(MainApp mainApp) {
		_mainApp=mainApp;
	}
	
	
	class Record extends Task<Void>{

		@Override
		protected Void call() throws Exception {
			//System.out.println("start");
			//Thread.sleep(3000);
			_dialogStage.getScene().setCursor(Cursor.WAIT);
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
						_dialogStage.getScene().setCursor(Cursor.DEFAULT);
					}
					
				});
			
		}
		
	}
	
	class Play extends Task<Void>{

		@Override
		protected Void call() throws Exception {
			Recorder recorder = new Recorder();
			//System.out.println("play");
			recorder.playRecord();
			return null;
		}
		
	}

}
