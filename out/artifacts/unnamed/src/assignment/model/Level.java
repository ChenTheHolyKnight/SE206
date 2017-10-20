package assignment.model;

public interface Level {
	/**
	 * An enum that indicates the level
	 */
	public enum Levels{
		EASY,HARD,CUSTOMIZE
	}


	//List the methods that will be overriden by its children
	public int generateNumber();
	public Levels getLevels();
	public String generateFormula();

	
}
