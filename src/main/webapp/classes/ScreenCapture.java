import java.awt.image.DataBufferByte;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;

public class ScreenCapture{

	DirectRobot robot;
	BufferedImage image;

	public ScreenCapture(){

		GraphicsDevice[] devices = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
		for(GraphicsDevice device : devices) {
			try {
				robot = new DirectRobot(device);
			} catch (AWTException e) {
				continue;
			}
		}
	}

	public void captureScreen(){
		image = java.security.AccessController.doPrivileged(
				new java.security.PrivilegedAction<BufferedImage>() {
				public BufferedImage run() {
				return robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
				}
				});

	}

	public BufferedImage getScreenShot(){
		
		return this.image;
	}
}
