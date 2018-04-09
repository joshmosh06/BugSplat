import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * 
 */

/**
 * @author Joshmosh
 * Frog that jumps across the screen
 */
public class Frog extends Creature {
public static final int SCORE_VALUE = 10;
	public Frog(int xPos, int yPos, int orientation, Creatures creat) {
		super(xPos, yPos, orientation,creat);
		super.moveAmount = 20;
		super.col1 = Color.GREEN;
		super.col2 = Color.RED;
		
	}

}