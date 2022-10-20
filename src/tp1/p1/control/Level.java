package tp1.p1.control;

import tp1.p1.view.Messages;

/**
 * Represents the allowed levels in the game.
 *
 */
public enum Level {
	EASY, HARD, INSANE;
	
	private int numberOfZombies;
	private double zombieFrequency;

	private Level(int numberOfZombies, double zombieFrequency) {
		this.numberOfZombies = numberOfZombies;
		this.zombieFrequency = zombieFrequency;
	}

	private Level() {
	
	}
	
	/**
	 * Parse an string and return any matching level
	 * 
	 * @param inputString string to parse
	 * @return the parsed {@link Level} or <code>null</code> if none match.
	 */
	public static Level valueOfIgnoreCase(String inputString) {
		for (Level level : Level.values()) {
			if (level.name().equalsIgnoreCase(inputString)) {
				return level;
			}
		}
		
		return null;
	}

	/**
	 * Returns a string representation of all the levels joined with <code>separator</code>
	 * 
	 * @param separator String used as separator
	 * 
	 * @return the string resulted from joining all levels using <code>separator</code>
	 */
	public static String all(String separator) {
		StringBuilder buffer = new StringBuilder();
		int levelCount = 0;
		for (Level level : Level.values()) {
			if (levelCount > 0) {
				buffer.append(separator);
			}
			buffer.append(level.name());
			levelCount++;
		}
		return buffer.toString();
	}

	public int getNumberOfZombies() {
		if(this == EASY) 
			numberOfZombies = 3;
		
		else if(this == HARD) 
			numberOfZombies = 5;
		
		else if(this == INSANE)
			numberOfZombies = 10;
		
		else
			System.out.println(Messages.ALLOWED_LEVELS);
		
		return numberOfZombies;
	}

	public double getZombieFrequency() {
		if(this == EASY) 
			zombieFrequency = 0.1;
		
		else if(this == HARD) 
			zombieFrequency = 0.2;
		
		else if(this == INSANE)
			zombieFrequency = 0.3;
		
		else 
			System.out.println(Messages.ALLOWED_LEVELS);
		
		return zombieFrequency;
	}
}
