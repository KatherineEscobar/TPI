package tp1.p1.logic.gameobjects;

import tp1.p1.logic.Game;
import tp1.p1.view.Messages;

public class Sunflower {
	private int x;						//Posicion coordenada x
	private int y;						//Posicion coordenada y
	private int endurance;		//Resistencia
	private int cost;			//Coste		
	private int frecuency;				//Frecuencia
	private int damage;	
	
	private Game game;
	
	
	public Sunflower(Game game, int x, int y) {
		this.game = game;
		this.x = x;
		this.y = y;
		endurance = 1;
		cost = 20;	
		damage = 0;
	}
	
	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getEndurance() {
		return endurance;
	}

	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public static Object getDescription() {
		
		return Messages.SUNFLOWER_DESCRIPTION.formatted(20, 0, 1);
	}

	public boolean getposition(int col, int row) {
		if((x == col) && (y == row))
			return true;
		
		return false;
	}
	
	public String toString() {
		return Messages.SUNFLOWER_ICON.formatted(endurance);
	}
}
