package com.macya.multimedia.draw;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
//import android.graphics.Path;
//import android.util.AttributeSet;

import android.view.MotionEvent;
import android.view.View;
//import android.widget.Button;

public class Draw extends View{
	
	private int move_x;
	private int move_y;
	private Paint paint;
	private Canvas canvas;
	private Bitmap bitmap;
	//private int blcolor;
	
	public Draw(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.paint = new Paint(Paint.DITHER_FLAG);
		this.bitmap = Bitmap.createBitmap(480, 854, Config.ARGB_8888);
		this.canvas = new Canvas();
		canvas.setBitmap(bitmap);
		
		this.paint.setStyle(Style.STROKE);
		this.paint.setStrokeWidth(5);//±Ê¿í5ÏñËØ
		this.paint.setColor(Color.BLUE);
		this.paint.setAntiAlias(true);
	}
	
	//»­Î»Í¼
	@Override 
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
		canvas.drawBitmap(bitmap, 0, 0 , null);
	}
	
	//´¥ÃþÊÂ¼þ
	@Override
	public boolean onTouchEvent(MotionEvent event){
		if(event.getAction() == MotionEvent.ACTION_MOVE){
			//draw line
			canvas.drawLine(move_x, move_y, event.getX(), event.getY(), paint);
			//canvas.drawRect(move_x, move_y, event.getX(), event.getY(), paint);
			invalidate();
		}
		if(event.getAction() == MotionEvent.ACTION_DOWN){
			this.move_x = (int)event.getX();
			this.move_y = (int)event.getY();
			invalidate();
		}
		this.move_x = (int)event.getX();
		this.move_y = (int)event.getY();
		return true;
	}
	
	public void clean(){
		this.bitmap = Bitmap.createBitmap(480, 854, Config.ARGB_8888);
		invalidate();
	}
}
