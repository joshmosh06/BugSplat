import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

/**
 * 
 */

/**
 * @author Joshmosh
 * The bird can fly and travel much faster than a frog 
 */
public class Bird extends Creature {
	public static final int SCORE_VALUE = 5;
	public Bird(int xPos, int yPos, int orientation ,Creatures creat) {
		super(xPos, yPos, orientation,creat);
		super.moveAmount=20;
		super.col1 = Color.WHITE;
		super.col2 = Color.RED;
	}
	
	
}