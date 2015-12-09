package humanSim;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RobotReader {
	BufferedReader inStream;
	MouseMover mouse;
	public static final int COMMAND_MOVEMOUSE = 1;
	public static final int COMMAND_WAIT = 2;
	public static final int COMMAND_CLICK = 3;
	public static final int COMMAND_CLICK_BACKPACK = 4;
	
	
	public RobotReader(MouseMover mouse, String filename){
		this.mouse = mouse;
		
		try {
			inStream = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * lines starting with // are not executed
	 * format is 
	 */
	public void execute(){
		String line = "69";
		String[] words;
		do {
			try {
				line = inStream.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (!(line.substring(0, 2).equals("//"))){
				words = line.split(" ");
				switch (Integer.parseInt(words[0])){
					case RobotReader.COMMAND_MOVEMOUSE:
						mouse.moveMouse(Integer.parseInt(words[1]), Integer.parseInt(words[2]));
						break;
					case RobotReader.COMMAND_WAIT:
						preciceWait(Long.parseLong(words[1]));
						break;
					case RobotReader.COMMAND_CLICK:
						mouse.mouseClick();
						break;
					default:
						System.err.println("Command parse failed");
						System.err.println("line error: \n\t" + line);
						break;
				}
				
			}
		} while(line != null);
		
	}
	
	
	
	/**
	 * Sleeps very precicely the time given
	 * @param endtime
	 */
	public static void preciceWait(long duration){
		long currentTime = System.currentTimeMillis();
		long endtime = currentTime + duration;
		try {
			Thread.sleep((long) ((endtime - currentTime) * 0.9));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(System.currentTimeMillis() < endtime){
			
		}
	}
	
	
	public void changeFile(String filename){
		try {
			inStream = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
