package assignment.model;

import java.util.Random;

public class EasyLevel implements Level{
	
	//This is a field to store the indicator of this level
	private Levels _levelStr=Levels.EASY;

	
	/**
	 * This is a method to generate a number from 1 to 10
	 */
	@Override
	public int generateNumber() {
		Random rand =new Random();
		return rand.nextInt(9)+1;
	}
	
	/**
	 * This is a method to get the level indicator
	 */
	@Override
	public Levels getLevels() {		
		return _levelStr;
	}

}
