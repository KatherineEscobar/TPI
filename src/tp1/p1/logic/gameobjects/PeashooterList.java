package tp1.p1.logic.gameobjects;

import tp1.p1.logic.Game;
import tp1.p1.view.Messages;

public class PeashooterList {
	private Peashooter[] peashooters;
	private int numberPeashooters;
	
	public PeashooterList() {
		numberPeashooters = 0;
		peashooters = new Peashooter[32];
	}

	public Peashooter[] getListPeashooter() {
		return peashooters;
	}
	
	public boolean isPositionEmpty(int numCols, int row) {
		for(Peashooter p: peashooters) {
			if(p != null) {
				if(p.getposition(numCols, row)) {
					
					System.out.println(Messages.INVALID_POSITION + "\n");
					
					return false;
				}
			}
		}
		
		return true;
	}
	
	
	
	public void addPeashooter(Game game, int x, int y) {
		if(isPositionEmpty(x, y)) {
			Peashooter p = new Peashooter(game, x, y);
			peashooters[numberPeashooters] = p;
			numberPeashooters++;
			p.getGame().setSunCoins(p.getGame().getSunCoins() - p.getCost());	
		}		
	}
}
