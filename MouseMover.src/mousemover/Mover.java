package mousemover;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.PrintStream;
import javax.swing.JOptionPane;

public class Mover extends Robot {
	private GUI gui;
	private int min;

	private Mover() throws AWTException {
		this.gui = new GUI();
		this.min = 1;
	}

	public static Mover instantiate() {
		Mover mouse = null;
		try {
			mouse = new Mover();
		} catch (AWTException e) {
			System.err.println("Cannot create Robot Object!, Try Again");
		}
		return mouse;
	}

	public void run() {
		int min = 3;
		boolean legalNum = false;
		while (!legalNum) {
			try {
				min = this.gui.getMin();
				legalNum = true;
			} catch (NumberFormatException e) {
				this.gui.setText("Enter a legal Number!");
			} catch (NullPointerException e) {
				int option = JOptionPane.showConfirmDialog(null,
						"Do you want to quit?");
				if (option == 0) {
					return;
				}
			}
		}

		this.min = min;

		this.gui.setText("App Running");
		this.gui.setText("Windows may be minimised!");
		while (true) {
			mouseWheel(1);
			mouseWheel(-1);
			try {
				Thread.sleep(min * 1000);
			} catch (InterruptedException e) {
				this.gui.setText("Cannot make the thread sleep!");
			}
		}
	}
}
