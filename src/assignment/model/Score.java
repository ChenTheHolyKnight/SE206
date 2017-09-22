package assignment.model;

import java.util.Arrays;

public class Score {
	private int _score;
	public int getScore() {
		return _score;
	}
	public void calculateScore(int[] Scores) {
		_score=Arrays.stream(Scores).sum();
	}
}
