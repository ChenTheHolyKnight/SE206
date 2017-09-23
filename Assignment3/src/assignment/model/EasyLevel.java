package assignment.model;

import java.util.Random;

public class EasyLevel implements Level{
	
	private Levels _levelStr=Levels.EASY;

	@Override
	public int generateNumber() {
		Random rand =new Random();
		return rand.nextInt(9)+1;
	}

	@Override
	public Levels getLevels() {
		
		return _levelStr;
	}

}
