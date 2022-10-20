package tp1.p1.control;

import static tp1.p1.view.Messages.*;

import java.util.Scanner;

import tp1.p1.logic.Game;
import tp1.p1.view.GamePrinter;
import tp1.p1.view.Messages;

/**
 * Accepts user input and coordinates the game execution logic.
 *
 */
public class Controller {
	private Game game;
	private Scanner scanner;
	private GamePrinter gamePrinter;

	public Controller(Game game, Scanner scanner) {
		this.game = game;
		this.scanner = scanner;
		this.gamePrinter = new GamePrinter(game);
	}

	/**
	 * Draw / Paint the game.
	 */
	private void printGame() {
		System.out.println(gamePrinter);
	}

	/**
	 * Prints the final message once the match is finished.
	 */
	public void printEndMessage() {
		System.out.println(gamePrinter.endMessage());
	}

	/**
	 * Show prompt and request command.
	 *
	 * @return the player command as words
	 */
	private String[] prompt() {
		System.out.print(Messages.PROMPT);
		String line = scanner.nextLine();
		String[] words = line.toLowerCase().trim().split("\\s+");

		System.out.println(debug(line));
		
		return words;
	}

	/**
	 * Runs the game logic.
	 */
	public void run() {
		while(!game.isFinished()) {			
			printGame();
			String[] parameters = prompt();
			
			if(parameters[0].isEmpty())
					parameters[0] = "none";
			
			if(parameters[0].equalsIgnoreCase("none") || parameters[0].equalsIgnoreCase("n")) {
				game.setCycles(game.getCycles() + 1);
				game.update();
			}
			
			else if(parameters[0].equalsIgnoreCase("add") || parameters[0].equalsIgnoreCase("a")) {
				if(parameters.length == 4) {
					int x = Integer.parseInt(parameters[2]);
					int y = Integer.parseInt(parameters[3]);
					String plant = parameters[1];
				
					game.gameAction(plant, x, y);
					game.update();
				}
				
				else 
					System.out.println(Messages.COMMAND_PARAMETERS_MISSING + "\n");
			}
			
			else if(parameters[0].equalsIgnoreCase("list") || parameters[0].equalsIgnoreCase("l")) 
				System.out.println(Messages.LIST);
			
			else if(parameters[0].equalsIgnoreCase("reset") || parameters[0].equalsIgnoreCase("r"))
				game.reset();
			
			else if(parameters[0].equalsIgnoreCase("help") || parameters[0].equalsIgnoreCase("h"))
				System.out.println(Messages.HELP);
			
			else if(parameters[0].equalsIgnoreCase("exit") || parameters[0].equalsIgnoreCase("e")) {
				System.out.println(Messages.GAME_OVER);
				game.setFinished(true);
				System.exit(0);
			}
			
			else 
				System.out.println(Messages.INVALID_COMMAND);							
		}
	}
}
