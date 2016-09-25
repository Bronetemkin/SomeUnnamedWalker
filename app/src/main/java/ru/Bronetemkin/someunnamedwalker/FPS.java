package ru.Bronetemkin.someunnamedwalker;

import android.content.Context;
import android.util.Log;

public class FPS {
	private long timeBegin = java.lang.System.currentTimeMillis(), timeEnd = 0;
	private final int period = 1000;
	private int framesCountFin = 0, framesCount = 0;

	public FPS() {
		Log.d("timeTAG", "Created!");
	}
	
	public int getFrameRate(){
		return framesCountFin;
	}
	
	public void fpsCounter() {
		if (timeEnd - timeBegin < period) {
			timeEnd = java.lang.System.currentTimeMillis();
			framesCount++;
		} else {
			framesCountFin = framesCount;
			framesCount = 0;
			timeBegin = java.lang.System.currentTimeMillis();
			Log.d("timeTAG", getFrameRate() + "");
		}
	}
}
