package com.macya.multimedia.animation;

import com.macya.multimediasystem.MultiMediaSystem;
import com.macya.multimediasystem.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AnimationActivity extends Activity{
	
	private Button alphaBut = null;
	private Button scaleBut = null;
	private Button transBut = null;
	private Button rotateBut = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animation);
		
		this.alphaBut = (Button)super.findViewById(R.id.alpha);
		this.alphaBut.setOnClickListener(new AlphaProject());
		
		this.scaleBut = (Button)super.findViewById(R.id.scale);
		this.scaleBut.setOnClickListener(new ScaleProject());
		
		this.transBut = (Button)super.findViewById(R.id.translate);
		this.transBut.setOnClickListener(new TransProject());
		
		this.rotateBut = (Button)super.findViewById(R.id.rotate);
		this.rotateBut.setOnClickListener(new RotateProject());
		
	}
	
	public class AlphaProject implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(AnimationActivity.this, AlphaDemoActivity.class);
			startActivity(intent);
		}
	}
	
	public class ScaleProject implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(AnimationActivity.this, ScaleDemoActivity.class);
			startActivity(intent);
		}
	}
	
	public class TransProject implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(AnimationActivity.this, TransDemoActivity.class);
			startActivity(intent);
		}
	}
	
	public class RotateProject implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(AnimationActivity.this, RotateDemoActivity.class);
			startActivity(intent);
		}
	}	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		menu.add(Menu.NONE, Menu.FIRST+1, 1, "MainMenu");
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		if(item.getItemId() == Menu.FIRST+1){
			Intent intent = new Intent();
			intent.setClass(AnimationActivity.this, MultiMediaSystem.class);
			startActivity(intent);
		}
		return super.onOptionsItemSelected(item);
	}
}	
