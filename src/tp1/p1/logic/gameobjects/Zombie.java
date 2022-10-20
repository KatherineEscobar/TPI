package tp1.p1.logic.gameobjects;

import tp1.p1.logic.Game;
import tp1.p1.view.Messages;

public class Zombie {
	private int x;					//Posicion x
	private int y;					//Posicion y
	private int endurance;	//Resistencia
	private int cost;				//Coste		
	private int frecuency;			//Frecuencia
	
	private Game game;
	
	
	public Zombie(int x, int y) {
		this.x = x;
		this.y = y;
		endurance = 5;
	}

	public int getEndurance() {
		return endurance;
	}

	public void setEndurance(int endurance) {
		this.endurance = endurance;
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

	public boolean getposition(int col, int row) {
		if((x == col) && (y == row))
			return true;
		
		return false;
	}
	
	public String toString() {
		return Messages.ZOMBIE_ICON.formatted(endurance);
	}
}
