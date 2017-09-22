package assignment.model;

public class LevelFactory {
	public enum LevelOption{
		EASY,HARD
	}
	
	public Level getLevel(LevelOption option) {
		if(option==LevelOption.EASY) {
			return new EasyLevel();
		}else if(option==LevelOption.HARD) {
			return new HardLevel();
		}
		
		return null;
		
	}
}
