
package testing;

import humanSim.Capture;
import humanSim.MouseMover;

public class TestingMain {

	public static void main(String[] args) {
		MouseMover mouseMover = new MouseMover();
		Capture capDev = new Capture("Capture.txt", mouseMover, 100);
		capDev.start();
		
	}

}

