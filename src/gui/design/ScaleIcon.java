package gui.design;

import gui.MFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * We read the file as an image first, and scale it using
 * the getScaledInstance method, and construct an icon
 * with the scaled version, which then can be used with a label.
 */
public class ScaleIcon {
	
	public static void main(String[] args) throws IOException {
		File file = new File(System.getProperty("user.home")+File.separator+
				"Pictures"+ File.separator+"selfie.jpg");
		Image image = ImageIO.read(file);
		image = image.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon(image));

		MFrame.display("Scale Image", label);
	}

}
