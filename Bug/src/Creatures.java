import java.util.ArrayList;

/**
 * 
 */

/**
 * Holds objects of all currently created creatures.
 * @author Joshmosh
 *
 */
public class Creatures {
	private ArrayList<Creature> creaturesArray;
	
	public Creatures() {
		creaturesArray = new ArrayList<Creature>();
	}
	public ArrayList<Creature> getCreatures() {
		return creaturesArray;
	}
	public void AddCreature(Creature creature) {
		creaturesArray.add(creature);
	}
}
