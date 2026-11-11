import java.awt.Container;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

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
	Image img = (new ImageIcon(Utility.class.getClassLoader().getResource("bilder/" + strBild))).getImage();
	img = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	tracker.addImage(img, 0);
	try {
	  tracker.waitForID(0);
	} catch (InterruptedException ex) {
	  System.out.println("Can not load image: " + strBild);
	}
	return img;
  }

  public static Clip loadAudioClip(String strAudioDatei) {
//		http://www.ntu.edu.sg/home/ehchua/programming/java/J8c_PlayingSound.html
	Clip clip = null;

	try {
	  URL url = Utility.class.getClassLoader().getResource("audio/" + strAudioDatei);
	  AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
	  clip = AudioSystem.getClip();
	  clip.open(audioIn);
	} catch (UnsupportedAudioFileException e) {
	  e.printStackTrace();
	} catch (IOException e) {
	  e.printStackTrace();
	} catch (LineUnavailableException e) {
	  e.printStackTrace();
	}

	return clip;
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
