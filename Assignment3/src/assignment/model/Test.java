package assignment.model;

import assignment.model.LevelFactory.LevelOption;

public class Test {
	public static void main(String[] args) {
		LevelFactory factory=new LevelFactory();
		Level level=factory.getLevel(LevelOption.HARD);
		for(int i=0;i<10;i++) {
			System.out.println(level.generateNumber());
		}
	}
}
