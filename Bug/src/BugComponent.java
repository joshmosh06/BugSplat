import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;



/**
 * 
 * @author Joshmosh
 * Draws and redraws the bug to an x y location
 */

public class BugComponent extends JComponent {
	public Creatures creat; 
	public BugComponent(Creatures creat) {
		this.creat = creat;
	}
	/**Paints the bug depending on witch direction it is facing
	 * @param Graphics 
	 * 
	 */
	public synchronized void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g ; 
		if(SplatScore.getisGameinProgress()) {
		ArrayList<Creature> creatures = creat.getCreatures();
		Random randgen = new Random();
		for (Creature creature : creatures) {
			int move = randgen.nextInt(500);
			int turn = randgen.nextInt(10000);
			if(turn == 0) {
				creature.setOrientation(randgen.nextInt(3) + 1);
			}
			if(move == 0) {
				creature.move();
			}
			creature.getCreatureGraphic(g2);
		}
		g.setColor(Color.BLACK);
		g.drawString("Score: " + SplatScore.getScore(), 300, 15);
		g.drawString("Time: " + SplatScore.getTime() + " Seconds", 180, 15);
		} else {
			g.setColor(Color.BLACK);
			g.drawString("Game Over ", 200, 150);
			g.drawString("Your Score: " + SplatScore.getScore(), 200, 180);
		}
	}
	public synchronized void Update(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g ; 
		ArrayList<Creature> creatures = creat.getCreatures();
		Random randgen = new Random();
		for (Creature creature : creatures) {
			int move = randgen.nextInt(1000);
			if(move == 0) {
				creature.move();
			}
			creature.getCreatureGraphic(g2);
		}
	}



}



