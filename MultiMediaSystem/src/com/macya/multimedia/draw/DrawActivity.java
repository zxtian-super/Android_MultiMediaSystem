package com.macya.multimedia.draw;

import com.macya.multimediasystem.MultiMediaSystem;
import com.macya.multimediasystem.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.*;

public class DrawActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_draw);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		menu.add(Menu.NONE,Menu.FIRST+1,1,"Draw");
		menu.add(Menu.NONE,Menu.FIRST+2,2,"Clean");
		menu.add(Menu.NONE,Menu.FIRST+3,3,"Return");
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
		case Menu.FIRST+1:
			Draw DrawDemo1 = new Draw(this);
			setContentView(DrawDemo1);
			break;
		case Menu.FIRST+2:
			Draw DrawDemo2 = new Draw(this);
			setContentView(DrawDemo2);
			break;
		case Menu.FIRST+3:
			Intent intent = new Intent();
			intent.setClass(DrawActivity.this, MultiMediaSystem.class);
			startActivity(intent);
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
