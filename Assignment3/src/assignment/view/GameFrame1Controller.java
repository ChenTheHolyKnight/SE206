package assignment.view;

import assignment.MainApp;
import assignment.model.EasyLevel;
import assignment.model.Level;
import javafx.fxml.FXML;
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
		Image image=new Image(getClass().getClassLoader().getResource("resources/Maori.png").toString());
		_imageView.setImage(image);
		Level level=new EasyLevel();  //this is just for experiment further changes needs to be done on that 
		int num=level.generateNumber();		
		_label.setText(Integer.toString(num));
	}
	
	@FXML
	public void handleBackButton() {
		_mainApp.showLevelLayout();
	}
	
	@FXML
	public void handleRecordButton() {
		//need to use Task to make record button functional.
	}
	
	
	
	
	
	
	public void setMainApp(MainApp mainApp) {
		_mainApp=mainApp;
	}
}
