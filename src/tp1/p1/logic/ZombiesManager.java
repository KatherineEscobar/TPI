package tp1.p1.logic;

import java.util.Random;

import tp1.p1.control.Level;
import tp1.p1.logic.gameobjects.*;
import tp1.p1.view.Messages;

/**
 * Manage zombies in the game.
 *
 */
public class ZombiesManager {
	private Game game;
	private Level level;
	private Random rand;
	private int remainingZombies;
	private ZombieList zombies;

	public ZombiesManager(Game game, Level level, Random rand) {
		this.game = game;
		this.level = level;
		this.rand = rand;
		this.remainingZombies = level.getNumberOfZombies();
		this.zombies = new ZombieList(this.remainingZombies);
	}

	/**
	 * Checks if the game should add (if possible) a zombie to the game.
	 * 
	 * @return <code>true</code> if a zombie should be added to the game.
	 */
	private boolean shouldAddZombie() {
		return rand.nextDouble() < level.getZombieFrequency();
	}
	
	/**
	 * Return a random row within the board limits.
	 * 
	 * @return a random row.
	 */
	private int randomZombieRow() {
		return rand.nextInt(Game.NUM_ROWS);
	}
	
	public boolean addZombie() {
		int row = randomZombieRow();

		return addZombie(row);
	}

	public boolean addZombie(int row) {
		boolean canAdd = getRemainingZombies() > 0 && shouldAddZombie()
				&& isPositionEmpty(Game.NUM_COLS - 1, row);

		if(canAdd) { 
			if(row >= 0 && row < Game.NUM_ROWS) {
				zombies.addZombie(Game.NUM_COLS - 1, row);
				remainingZombies--;
			}
				
			else {
					System.out.println(Messages.ERROR);
			}
		}
		
		/*else {
			System.out.println(Messages.ERROR);
		}*/
		
		return canAdd;
	}

	public boolean isPositionEmpty(int numCols, int row) {
		for(Zombie z: zombies.getListZombie()) {
			if(z != null) {
				if(z.getposition(numCols, row)) {
					
					System.out.println(Messages.INVALID_POSITION + "\n");
					
					return false;
				}
			}
		}
		
		return true;
	}
	
	

	public ZombieList getZombies() {
		return zombies;
	}

	public void setZombies(ZombieList zombies) {
		this.zombies = zombies;
	}

	public int getRemainingZombies() {
		
		return remainingZombies;
	}
}
