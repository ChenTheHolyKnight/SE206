package assignment.model;

import assignment.model.LevelFactory.LevelOption;

public class Test {
	public static void main(String[] args) {
		int[] nums= {1,1,2,3,0};
		Score score=new Score();
		score.calculateScore(nums);
		//System.out.println(score.getScore());


		ScoreRecorder scoreRecorder=ScoreRecorder.getInstance();
		for(int i=0;i<10;i++) {
			scoreRecorder.recordScore(score);
		}

		int[] nums2= {0};
		score.calculateScore(nums2);
		scoreRecorder.displayRecord();
		scoreRecorder.recordScore(score);
		scoreRecorder.displayRecord();
	}
}
