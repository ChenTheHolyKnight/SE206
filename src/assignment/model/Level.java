package assignment.model;

public interface Level {
	/**
	 * This is an enum to indicate the levels type
	 */
	public enum Levels{
		EASY,HARD
	}
	
	/**
	 * method corresponding for generating a random number in each level
	 */
	public int generateNumber();
	
	/**
	 * This is the method to get the enum indicator
	 */
	public Levels getLevels() ;
}
