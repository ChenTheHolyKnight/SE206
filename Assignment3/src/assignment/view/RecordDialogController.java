package assignment.view;


import assignment.util.Recorder;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.stage.Stage;

public class RecordDialogController {
	
	private Stage _dialogStage;
	
	public void setMainApp(Stage dialog) {
		_dialogStage=dialog;
	}
	
	@FXML
	public void handleRedo() {
		DoWork dowork=new DoWork();
		Thread thread=new Thread(dowork);
		thread.start();
		
	}
	
	@FXML
	public void handlePlay() {
		Recorder recorder=new Recorder();
		recorder.playRecord();
	}
	
	
	
	
	class DoWork extends Task<Void>{

		@Override
		protected Void call() throws Exception {
			System.out.println("start");
			//Thread.sleep(3000);
			_dialogStage.getScene().setCursor(Cursor.WAIT);
			Recorder recorder=new Recorder();
			recorder.record();		
			recorder.recordToWord();	
			//recorder.deleteRecord();
			System.out.println("finish");
			
			
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

}
