package ru.Bronetemkin.someunnamedwalker;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

public class GameRender extends View{
		FPS fps;
		
		public GameRender(Context context) {
			super(context);
			fps = new FPS();
		}
		
		@Override
		public void onDraw(Canvas canvas){
			super.onDraw(canvas);
			fps.fpsCounter();
			invalidate();
		}
}
