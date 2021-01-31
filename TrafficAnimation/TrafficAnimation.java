import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * CS 121 Project 1: Traffic Animation
 *
 * Animates a fire ball being launched from a pair of cannons that is located on a ship in a body of water.  
 * Gannon, who is on top of the ship, is trying to stop Link from getting to the Triforce across the bridge.
 * Link safely awaits as the fire balls cross before he moves on.  Cross if you dare!
 *
 * @author BSU CS 121 Luke Hindman
 * @author Alex Acevedo
 */
@SuppressWarnings("serial")
public class TrafficAnimation extends JPanel
{
	// This is where you declare constants and variables that need to keep their
	// values between calls	to paintComponent(). Any other variables should be
	// declared locally, in the method where they are used.
	private final Color brown = new Color (153,76,0);
	private final Color dGreen = new Color (51,102,0);
	private final Color gGreen = new Color (0,51,0);
	private final Color dBrown = new Color (102,51,0);
	private final Color mBrown = new Color (204,102,0);
	
	//imports images
	private final ImageIcon link = new ImageIcon("link.png");
	private final ImageIcon rupee = new ImageIcon("rupee.png");
	private final ImageIcon ball = new ImageIcon("fireball.png");
	private final ImageIcon ganon = new ImageIcon("dorf.png");
	
	/**
	 * A constant to regulate the frequency of Timer events.
	 * Note: 100ms is 10 frames per second - you should not need
	 * a faster refresh rate than this
	 */
	private final int DELAY = 30; //milliseconds

	/**
	 * The anchor coordinate for drawing / animating. All of your vehicle's
	 * coordinates should be relative to this offset value.
	 */
	private int xOffset = 0;

	/**
	 * The number of pixels added to xOffset each time paintComponent() is called.
	 */
	private int stepSize = 10;



