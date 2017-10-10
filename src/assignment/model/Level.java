package assignment.model;

public interface Level {

	public enum Levels{
		EASY,HARD,CUSTOMIZE
	}
	
	public int generateNumber();
	public Levels getLevels();
	public String generateFormula();

	
}
