package ru.Bronetemkin.someunnamedwalker;

class Character {

	private int health, damage, crdX, crdY, indexInList;
	private byte character_class, classImg;
	private byte status;
	private boolean direction;

	public Character(int health, int damage, byte character_class,
			int crdX, int crdY, byte classImg, int indexInList) {
		setHealth(health);
		setDamage(damage);
		setCharClass(character_class);
		moveTo(crdX, crdY);
		setClassImg(classImg);
	}
	
	public boolean recieveDamage(int damage){
		if(getHealth() > damage){
			setHealth(getHealth() - damage);
			return true;
		}
		else
		return false;
	}

	public void moveTo(int crdX, int crdY) {
		this.crdX = crdX;
		this.crdY = crdY;
	}

	public int getCrdX() {
		return crdX;
	}

	public int getCrdY() {
		return crdY;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getHealth() {
		return health;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getDamage() {
		return damage;
	}

	public void setClassImg(byte classImg) {
		this.classImg = classImg;
	}

	public byte getClassImg() {
		return classImg;
	}

	public void setCharClass(byte character_class) {
		this.character_class = character_class;
	}

	public byte getCharClass() {
		return character_class;
	}

	/**
	 * Action(command) <br>
	 * - doing nothing (nthg)<br>
	 * - walk left/right (walk)<br>
	 * - jump (jump)<br>
	 * - crouch (crouch)<br>
	 * - attack (atk)<br>
	 * - run (run)
	 */
	public void setStatus(String status) {
		switch (status) {
		case "nthg": {
			this.status = 0;
			break;
		}
		case "walk": {
			this.status = 1;
			break;
		}
		case "jump": {
			this.status = 2;
			break;
		}
		case "crouch": {
			this.status = 3;
			break;
		}
		case "atk": {
			this.status = 4;
			break;
		}
		case "run": {
			this.status = 5;
			break;
		}
		}
	}

	public byte getStatus() {
		return status;
	}

	/**
	 * - left <br>
	 * - right
	 */
	public void setDirection(String dir) {
		switch (dir) {
		case "left": {
			direction = false;
			break;
		}
		case "right": {
			direction = true;
			break;
		}
		}
	}

	public int getIndex(){
		return indexInList;
	}
	
	public boolean findByCoord(int x, int y){
		if(getCrdX() == x && getCrdY() == y)
			return true;
		else
			return false;
	}
	
	public boolean getDirection() {
		return direction;
	}
	
	public boolean equals(Character character){
		if(character.getIndex() == getIndex()){
			return true;
		}else{
		return false;
		}
	}
}