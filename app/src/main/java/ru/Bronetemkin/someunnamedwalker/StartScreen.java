package ru.Bronetemkin.someunnamedwalker;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

public class StartScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		GameRender draw = new GameRender(this);
		setContentView(draw);
		
		Resources r = this.getResources();
		Weapons weapons = new Weapons(r);

		Log.d("LOGGING", weapons.mageWeaponList.get(0).getName());
		}
	
	@Override
	protected void onResume(){
		super.onResume();
	}
	
	@Override
	protected void onPause(){
		super.onPause();
	}
	
	@Override
	protected void onStop(){
		super.onStop();
	}
}
