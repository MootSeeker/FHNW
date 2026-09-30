import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class Utility {

	private static Container p = new Container();

	public static Image loadImage(String strBild) {
		MediaTracker tracker = new MediaTracker(p);
		Image img = (new ImageIcon(strBild)).getImage();
		tracker.addImage(img, 0);
		try {
			tracker.waitForID(0);
		} catch (InterruptedException ex) {
			System.out.println("Can not load image: " + strBild);
		}
		return img;
	}

	public static Image loadResourceImage(String strBild) {
		MediaTracker tracker = new MediaTracker(p);
		Image img = (new ImageIcon(Utility.class.getClassLoader().getResource("bilder/" + strBild))).getImage();
		tracker.addImage(img, 0);
		try {
			tracker.waitForID(0);
		} catch (InterruptedException ex) {
			System.out.println("Can not load image: " + strBild);
		}
		return img;
	}

	public static ImageIcon loadResourceIcon(String strBild) {
		ImageIcon icon = new ImageIcon(Utility.class.getClassLoader().getResource("bilder/" + strBild));
		return icon;
	}

	public static Image loadResourceImage(String strBild, int width, int height) {
		MediaTracker tracker = new MediaTracker(p);
		Image img = (new ImageIcon(Utility.class.getClassLoader().getResource("bilder/"
				+ strBild))).getImage();
		img = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		tracker.addImage(img, 0);
		try {
			tracker.waitForID(0);
		} catch (InterruptedException ex) {
			System.out.println("Can not load image: " + strBild);
		}
		return img;
	}

	public static Cursor getInvisibleCursor() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		return toolkit.createCustomCursor(image, new Point(0, 0), "img");
	}

	public static Cursor getDefaultCursor() {
		return Cursor.getDefaultCursor();
	}
}
