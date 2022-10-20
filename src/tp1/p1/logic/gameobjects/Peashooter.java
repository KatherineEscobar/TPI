package tp1.p1.logic.gameobjects;

import java.io.PrintStream;

import tp1.p1.logic.Game;
import tp1.p1.view.Messages;

public class Peashooter {
	private int x; 						//Posicion coordenada x
	private int y;						//Posicion coordenada y
	private int endurance;		//Resistencia
	private int cost;			//Coste
	private int frecuency;				//Frecuencia
	private int damage;			//Daño
	
	private Game game;
	
	
	public Peashooter(Game game, int x, int y) {
		this.game = game;
		this.x = x;
		this.y = y;
		endurance = 3;
		cost = 50;
		damage = 1;
	}
	
	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public int getEndurance() {
		return endurance;
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

	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}

	public static Object getDescription() {
		
		return Messages.PEASHOOTER_DESCRIPTION.formatted(50, 1, 3);
	}

	public boolean getposition(int col, int row) {
		if((x == col) && (y == row))
			return true;
		
		return false;
	}
	
	public String toString() {
		return Messages.PEASHOOTER_ICON.formatted(endurance);
	}
}
