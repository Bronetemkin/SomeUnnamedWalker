package ru.Bronetemkin.someunnamedwalker;

import java.util.ArrayList;

public class Characters {

	ArrayList<Character> charList = new ArrayList<Character>();
	
	public void spawnNew(int health, int damage, byte character_class,
			int crdX, int crdY, byte classImg){
		charList.add(new Character(health, damage, character_class, crdX, crdY, classImg, charList.size()+1));
	}
	
	public void removeChar(int indexOfChar){
		charList.remove(indexOfChar);
	}
	
}