	/* This method draws on the panel's Graphics context.
	 * This is where the majority of your work will be.
	 *
	 * (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g)
	{
		// Get the current width and height of the window.
		int width = getWidth(); // panel width
		int height = getHeight(); // panel height

		// Fill the graphics page with the background color.
		g.setColor(dGreen);
		g.fillRect(0, 0, width, height);
		
		//Draws and Fills background objects
		g.setColor(gGreen);
		g.fillArc(width/5-width/100, height/8, width/15, height/15, 0, 360);
		g.fillArc(width/6+width/20, height/10, width/15, height/15, 0, 360);
		g.fillArc(width/6+width/20+width/20-width/50, height/8, width/15, height/15, 0, 360);
		g.fillArc(width/2+width/50, height/8, width/15, height/15, 0, 360);
		g.fillArc(width/2+width/20, height/10, width/15, height/15, 0, 360);
		g.fillArc(width/2+width/20+width/20-width/50, height/8, width/15, height/15, 0, 360);
		g.fillArc(width/3+width/50, height/12, width/15, height/15, 0, 360);
		g.fillArc(width/3+width/20, height/16, width/15, height/15, 0, 360);
		g.fillArc(width/3+width/20+width/20-width/50, height/12, width/15, height/15, 0, 360);
				
		
		//Fill the river
		g.setColor(Color.blue);
		g.fillRect(0, height/4, width, height/2);
		
		//Outline for the river
		g.setColor(Color.black);
		g.drawRect(0, height/4, width, height/2);
		
		//fills the bridge
		int bridgeX = width - (width/4);
		int bridgeY = 0;
		int bridgeW = width/9;
		int bridgeH = height;
		
		g.setColor(brown);
		g.fillRect(bridgeX, bridgeY, bridgeW, bridgeH);
		
		//Outline for the bridge and boards
		g.setColor(Color.black);
		g.drawRect(bridgeX, bridgeY, bridgeW, bridgeH);
		g.drawRect(bridgeX, bridgeY, bridgeW, bridgeH/10);
		g.drawRect(bridgeX, bridgeY+(bridgeH/10), bridgeW, bridgeH/10);
		g.drawRect(bridgeX, (bridgeY+(bridgeH/10))+bridgeH/10, bridgeW, bridgeH/10);
		g.drawRect(bridgeX, ((bridgeY+(bridgeH/10))+bridgeH/10)+bridgeH/10, bridgeW, bridgeH/10);
		g.drawRect(bridgeX, (((bridgeY+(bridgeH/10))+bridgeH/10)+bridgeH/10)+bridgeH/10, bridgeW, bridgeH/10);
		g.drawRect(bridgeX, ((((bridgeY+(bridgeH/10))+bridgeH/10)+bridgeH/10)+bridgeH/10)+bridgeH/10, bridgeW, bridgeH/10);
		g.drawRect(bridgeX, (((((bridgeY+(bridgeH/10))+bridgeH/10)+bridgeH/10)+bridgeH/10)+bridgeH/10)+bridgeH/10, bridgeW, bridgeH/10);
		g.drawRect(bridgeX, ((((((bridgeY+(bridgeH/10))+bridgeH/10)+bridgeH/10)+bridgeH/10)+bridgeH/10)+bridgeH/10)+bridgeH/10, bridgeW, bridgeH/10);
		g.drawRect(bridgeX, (((((((bridgeY+(bridgeH/10))+bridgeH/10)+bridgeH/10)+bridgeH/10)+bridgeH/10)+bridgeH/10)+bridgeH/10)+bridgeH/10, bridgeW, bridgeH/10);
		g.drawRect(bridgeX, ((((((((bridgeY+(bridgeH/10))+bridgeH/10)+bridgeH/10)+bridgeH/10)+bridgeH/10)+bridgeH/10)+bridgeH/10)+bridgeH/10)+bridgeH/10, bridgeW, bridgeH/10);
		
		//Draws wording across grass
		g.setColor(Color.red);
		Font f = new Font("Impact", Font.ITALIC, width/30+height/30);
		g.setFont(f);
		g.drawString("CROSS IF YOU DARE!!!!", width/2-width/3, height/2+height/3);
		
		
		// Calculate the new xOffset position of the moving object.
		xOffset  = (xOffset + stepSize) % width;

		// TODO: Use width, height, and xOffset to draw your scalable objects
		// at their new positions on the screen

		//Declared integers to draw the boat and move the cannon balls
		int arcY = height / 3;
		int arcYy = height /4;
		int arcX = width / 60;
		int ballX = width/30;
		int ballY = height/22;
		int midB = height /2;
		
		//Draws and places the moving cannon balls
		g.setColor(Color.black);
		g.drawImage(ball.getImage(), xOffset+60, midB+height/15-height/50, ballX*2, ballY*2, null);
		g.drawImage(ball.getImage(), xOffset+60, midB-height/15-height/13, ballX*2, ballY*2, null);
				
		//Draws and outlines boat in specified place		
		g.setColor(Color.black);
		g.drawArc(0, arcYy, arcX*6, arcY, 0, 180);
		g.drawArc(0, arcYy*2-height/11, arcX*6, arcY,180, 180);
		g.drawRect(0, height/2-height/11, arcX*6, arcY/2);
		
		
		g.fillRect(width/12, midB+height/15, ballX, ballY);
		g.fillRect(width/12, midB-height/8, ballX, ballY);
		
		g.setColor(dBrown);
		g.fillArc(0, arcYy, arcX*6, arcY, 0, 180);
		g.fillArc(0, arcYy*2-height/11, arcX*6, arcY,180, 180);
		g.fillRect(0, height/2-height/11, arcX*6, arcY/2 + height/30);
		
		g.setColor(brown);
		g.fillArc(width/70, arcYy+height/25, arcX*4+width/315, arcY/2, 0, 180);
		g.fillArc(width/70, arcYy*3-height/5, arcX*4+width/315, arcY/2, 180, 180);
		
		g.setColor(mBrown);
		g.fillRect(width/70, midB-height/8, width/10-width/34-width/400, height/4+height/150);
		
		//draws boat details
		g.setColor(Color.black);
		g.drawLine(0, midB-height/8, width/10, midB-height/8);
		g.drawLine(0, midB+height/8+height/110, width/11+width/180, midB+height/8+height/110);
		g.drawLine(width/70, midB-height/8, width/70, midB+height/8+height/110);
		g.drawLine(width/12, midB-height/8, width/12, midB+height/8+height/110);
		
		g.drawArc(width/70, arcYy+height/25, arcX*4+width/315, arcY/2, 0, 180);
		g.drawArc(width/70, arcYy*3-height/5, arcX*4+width/315, arcY/2, 180, 180);
		
		g.drawLine(width/21, arcYy+height/25, width/21, arcYy+height/8);
		g.drawLine(width/21+width/100, arcYy+height/25+height/200, width/21+width/100, arcYy+height/8);
		g.drawLine(width/21+width/100+width/100, arcYy+height/25+height/200+height/100, width/21+width/100+width/100, arcYy+height/8);
		g.drawLine(width/21+width/100+width/100+width/100, arcYy+height/25+height/200+height/100+height/40, width/21+width/100+width/100+width/100, arcYy+height/8);
		g.drawLine(width/21-width/100, arcYy+height/25+height/200, width/21-width/100, arcYy+height/8);
		g.drawLine(width/21-width/100-width/100, arcYy+height/25+height/200+height/80, width/21-width/100-width/100, arcYy+height/8);
		g.drawLine(width/21-width/100-width/100-width/100, arcYy+height/25+height/200+height/100+height/30, width/21-width/100-width/100-width/100, arcYy+height/8);
		
		g.drawLine(width/21, arcYy*3-height/25+height/200, width/21, arcYy*3-height/8+height/100);
		g.drawLine(width/21+width/100, arcYy*3-height/25+height/200-height/300, width/21+width/100, arcYy*3-height/8+height/100);
		g.drawLine(width/21+width/100+width/100, arcYy*3-height/25+height/200-height/75, width/21+width/100+width/100, arcYy*3-height/8+height/100);
		g.drawLine(width/21+width/100+width/100+width/100, arcYy*3-height/25+height/200-height/30, width/21+width/100+width/100+width/100, arcYy*3-height/8+height/100);
		g.drawLine(width/21-width/100, arcYy*3-height/25+height/200-height/300, width/21-width/100, arcYy*3-height/8+height/100);
		g.drawLine(width/21-width/100-width/100, arcYy*3-height/25+height/200-height/75, width/21-width/100-width/100, arcYy*3-height/8+height/100);
		g.drawLine(width/21-width/100-width/100-width/100, arcYy*3-height/25+height/200-height/25, width/21-width/100-width/100-width/100, arcYy*3-height/8+height/100);
		
		g.drawLine(width/70, height/2, arcX*5, height/2);
		g.drawLine(width/70, height/2+height/30, arcX*5, height/2+height/30);
		g.drawLine(width/70, height/2+height/30+height/30, arcX*5, height/2+height/30+height/30);
		g.drawLine(width/70, height/2+height/30+height/30+height/30, arcX*5, height/2+height/30+height/30+height/30);
		g.drawLine(width/70, height/2-height/30, arcX*5, height/2-height/30);
		g.drawLine(width/70, height/2-height/30-height/30, arcX*5, height/2-height/30-height/30);
		g.drawLine(width/70, height/2-height/30-height/30-height/30, arcX*5, height/2-height/30-height/30-height/30);
		
		
		//draws images
		g.drawImage(link.getImage(), width/2+width/4, height/30, width/10, height/8, null);
		g.drawImage(rupee.getImage(), width/3+width/2-width/13, height/2+height/3, width/10, height/8, null);
		g.drawImage(ganon.getImage(), 0+width/100, height/2-height/14, width/12, height/9, null);


		
		// Put your code above this line. This makes the drawing smoother.
		Toolkit.getDefaultToolkit().sync();
	}


	//==============================================================
	// You don't need to modify anything beyond this point.
	//==============================================================


	/**
	 * Starting point for this program. Your code will not go in the
	 * main method for this program. It will go in the paintComponent
	 * method above.
	 *
	 * DO NOT MODIFY this method!
	 *
	 * @param args unused
	 */
	public static void main (String[] args)
	{
		// DO NOT MODIFY THIS CODE.
		JFrame frame = new JFrame ("Traffic Animation");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new TrafficAnimation());
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Constructor for the display panel initializes necessary variables.
	 * Only called once, when the program first begins. This method also
	 * sets up a Timer that will call paint() with frequency specified by
	 * the DELAY constant.
	 */
	public TrafficAnimation()
	{
		// Do not initialize larger than 800x600. I won't be able to
		// grade your project if you do.
		int initWidth = 600;
		int initHeight = 400;
		setPreferredSize(new Dimension(initWidth, initHeight));
		this.setDoubleBuffered(true);

		//Start the animation - DO NOT REMOVE
		startAnimation();
	}

	/**
	 * Create an animation thread that runs periodically.
	 * DO NOT MODIFY this method!
	 */
	private void startAnimation()
	{
		ActionListener timerListener = new TimerListener();
		Timer timer = new Timer(DELAY, timerListener);
		timer.start();
	}

	/**
	 * Repaints the graphics panel every time the timer fires.
	 * DO NOT MODIFY this class!
	 */
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}
}