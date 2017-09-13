package assignment.util;



public class NumImage {
	private String _text;
	
	public NumImage(String text) {
		_text=text;
	}
	public void createImage() {
		//System.out.println(getClass().getClassLoader().getResource("/resources/tutorial1.jpg").toString());
		String cmd="convert src/resources/tutorial1.jpg -gravity center -fill \"#ff0080\"  -pointsize 10  label:"+"'"+_text+"'"+" output.png";
		ProcessBuilder pb=new ProcessBuilder("bash","-c",cmd);
		try {
			Process process=pb.start();
			int exitValue=process.waitFor();
			if(exitValue==0) {
				process.destroy();
			}else {
				System.out.println("PENIS");
				process.destroy();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
