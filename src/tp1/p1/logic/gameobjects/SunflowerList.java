package tp1.p1.logic.gameobjects;

import tp1.p1.logic.Game;
import tp1.p1.view.Messages;

public class SunflowerList {
	private Sunflower[] sunflowers;
	private int numberSunflowers;
	private boolean suns;
	private int sunsCoins;
	
	public SunflowerList() {
		numberSunflowers = 0;
		suns = false;
		sunsCoins = 0;
		sunflowers = new Sunflower[32];
	}

	public Sunflower[] getListSunflower() {
		return sunflowers;
	}
	
	public void setSunflower(int x, int y) {
		for(Sunflower s: sunflowers) {
			if(s != null) {
				if(s.getposition(x, y)) {
					s = null;
				}
			}
		}	
	}
	
	public Sunflower getSunflower(int x, int y) {
		for(Sunflower s: sunflowers) {
			if(s.getposition(x, y)) {
				return s;
			}
		}
		
		return null;
	}
	
	public int getNumberSunflowers() {
		return numberSunflowers;
	}

	public void setNumberSunflowers(int numberSunflowers) {
		this.numberSunflowers = numberSunflowers;
	}

	public boolean isPositionEmpty(int numCols, int row) {
		for(Sunflower s: sunflowers) {
			if(s != null) {
				if(s.getposition(numCols, row)) {
					
					System.out.println(Messages.INVALID_POSITION + "\n");
					
					return false;
				}
			}
		}
		
		return true;
	}
	
	public boolean isSuns() {
		for(Sunflower s: sunflowers) {
			if(s != null) {
				
				return true;
			}
		}
		
		return false;
	}

	public void setSuns(boolean suns) {
		this.suns = suns;
	}

	public int getSunsCoins() {
		return sunsCoins;
	}

	public void setSunsCoins(int sunsCoins) {
		this.sunsCoins = sunsCoins;
	}

	public void addSunflower(Game game, int x, int y) {
		if(isPositionEmpty(x, y)) {
			Sunflower s = new Sunflower(game, x, y);
			sunflowers[numberSunflowers] = s;
			numberSunflowers++;	
			s.getGame().setSunCoins(s.getGame().getSunCoins() - s.getCost());	
		}
	}
}
