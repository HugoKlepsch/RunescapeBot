package humanSim;

import java.awt.Point;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Capture extends Thread{
	BufferedWriter outStream;
	MouseMover mouseMover;
	long currentTime;
	long endTime;
	int refreshTime;
	public Capture(String filename, MouseMover mouseMover, int refreshTime){
		this.mouseMover = mouseMover;
		currentTime = System.currentTimeMillis();
		endTime = currentTime + refreshTime;
		this.refreshTime = refreshTime;
		
		try {
			outStream = new BufferedWriter(new FileWriter(filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run(){
		currentTime = System.currentTimeMillis();
		endTime = currentTime + refreshTime;
		while (2 > 1) {
			writePoint();
			try {
				Thread.sleep((long) (refreshTime * 0.9));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			busyWait(endTime);
		}
	}
	
	private void busyWait(long endTime){
		while(System.currentTimeMillis() < endTime){
			
		}
	}
	
	private void writePoint(){
		Point currentPoint = mouseMover.getPointerPos();
		try {
			outStream.write(currentTime + " " + currentPoint.getX() + " " + currentPoint.getY() + "0" + "\n");
			outStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(currentTime);
		
		
	}
}
