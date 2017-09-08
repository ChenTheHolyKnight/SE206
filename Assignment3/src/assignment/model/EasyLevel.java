package assignment.model;

import java.util.Random;

public class EasyLevel implements Level{

	@Override
	public int generateNumber() {
		Random rand =new Random();
		return rand.nextInt(9)+1;
	}

}
