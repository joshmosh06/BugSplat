import javax.swing.JFrame;

/**
 * 
 */

/**
 * @author Joshmosh runner class used to start the program
 */
public class bugtester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Creatures creatures = new Creatures();
		BugComponent component = new BugComponent(creatures);
		Creature bug1 = new Creature(0, 0, 1,creatures);
		Creature bug2 = new Creature(50, 60, 3,creatures);
		Frog frog = new Frog(40, 100, 1,creatures);
		Bird bird = new Bird(40, 200, 1,creatures);
		CreatureMouseListener mouselistener = new CreatureMouseListener(creatures);
		component.addMouseListener(mouselistener);
		SplatScore.setisGameinProgress(true);
		JFrame frame = new JFrame();
		frame.setFocusable(true);
		frame.setSize(400, 500);
		frame.setTitle("BugSplat");
		frame.add(component);
		frame.setVisible(true);
		frame.addMouseListener(mouselistener);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Thread update = new Thread() {
			int ticks = 0;
			int FRAMES_PER_SECOND = 60;
			public void run() {
				
				long maxWorkingTimePerFrame = 1000 / FRAMES_PER_SECOND; // this is optional
				long lastStartTime = System.currentTimeMillis();

				while (SplatScore.getisGameinProgress()) {
					lastStartTime = System.currentTimeMillis();

					Tick();

					long processingTimeForCurrentFrame = System.currentTimeMillis() - lastStartTime;
					if (processingTimeForCurrentFrame < maxWorkingTimePerFrame) {
						try {
							Thread.sleep(maxWorkingTimePerFrame - processingTimeForCurrentFrame);
						} catch (Exception e) {
							System.err.println("TSEngine :: run :: " + e);
						}
					}
				}

			}

			private void Tick() {
				ticks++;
				if((ticks % 2) == 0) {
//					component.update(frame.getGraphics());
				BugComponent component = new BugComponent(creatures);
				frame.add(component);
				frame.setVisible(true);
				}
				SplatScore.setTime(ticks/FRAMES_PER_SECOND);

				if (ticks/FRAMES_PER_SECOND >= 30) {
					SplatScore.setisGameinProgress(false);
					BugComponent Gameover = new BugComponent(creatures);
					frame.add(Gameover);
					frame.setVisible(true);
					
				}
			}

		};

		update.run();
		

	}

}
