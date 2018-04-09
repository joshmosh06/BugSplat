import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * 
 */

/**
 * @author Joshmosh
 * creates a Creature has an orientation and location
 * Provides the ability to draw each Creature
 */
public class Creature {
	public static final int EAST = 1;
	public static final int WEST = 2;
	public static final int SOUTH = 3;
	public static final int NORTH = 4;
	private Point Location;
	int orientation ;
	int moveAmount;
	Color col1;
	Color col2;
	/**
	 * Creates a Creature using the its location and orientation
	 * @param xPos x location
	 * @param yPos y location
	 * @param orientation direction faceing(1-4)
	 */
	public Creature(int xPos, int yPos, int orientation,Creatures creatures) {
		this.Location = new Point(xPos,yPos);
		this.orientation = orientation;
		this.moveAmount = 1;
		this.col1 = Color.BLUE;
		this.col2 = Color.RED;
		creatures.AddCreature(this);
	}

/**
 * Moves the bugg based on its orienation wont allow the bug to move off the screen
 * 
 */
	public void move() {
	
		if (orientation == Creature.EAST) {
			if(Location.x + moveAmount < 290) {	
				Location.x = Location.x + moveAmount;
			} else {
				orientation = Creature.SOUTH;
			}
		}  if (orientation == Creature.WEST) {
			if(Location.x- moveAmount> 0) {	
				Location.x = Location.x - moveAmount;
			} else {
				orientation = Creature.NORTH;
			}
		}  if (orientation == Creature.SOUTH) {
			if(Location.y + moveAmount< 390) {	
				Location.y = Location.y + moveAmount;
			} else {
				orientation = Creature.WEST;
			}
		} if (orientation == Creature.NORTH) {
			if(Location.y - moveAmount > 0) {	
				Location.y = Location.y- moveAmount;
			} else {
				orientation = Creature.EAST;
			}
		}
		
		if(Location.y > 390 && Location.x > 290) {
			Location.y = 390;
			Location.x = 290;
			orientation = Creature.WEST;
		}
	
		
	
	}
	/**
	 * Sets the bugs location
	 * @param XPos x location
	 * @param YPos y location
	 */
	public void move(int XPos,int YPos) {
		Location.x = XPos;
		Location.y = YPos;
	}
	/**
	 * Returns the location
	 * @return the location
	 */
	public Point getLocation() {
		return Location;
	}
	/**
	 * Creates the bugs visual image based on its current location and orientation
	 * @param g2 graphics component from the paint component class
	 * @return g2 with the new bug added
	 */
	public synchronized Graphics2D getCreatureGraphic(Graphics2D g2) {
		//right
		if(orientation== 1){
			Rectangle body = new Rectangle(Location.x,Location.y,10,20);
			Rectangle head = new Rectangle(Location.x+10,Location.y+5,5,10);
			g2.setColor(col1);
			g2.fill(body);
			g2.fill(head);
			Rectangle eye1 = new Rectangle(Location.x+10,Location.y,5,5);
			Rectangle eye2 = new Rectangle(Location.x+10,Location.y+15,5,5);
			g2.setColor(col2);
			g2.fill(eye1);
			g2.fill(eye2);
		}
		//left
		else if(orientation== 2){
			Rectangle body = new Rectangle(Location.x,Location.y,10,20);
			Rectangle head = new Rectangle(Location.x-5,Location.y+5,5,10);
			g2.setColor(col1);
			g2.fill(body);
			g2.fill(head);
			Rectangle eye1 = new Rectangle(Location.x-5,Location.y,5,5);
			Rectangle eye2 = new Rectangle(Location.x-5,Location.y+15,5,5);
			g2.setColor(col2);
			g2.fill(eye1);
			g2.fill(eye2);
		}
		//up
		else if(orientation== 4){
			Rectangle body = new Rectangle(Location.x,Location.y,20,10);
			Rectangle head = new Rectangle(Location.x+5,Location.y-5,10,5);
			g2.setColor(col1);
			g2.fill(body);
			g2.fill(head);
			Rectangle eye1 = new Rectangle(Location.x,Location.y-5,5,5);
			Rectangle eye2 = new Rectangle(Location.x+15,Location.y-5,5,5);
			g2.setColor(col2);
			g2.fill(eye1);
			g2.fill(eye2);
		}
		//down
		else if(orientation== 3){
			Rectangle body = new Rectangle(Location.x,Location.y,20,10);
			Rectangle head = new Rectangle(Location.x+5,Location.y+10,10,5);
			g2.setColor(col1);
			g2.fill(body);
			g2.fill(head);
			Rectangle eye1 = new Rectangle(Location.x,Location.y+10,5,5);
			Rectangle eye2 = new Rectangle(Location.x+15,Location.y+10,5,5);
			g2.setColor(col2);
			g2.fill(eye1);
			g2.fill(eye2);
			//default
		}else{
			Rectangle body = new Rectangle(Location.x,Location.y,10,20);
			Rectangle head = new Rectangle(Location.x+10,Location.y+5,5,10);
			g2.setColor(col1);
			g2.fill(body);
			g2.fill(head);
			Rectangle eye1 = new Rectangle(Location.x+10,Location.y,5,5);
			Rectangle eye2 = new Rectangle(Location.x+10,Location.y+15,5,5);
			g2.setColor(col2);
			g2.fill(eye1);
			g2.fill(eye2);
		}
		return g2;
		
	}
	/**
	 * gets the orientation
	 * @return the orientation
	 */
	public int getOrientation() {
		return orientation;
	}
	/**
	 * sets the orientation
	 * @param i orientation numerical value (1-4)
	 */
	public void setOrientation(int i) {
		orientation = i;
		
	}

	public int getMoveAmount() {
			return this.moveAmount;	
	}
}
