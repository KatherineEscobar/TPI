package tp1.p1.logic.gameobjects;

import tp1.p1.view.Messages;

public class ZombieList {
	private Zombie[] zombies;
	int numberZombies;
	
	public ZombieList(int remainingZombies) {
		numberZombies = 0;
		zombies = new Zombie[remainingZombies];
	}

	public Zombie[] getListZombie() {
		return zombies;
	}

	public void setListZombie(Zombie[] listZombie) {
		this.zombies = listZombie;
	}

	public int getNumberZombies() {
		return numberZombies;
	}

	public void setNumberZombies(int numberZombies) {
		this.numberZombies = numberZombies;
	}
	
	public void advance() {
		for(Zombie z: zombies) {
			if(z != null) {
				z.setX(z.getX() - 1);
				
				if(z.getX() == 0) {
					System.out.println(Messages.ZOMBIES_WIN);
					System.exit(0);
				}
			}
		}
	}
	public void addZombie(int x, int y) {
		zombies[numberZombies] = new Zombie(x, y);
		numberZombies++;
	}
 }
