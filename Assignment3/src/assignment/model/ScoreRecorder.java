package assignment.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ScoreRecorder {
	private List<Integer> _record=new ArrayList<Integer>();
	
	private ScoreRecorder() {
		
	}
	
	public void recordScore(Score score) {
		_record.add(score.getScore());
		Collections.sort(_record);
		if(_record.size()>10) {
			_record.remove(0);
		}
	}
	
	public static ScoreRecorder getInstance() {
		return new ScoreRecorder();
	}
	
	public void displayRecord() {
		System.out.println(_record);
	}
	
}
