import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

/**
 * 
 */

/**
 * @author Joshmosh
 * This class detects mouse clicks on the frame
 */
public class CreatureMouseListener implements MouseListener {
	Creatures creatures;
	public CreatureMouseListener(Creatures creatures) {
		this.creatures = creatures;
	}
	

	@Override
	/**
	 * @param arg0 Mouse click
	 * This method is called when the mouse is clicked
	 * Moves a creature to a new location if it is selected
	 */
	public void mouseClicked(MouseEvent arg0) {
		Thread selection = new Thread() {
			public void run() {
				ArrayList<Creature> newarry = creatures.getCreatures();
				Random randgen = new Random();
				for (Creature creature : newarry) {
					if(creature.orientation == Creature.EAST) {
						if(creature.getLocation().x-10  <= arg0.getLocationOnScreen().x & creature.getLocation().x + 30 >= arg0.getLocationOnScreen().x &
							creature.getLocation().y-5 <= arg0.getLocationOnScreen().y & creature.getLocation().y + 45 >=arg0.getLocationOnScreen().y) {
						creature.move(randgen.nextInt(290), randgen.nextInt(390));
						SplatScore.addScore(creature);
						}
					} else if(creature.orientation == Creature.WEST) {
						if(creature.getLocation().x-10  <= arg0.getLocationOnScreen().x & creature.getLocation().x + 30 >= arg0.getLocationOnScreen().x &
								creature.getLocation().y-5 <= arg0.getLocationOnScreen().y & creature.getLocation().y + 45 >= arg0.getLocationOnScreen().y) {
							creature.move(randgen.nextInt(290), randgen.nextInt(390));
							SplatScore.addScore(creature);
						}
					} else if(creature.orientation == Creature.SOUTH) {
						if(creature.getLocation().x-5 <= arg0.getLocationOnScreen().x & creature.getLocation().x + 25 >= arg0.getLocationOnScreen().x &
								creature.getLocation().y-10 <= arg0.getLocationOnScreen().y & creature.getLocation().y + 40 >=arg0.getLocationOnScreen().y) {
							creature.move(randgen.nextInt(290), randgen.nextInt(390));
							SplatScore.addScore(creature);
						}
					} else if(creature.orientation == Creature.NORTH) {
						if(creature.getLocation().x-5  <= arg0.getLocationOnScreen().x & creature.getLocation().x + 25 >= arg0.getLocationOnScreen().x &
								creature.getLocation().y-10 <= arg0.getLocationOnScreen().y & creature.getLocation().y + 40 >= arg0.getLocationOnScreen().y) {
							creature.move(randgen.nextInt(290), randgen.nextInt(390));
							SplatScore.addScore(creature);
						}
					}
				}
			};
		};

		selection.start();
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
