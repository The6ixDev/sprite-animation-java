import java.awt.Image;
// there are 2 types of animation
// static and dynamic
// sprite is a dynamic animation
public class Sprite {
	/*
	 *  instead of the static image moving
	 *  we wanna make our animation moving around the screen
	 *  for our game element
	 */
	private Animation a;
	// we need the position of the sprite
	private float x;
	private float y;
	// velocity of x
	private float vx;
	//velocity of y
	private float vy;

	//CONSTRUCTOR 
	public Sprite(Animation a) {
		this.a=a;
	}

	// change position based on timePassed which we calculated in another class
	public void update(long timePassed) {
		// distance = speed * time;
		x += vx *timePassed;
		y += vy *timePassed;
		a.update(timePassed);
		
	}
	// get the x position
	public float getX() {
		return x;
	}
	
	// get the y position
	public float getY() {
		return y;
	}
	
	// Set the sprite x position
	public void setX(float x) {
		this.x= x;
	}
		
	// Set the sprite y position
	public void setY(float y) {
		this.y= y;
	}
		
	// getWidth of sprite
	
	public int getWidth() {
		return a.getImage().getWidth(null);
	}
	
	// getHeight of sprite
	public int getHeight() {
	 return a.getImage().getHeight(null);
	}
	
		// get the sprite x velocity
	public float getVelocityX() {
		return vx;
	}
				
		// get the sprite y velocity
	public float getVelocityY() {
		return vy;
	}
	
	// set horizontal x:
	
	public void setVelocityX(float vx) {
		this.vx=vx;
	}
	
	public void setVelocityY(float vy) {
		this.vy=vy;
	}
	
	// get sprite/image
	public Image getImage() {
		return a.getImage();
	}
		
	
}
