package assignment.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import assignment.model.Player;
import javafx.collections.ObservableList;

public class TableWritter {
	public void saveTable(ObservableList<Player> players) {
		try {
			BufferedWriter out=new BufferedWriter(new FileWriter(new File("list.txt")));
			for(Player player:players) {
				//outwritter
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
