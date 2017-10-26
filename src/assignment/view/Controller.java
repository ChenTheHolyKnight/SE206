package assignment.view;


import assignment.MainApp;
import assignment.model.Player;
import assignment.model.Round;
import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.util.Duration;

import java.awt.event.WindowEvent;

abstract public class Controller {

	public enum ControllerType{
		MAINMENU,USERNAME,LEVEL,TUTORIAL,GAME,STATS,ARCADE, LEADERBORAD, AWARD, SCORE
	}







	protected long _fadeTime=250;
 
	/**
	 * This is to fade in the frame 
	 */
	protected void makeFadeIn(Node rootPane) {
		FadeTransition fadeout = new FadeTransition();
		fadeout.setDuration(Duration.millis(_fadeTime));
		fadeout.setNode(rootPane);
		fadeout.setFromValue(0.0);
		fadeout.setToValue(1.0);
		fadeout.play();
	}
	
	/**
	 * This is to fade out the frame 
	 */
	protected void makeFadeOut(Node rootPane,Player players,Round round,MainApp mainApp,ControllerType type) {
		FadeTransition fadeout = new FadeTransition();
		fadeout.setDuration(Duration.millis(_fadeTime));
		fadeout.setNode(rootPane);
		fadeout.setFromValue(1.0);
		fadeout.setToValue(0.0);

		if(type==ControllerType.MAINMENU) {
			fadeout.setOnFinished(event->mainApp.initMainFrame());
		}
		if(type==ControllerType.USERNAME) {
			fadeout.setOnFinished(event->mainApp.showUserNameFrame());
		}
		if(type==ControllerType.LEVEL) {
			fadeout.setOnFinished(event->mainApp.showLevelLayout(players));
		}
		if(type==ControllerType.TUTORIAL) {
			fadeout.setOnFinished(event->mainApp.showTutorialFrame(round, players));
		}
		if(type==ControllerType.GAME) {
			fadeout.setOnFinished(event->mainApp.showGameFrame(players,round));
		}
		if(type==ControllerType.STATS) {
			fadeout.setOnFinished(event->mainApp.showGameFrame(players,round));
		}
		if(type==ControllerType.ARCADE) {
			fadeout.setOnFinished(event->mainApp.showCustomizeGameFrame(round,players));
		}
		if(type==ControllerType.LEADERBORAD) {
			fadeout.setOnFinished(event -> mainApp.showLeaderBoardFrame());
		}
		if(type==ControllerType.SCORE){
			fadeout.setOnFinished(event -> mainApp.showScoreFrame());
		}
		if(type==ControllerType.AWARD){
			fadeout.setOnFinished(event -> mainApp.showRewardFrame());
		}


		fadeout.play();
	}






}
