package assignment.model;

import java.util.Random;
public class HardLevel implements Level{

	private Levels _levelStrs=Levels.HARD;
	@Override
	public int generateNumber() {
		Random rand =new Random();
		return rand.nextInt(90)+10;
	}

	@Override
	public Levels getLevels() {
		return _levelStrs;
	}

}
