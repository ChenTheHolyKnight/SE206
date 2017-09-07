package assignment.view;

import java.util.ArrayList;
import java.util.List;

import assignment.MainApp;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TutorialFrameController {
	private MainApp _mainApp;
	private List<String> _imagePaths=new ArrayList<String>();
	
	@FXML
	private ImageView _imageView;
	
	public TutorialFrameController() {
		loadImages();
	}
	
	public void setMainApp(MainApp mainApp) {
		_mainApp=mainApp;
	}
	
	
	@FXML
	public void handleBackToMainMenu() {
		_mainApp.initMainFrame();
	}
	
	
	@FXML
	public void handleContinue() {		
		int counter=_mainApp.getCounter();	
		if(counter<1) {
			_mainApp.increaseCounter();
			Image image=new Image(_imagePaths.get(_mainApp.getCounter()),true);
			_imageView.setImage(image);		
		}	
	}
	
	@FXML
	public void handleBack() {
		int counter=_mainApp.getCounter();
		if(counter>0) {
			_mainApp.decreaseCounter();
			Image image=new Image(_imagePaths.get(_mainApp.getCounter()),true);
			_imageView.setImage(image);			
		}		
	}
	
	private void loadImages() {
		_imagePaths.add(getClass().getClassLoader().getResource("resources/tutorial1.jpg").toString());
		_imagePaths.add(getClass().getClassLoader().getResource("resources/tutorial2.jpg").toString());
		
	}
	
	public ImageView getImageView() {
		return _imageView;
		
	}
}
