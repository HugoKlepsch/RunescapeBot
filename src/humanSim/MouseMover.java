package humanSim;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class MouseMover {
	Robot robot;
	public MouseMover(){
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void moveMouse(int x, int y){
		
	}
	
	private double distance(Point p1, Point p2){
		int deltaX = (int) (p2.getX() - p1.getX());
		int deltaY = (int) (p2.getY() - p1.getY());
		return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
	}
	
	private double deltaX(Point p1, Point p2){
		return p2.getX() - p1.getX();
	}
	private double deltaY(Point p1, Point p2){
		return p2.getY() - p1.getY();
	}
	
	public Point getPointerPos(){
		return MouseInfo.getPointerInfo().getLocation();
	}
	
	public void mouseClick(){
		robot.mousePress(InputEvent.BUTTON1_MASK);
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}

}
