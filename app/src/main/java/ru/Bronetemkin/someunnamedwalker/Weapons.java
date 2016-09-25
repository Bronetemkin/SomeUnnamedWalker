package ru.Bronetemkin.someunnamedwalker;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import android.content.res.Resources;
import android.util.Log;

public class Weapons {
	public static final String LOG_TAG = "ru.Bronetemkin.someunnamedwalker";

	ArrayList<Weapon> mageWeaponList = new ArrayList<Weapon>();
	ArrayList<Weapon> rogueWeaponList = new ArrayList<Weapon>();
	ArrayList<Weapon> scoutWeaponList = new ArrayList<Weapon>();
	ArrayList<Weapon> warriorWeaponList = new ArrayList<Weapon>();

	public Weapons(Resources res) {
		mageWeaponList = fillWeaponList(R.raw.mageweaponlist, res);
		rogueWeaponList = fillWeaponList(R.raw.rogueweaponlist, res);
		scoutWeaponList = fillWeaponList(R.raw.scoutweaponlist, res);
		warriorWeaponList = fillWeaponList(R.raw.warriorweaponlist, res);
	}

	public ArrayList<Weapon> fillWeaponList(int resourceId, Resources res) {
		Weapon weapon = new Weapon();
		ArrayList<Weapon> weaponList = new ArrayList<Weapon>();
		InputStream file = res.openRawResource(resourceId);
		Scanner sc = new Scanner(file);

		while (sc.hasNextInt()) {
			weapon.setNewDamage(sc.nextInt());
			weapon.setNewSpeed(sc.nextDouble());
			weapon.setNewLevel(sc.nextInt());
			weapon.setName(sc.next());
			weaponList.add(weapon);
		}

		try {
			file.close();
			sc.close();
		} catch (IOException e) {
		}

		return weaponList;
	}

}
