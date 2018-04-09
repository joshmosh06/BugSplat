/**
 * 
 */

/**
 * @author Joshmosh
 * Holds the static value of how many bugs have been splated
 */
public class  SplatScore {
	private static int score = 0;
	private static int time = 0;
	private static boolean isGameInProgress = false;
	/**
	 * increments the score by one
	 * @param creature Creature that was selected used to determine how much score should be added
	 */
	public static void addScore(Creature creature) {
		if(creature instanceof Frog) {
			score = score + Frog.SCORE_VALUE;
		}
		if(creature instanceof Bird) {
			score = score + Bird.SCORE_VALUE;
		}
		score++;
	}
	/**
	 * sets the boolean isGameInProgress
	 * @param b boolean value to set
	 */
	public static void setisGameinProgress(boolean b) {
		isGameInProgress = b;
	}
	/**
	 * returns the boolean isGameInProgress
	 * @return isGameInProgress true if the game is running
	 */
	public static boolean getisGameinProgress() {
		return isGameInProgress;
	}
	/**
	 * Returns the Score
	 * @return the current score
	 */
	public static int getScore() {
		return score;
	}
	/**
	 * Returns the time
	 * @return the current time
	 */
	public static int getTime() {
		return time;
	}
	public static void setTime(int i) {
		time = i;
		
	}
	
}
