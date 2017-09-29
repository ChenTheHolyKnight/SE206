package assignment.model;

import java.util.Random;
public class HardLevel implements Level{
	
	//This is a field to indicate its hard level
	private Levels _levelStrs=Levels.HARD;
	
	/**
	 * This is a method to generate number from 1 to 99
	 */
	@Override
	public int generateNumber() {
		Random rand =new Random();
		return rand.nextInt(99)+1;
	}
	
	/**
	 * This is a method to get the level indicator
	 */
	@Override
	public Levels getLevels() {
		return _levelStrs;
	}

}
