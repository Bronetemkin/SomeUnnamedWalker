package ru.Bronetemkin.someunnamedwalker;

public class Weapon {

	private String name;
	private int damage = 0;
	private int level = 0;
	private double speed = 0;

	/**
	 * Name of weapon, that will be displayed.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Name of weapon, that will be displayed.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Damage of current weapon.
	 */
	public int getDamageStat() {
		return damage;
	}

	/**
	 * New damage of current weapon.
	 */
	public void setNewDamage(int damage) {
		this.damage = damage;
	}

	/**
	 * Level of weapon. Affects to damage and other stats of weapon.
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Level of weapon. Affects to damage and other stats of weapon.
	 */
	public void setNewLevel(int level) {
		this.level = level;
	}

	/**
	 * Attack speed of weapon. Affects to damage/min of weapon.
	 */
	public double getSpeedStat() {
		return speed;
	}

	/**
	 * Attack speed of weapon. Affects to damage/min of weapon.
	 */
	public void setNewSpeed(double speed) {
		this.speed = speed;
	}

	public String write() {
		String out = name + ", " + damage + ", " + level + ", " + speed;
		return out;
	}
}
