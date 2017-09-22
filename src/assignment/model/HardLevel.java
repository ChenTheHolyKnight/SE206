package assignment.model;

import java.util.Random;
public class HardLevel implements Level{

	@Override
	public int generateNumber() {
		Random rand =new Random();
		return rand.nextInt(90)+10;
	}

}
