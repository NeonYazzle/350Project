package edu.gvsu.scis.cis350;
import java.io.File;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 * Manages background of game.
 * Controls the speed with which the image moves across the screen
 * 
 * @author Ella
 *
 */
public class GameBackground {
	
	/** Coordinate for location of image*/
	private int x;
	private int y;
	
	/** Set initial speed of scroll to 5*/
	private int speed = 5;
	
	/** Contains Background Image*/
	private BufferedImage image;

	/**
	 * Constructor for GameBackground class. 
	 * Sets coordinates for x and y to 0
	 */
	public GameBackground() {
		this(0,0);
	}
	
	/**
	 * Constructor for GameBackground class.
	 * Loads background image and accepts coordinate for placement of background.
	 * @param x coordinate for image placement
	 * @param y coordinate for image placement
	 */
	public GameBackground(int x, int y) {
		this.x = x;
		this.y = y;
		
		//Retrieve background image from file
		try{
			image = ImageIO.read(new File("Graphics/Backgrounds/citybackground.png"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Re-Draw background shifted over
	 * @param window - window graphics will be drawn on
	 */
	public void draw(Graphics window) {
        // Draw the image onto the Graphics reference
        window.drawImage(image, getX(), getY(), image.getWidth(), image.getHeight(), null);
 
		// Move the x position left for next time
        this.x -= speed;
 
        // Check to see if the image has gone off stage left
        if (this.x <= -1 * image.getWidth()) {
 
            // If it has, line it back up so that its left edge is
            // lined up to the right side of the other background image
            this.x = this.x + image.getWidth() * 2;
        }
	}
	
	/**
	 * Set x coordinate
	 * @param x coordinate x is to be set to
	 */
	public void setX(int x){
		this.x = x;
	}
	
	/**
	 * Get x coordinate
	 * @return x coordinate
	 */
	public int getX(){
		return this.x;
	}
	
	/**
	 * Get y coordinate
	 * @return y coordinate
	 */
	public int getY(){
		return this.y;
	}
	
	/**
	 * Get Background Image width
	 * @return integer value of width of image
	 */
	public int getImageWidth() {
		return image.getWidth();
	}
	
	/**
	 * Get Speed of scrolling
	 * @return integer value for speed of scrolling
	 */
	public int getSpeed(){
		return this.speed;
	}
	
	/**
	 * Set Speed of scrolling
	 * @param speed - new speed for scrolling
	 */
	public void setSpeed(int speed){
		this.speed = speed;
	}
}
