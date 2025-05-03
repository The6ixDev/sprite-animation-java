import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.*;	


	public class Hamid2 {
		public static void main(String[] args) {
			Hamid2 b = new Hamid2();
			b.run();
		}
		private Animation a;
		private ScreenManager s;
		private Image bg;
		
		private Sprite sprite;
		
		// now we need a list of displayModes:
		// we wanna give it a bunch of default Modes and then c if they match and then if they do take it out
		
		private static final DisplayMode modes1[]= {
				new DisplayMode(800, 600, 32, 0),
				new DisplayMode(800, 600, 24, 0),
				new DisplayMode(800, 600, 16, 0),
				new DisplayMode(640, 480, 32, 0),
				new DisplayMode(640, 480, 16, 0),
				new DisplayMode(640, 480, 24, 0)
		};
		
		// load images and add scenes
		
		public void loadImages() {
			bg=new ImageIcon("C:\\Users\\hamid\\Eclipse-Workspace-new\\Java Game Development\\src\\bg.png").getImage();
			Image face1=new ImageIcon("C:\\Users\\hamid\\Eclipse-Workspace-new\\Java Game Development\\src\\face1.png").getImage();
			Image face2=new ImageIcon("C:\\Users\\hamid\\Eclipse-Workspace-new\\Java Game Development\\src\\face2.png").getImage();
			a = new Animation();
			a.addScene(face1, 250);
			a.addScene(face2, 250);
			
			/*
			 * new configurations
			 */
			sprite = new Sprite(a);
			sprite.setVelocityX(0.3f);
			sprite.setVelocityY(0.3f);
		}
		
		// our Run method
		private void run() {
			s= new ScreenManager();
			
			try {
				// this is gonna find a mode that is compatible
				DisplayMode dm = s.findFirstCompatibleMode(modes1);
				s.setFullScreen(dm);
				loadImages();
				movieLoop();
				
			} finally {
				//we wanna do a bunch of actions and then get back to original screen size
				s.restoreScreen();
			}
			
		}
		
		// play a movie now
		// this loops the movie
		
		public void movieLoop() {
			long startingTime = System.currentTimeMillis();
			long cumulativeTime = startingTime;
			while (cumulativeTime - startingTime <6000) {
				long timePassed = System.currentTimeMillis()-cumulativeTime;
				cumulativeTime +=timePassed;
				update(timePassed);
				// draw and update screen
				Graphics2D g =s.getGraphics();
				draw(g);
				g.dispose();
				s.update();
				
				try {
					Thread.sleep(20);
				} catch (Exception e) {
				e.printStackTrace();
				}
			}
		}

		// draws graphics,bg,images
		private void draw(Graphics g) {
			g.drawImage(bg, 0, 0, null);
			// a.getImage(); gets the proper image based on that time
			g.drawImage(sprite.getImage(), Math.round(sprite.getX()), (int)sprite.getY(), null);
			
		}
		
		// update the sprite position
		private void update(long timePassed) {
			
			// it's gonna check to c if the sprite is off screen or not and if it is,put it back
			if (sprite.getX()<0) {
				sprite.setVelocityX(Math.abs(sprite.getVelocityX()));
			}else if (sprite.getX()+sprite.getWidth()>s.getWidth()) {
				sprite.setVelocityX(-Math.abs(sprite.getVelocityX()));
			}
			if (sprite.getY()<0) {
				sprite.setVelocityY(Math.abs(sprite.getVelocityY()));
			}else if (sprite.getY()+sprite.getHeight()>s.getHeight()) {
				sprite.setVelocityY(-Math.abs(sprite.getVelocityY()));
			}
			
			sprite.update(timePassed);
			
		}

		
		
	}


