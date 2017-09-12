package assignment.view;

import java.util.ArrayList;
import java.util.List;

import assignment.util.Counter;
import assignment.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TutorialFrameController {
	private MainApp _mainApp;
	private List<String> _imagePaths=new ArrayList<String>();
	private Counter _counter=new Counter();
	@FXML
	private ImageView _imageView;
	
	@FXML
	private Button _backButton;
	
	@FXML
	public void initialize() {
		loadImages();
		Image image=new Image(getClass().getClassLoader().getResource("resources/tutorial1.jpg").toString());
		_imageView.setImage(image);
		_backButton.setDisable(true);
	}
	
	
	
	
	@FXML
	public void handleBackToMainMenu() {
		_mainApp.initMainFrame();
	}
	
	
	@FXML
	public void handleContinue() {		
		int counter=_counter.getCounter();	
		if(counter<1) {
			_counter.increaseCounter();
			Image image=new Image(_imagePaths.get(_counter.getCounter()),true);
			_imageView.setImage(image);		
		}	
	}
	
	@FXML
	public void handleBack() {
		int counter=_counter.getCounter();
		if(counter>0) {
			_counter.decreaseCounter();
			Image image=new Image(_imagePaths.get(_counter.getCounter()),true);
			_imageView.setImage(image);			
		}		
	}
	
	@FXML
	public void setKeyRealseReaction() {
		//need to implement 
		if(_counter.getCounter()>0) {
			//System.out.println("enable");
			_backButton.setDisable(false);
		}else {
			_backButton.setDisable(true);
		}
		
		
	}
	
	
	public void setMainApp(MainApp mainApp) {
		_mainApp=mainApp;
	}
	
	private void loadImages() {
		_imagePaths.add(getClass().getClassLoader().getResource("resources/tutorial1.jpg").toString());
		_imagePaths.add(getClass().getClassLoader().getResource("resources/tutorial2.jpg").toString());
		
	}
	
}
