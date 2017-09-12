package assignment.util;

public class Counter {
	
	private int _counter=0;
	
	/**
	 * This is a method to increase the counter when the continue button in the tutorial frame is clicked
	 */
	public void increaseCounter(){
		if(_counter<2) {
			_counter++;
		}
		if(_counter>2) {
			_counter=2;
		}
	}	

	/**
	 * This is a method to decrease the counter when the back button in the tutorial frame is clicked
	 */
	public void decreaseCounter() {
		if(_counter>0) {
			_counter--;
		}
		if(_counter<0) {
			_counter=0;
		}
	}

	/**
	 * This is a method to get the counter
	 */
	public int getCounter() {
		return _counter;
	}
}
