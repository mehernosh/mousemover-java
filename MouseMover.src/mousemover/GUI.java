package mousemover;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GUI {
	private JFrame frame;
	private JLabel label1;

	public GUI() {
		this.frame = new JFrame("MouseMover");
		this.label1 = new JLabel();

		this.frame.add(this.label1);

		String imagepathinit = new String("src" + File.pathSeparator
				+ "icontarget");
		Image im1 = Toolkit.getDefaultToolkit().createImage(
				imagepathinit + "5.jpg");
		Image im2 = Toolkit.getDefaultToolkit().createImage(
				imagepathinit + "10.jpg");
		Image im3 = Toolkit.getDefaultToolkit().createImage(
				imagepathinit + "20.jpg");
		Image im4 = Toolkit.getDefaultToolkit().createImage(
				imagepathinit + "50.jpg");
		List<Image> imagelist = new ArrayList<Image>();
		imagelist.add(im1);
		imagelist.add(im2);
		imagelist.add(im3);
		imagelist.add(im4);

		this.frame.setSize(240, 60);
		this.frame.setResizable(false);
		this.frame.setDefaultCloseOperation(3);
		this.frame.setVisible(true);
		this.frame.setLocationRelativeTo(null);

		this.frame.setIconImages(imagelist);
	}

	public void setText(String text) {
		this.label1.setText(text);
		try {
			Thread.sleep(4000L);
		} catch (InterruptedException e) {
		}
		this.label1.setText("");
	}

	public int getMin() throws NumberFormatException {
		String minute = JOptionPane
				.showInputDialog("Input the inteval in minutes:\n(@copyleft all wrongs reserved)");
		return Integer.decode(minute).intValue();
	}
}
