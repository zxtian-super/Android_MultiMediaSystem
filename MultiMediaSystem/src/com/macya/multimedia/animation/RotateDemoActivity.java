package com.macya.multimedia.animation;

import com.macya.multimediasystem.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class RotateDemoActivity extends Activity{
	
	private ImageView rotataImage = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.animation_rotate);
		
		this.rotataImage = (ImageView)super.findViewById(R.id.rotateImage);
		this.rotataImage.setOnClickListener(new RotateShow());
	}
	
	private class RotateShow implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			AnimationSet set = new AnimationSet(true);
			RotateAnimation rotate = new RotateAnimation(0,360,Animation.RELATIVE_TO_PARENT,0.5f,Animation.RELATIVE_TO_PARENT,0.3f);
			rotate.setDuration(3000);
			set.addAnimation(rotate);
			RotateDemoActivity.this.rotataImage.startAnimation(set);
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		menu.add(Menu.NONE,Menu.FIRST+1,1,"Return to Animation");
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		if(item.getItemId() == Menu.FIRST+1){
			Intent intent = new Intent();
			intent.setClass(RotateDemoActivity.this, AnimationActivity.class);
			startActivity(intent);
		}
		return super.onOptionsItemSelected(item);
	}
	
}
