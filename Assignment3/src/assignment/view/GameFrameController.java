package assignment.view;


import assignment.model.Level;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class GameFrameController {
	
	@FXML
	private Pane _Pane;
	@FXML
	private ImageView _imageView;
	@FXML
	private ImageView _imageView1;
	
	@FXML
	private Button _nextButton;
	
	@FXML
	private Label _label;
	
	private Level _level;
	
	@FXML
	public void initialize() {
		Image image=new Image(getClass().getClassLoader().getResource("resources/Maori.jpg").toString());
		_imageView.setImage(image);
		//_imageView1.setImage(image);

	}
	
	@FXML
	public void handleNextButton() {
		_nextButton.setDisable(true);
		WritableImage image=_Pane.snapshot(new SnapshotParameters(),null);
		_imageView1.setImage(image);
		_imageView1.toFront();
		int num=_level.generateNumber();
		_label.setText(Integer.toString(num));
		TranslateTransition transition=new TranslateTransition(Duration.millis(500),_imageView1);
		transition.setByX(-350f);
		transition.setFromX(0);
		transition.setOnFinished(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				_imageView1.setImage(null);
				_nextButton.setDisable(false);
				transition.stop();
			}
			
		});
		transition.playFromStart();		
	}
	
	public void setLevel(Level level) {
		_level=level;
	}
	
	
}
