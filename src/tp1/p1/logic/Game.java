package tp1.p1.logic;

import java.util.*;
import tp1.p1.control.*;
import tp1.p1.logic.gameobjects.*;
import tp1.p1.view.Messages;

public class Game {
	public static final int NUM_COLS = 8;
	public static final int NUM_ROWS = 4;
	private int cycles;
	private int suncoins;
	private Random rand;
	private long seed;
	private Level level;
	
	private boolean finished;
	
	private ZombiesManager zm;
	private SunflowerList sl;
	private PeashooterList pl;
	
	public Game(long seed, Level level) {
		this.seed = seed;
		this.level = level;
		getRand(seed);
		
		cycles = 0;	
		suncoins = 50;
		
		finished = false;
		
		sl = new SunflowerList();
		pl = new PeashooterList();
		zm = new ZombiesManager(this, level, rand);
	}

	public String positionToString(int col, int row) {
		for(Sunflower s: sl.getListSunflower()) {
			if(s != null) {
				if(s.getposition(col, row) && s.getEndurance() > 0)
					return s.toString();
			}
		}
		
		for(Peashooter p: pl.getListPeashooter()) {
			if(p != null) {
				if(p.getposition(col, row) && p.getEndurance() > 0)
					return p.toString();
			}
		}
		
		for(Zombie z: zm.getZombies().getListZombie()) {
			if(z != null) {
				if(z.getposition(col, row) && z.getEndurance() > 0)
					return z.toString();
			}
		}
		
		return "";
	}

	public int getCycles() {
		return cycles;
	}

	public void setCycles(int cycles) {
		this.cycles = cycles;
	}

	public int getSunCoins() {
		return suncoins;
	}

	public void setSunCoins(int suns) {
		this.suncoins = suns;
	}

	public Random getRand(long seed) {
		rand = new Random(seed);
		
		return rand;
	}

	public void setRand(Random rand) {
		this.rand = rand;
	}

	public long getSeed() {
		return seed;
	}

	public void setSeed(long seed) {
		this.seed = seed;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public ZombiesManager getZm() {
		return zm;
	}

	public void setZm(ZombiesManager zm) {
		this.zm = zm;
	}

	public boolean isFinished() {
		return finished;
	}
	
	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public void addZombie() {
		zm.addZombie();
	}
	
	public void gameAction(String plant, int x, int y) {
		if(plant.equalsIgnoreCase("sunflower") || plant.equalsIgnoreCase("s")) {
			if(x >= 0 && x < NUM_COLS && y >= 0 && y < NUM_ROWS) {
				if(suncoins >= 20) {
					sl.addSunflower(this, x, y);
					cycles++;
				
				} else
					System.out.println(Messages.NOT_ENOUGH_COINS + "\n");
			
			} else
				System.out.println(Messages.INVALID_POSITION + "\n");
		}
		
		else if(plant.equalsIgnoreCase("peashooter") || plant.equalsIgnoreCase("p")) {
			if(x >= 0 && x < NUM_COLS && y >= 0 && y < NUM_ROWS) {
				if(suncoins >= 50) {
					pl.addPeashooter(this, x, y);
					cycles++;
				
				} else
					System.out.println(Messages.NOT_ENOUGH_COINS + "\n");
			
			} else
				System.out.println(Messages.INVALID_POSITION + "\n");
		}
		
		else 
			System.out.println(Messages.INVALID_GAME_OBJECT);
	}

	public void generateCoins() {
		if(sl.isSuns()) {		
			if(sl.getSunsCoins() == 3) {
				suncoins += 10;
				sl.setSunsCoins(0);
			}
			
			sl.setSunsCoins(sl.getSunsCoins() + 1);
		}
	}
	
	public void shoot() {
		for(Peashooter p: pl.getListPeashooter()) {
			if(p != null) {
				for(Zombie z: zm.getZombies().getListZombie()) {
					if(z != null) {
						if(z.getY() == p.getY()) {
							if(z.getX() > p.getX()) {
								z.setEndurance(z.getEndurance() - 1);
								
							}
						}
					}
				}
			}
		}
	}
	
	public boolean ok() {
		for(Zombie z: zm.getZombies().getListZombie()) {
			if(z != null) {
				
				int x = z.getX();
				int y = z.getY();
				
				for(Sunflower s: sl.getListSunflower()) {
					if(s != null) {
						if(s.getposition(x - 1, y)) {
							
							return true;
						}	
					}
				}
				
				for(Peashooter p: pl.getListPeashooter()) {
					if(p != null) {
						if(p.getposition(x - 1, y)) {
							
							return true;
						}	
					}
				}
				
				for(Zombie zd: zm.getZombies().getListZombie()) {
					if(zd != null) {
						if(zd.getposition(x - 1, y)) {
							
							return true;
						}	
					}
				}
			}
		}	
		
		return false;
	}
	
	public void damage() {
		for(Zombie z: zm.getZombies().getListZombie()) {
			if(z != null) {
				
				int x = z.getX();
				int y = z.getY();
				
				for(Sunflower s: sl.getListSunflower()) {
					if(s != null) {
						if(s.getposition(x - 1, y) || s.getposition(x + 1, y)) {
							
							s.setEndurance(s.getEndurance() - 1);
							
							if(s.getEndurance() <= 0) {
								sl.setSunflower(s.getX(), s.getY());
							}
						}	
					}
				}
				
				for(Peashooter p: pl.getListPeashooter()) {
					if(p != null) {
						if(p.getposition(x - 1, y)) {
							
							p.setEndurance(p.getEndurance() - 1);
						}	
					}
				}
			}
		}	
	}
	
	public void update() {
		generateCoins();
		shoot();
		damage();
		
		if(!ok()) {
			zm.getZombies().advance();
		}
		
		addZombie();
	}

	public void reset() {
		cycles = 0;	
		suncoins = 50;
		
		
		zm = new ZombiesManager(this, level, rand);
		sl = new SunflowerList();
		pl = new PeashooterList();
	}
}
