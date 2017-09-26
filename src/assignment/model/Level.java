package assignment.model;

public interface Level {

	public enum Levels{
		EASY,HARD
	}
	
	public int generateNumber();
	public Levels getLevels() ;
}
