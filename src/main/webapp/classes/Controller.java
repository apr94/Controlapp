import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JApplet;

public class Controller extends JApplet
{

	private static final long serialVersionUID = -159138669294000631L;

	Robot robot;
	ScreenCapture sc;
	Dimension offDimension;
	Image offImage;
	Graphics offGraphics;

	public Controller(){

		sc = new ScreenCapture();

		try {
			robot = new Robot();
		} catch (AWTException e) {

			System.out.println(e.getStackTrace());
		}

	}

	public void moveMouse(int x, int y){
		robot.mouseMove(x, y);
	}

	public void captureScreen(){
		
		sc.captureScreen();
		this.repaint();

	}


	public void update(Graphics paramGraphics)
	{
		Dimension localDimension = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());

		if ((this.offGraphics == null) || 
				(localDimension.width != this.offDimension.width) || 
				(localDimension.height != this.offDimension.height)) {
			this.offDimension = localDimension;
			this.offImage = createImage(localDimension.width, localDimension.height);
			this.offGraphics = this.offImage.getGraphics();
		}

		this.offGraphics.drawImage(sc.getScreenShot(), 0, 0, null);

		BufferedImage resized = new BufferedImage(this.getSize().width, this.getSize().height, BufferedImage.TYPE_INT_RGB);
		Graphics g = resized.createGraphics();
		g.drawImage(this.offImage, 0, 0, this.getSize().width, this.getSize().height, null);
		g.dispose();

		paramGraphics.drawImage(resized, 0, 0, null);
	}

	public void paint(Graphics paramGraphics) {
		update(paramGraphics);
	}


}
