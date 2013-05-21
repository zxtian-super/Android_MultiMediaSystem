package com.macya.multimedia.animation;

import com.macya.multimediasystem.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.ImageView;

public class AlphaDemoActivity extends Activity{
	
	private ImageView alphaImage = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.animation_alpha);
		
		this.alphaImage = (ImageView)super.findViewById(R.id.alphaImage);
		this.alphaImage.setOnClickListener(new AlphaShow());
	}
	
	private class AlphaShow implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			AnimationSet set = new AnimationSet(true);		//define an animationset
			AlphaAnimation alpha = new AlphaAnimation(1,0);	//从完全显示到完全透明
			alpha.setDuration(3000);
			set.addAnimation(alpha);
			AlphaDemoActivity.this.alphaImage.startAnimation(set);
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
			intent.setClass(AlphaDemoActivity.this, AnimationActivity.class);
			startActivity(intent);
		}
		return super.onOptionsItemSelected(item);
	}
}
