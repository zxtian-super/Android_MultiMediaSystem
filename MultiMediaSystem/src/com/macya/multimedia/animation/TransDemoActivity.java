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
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class TransDemoActivity extends Activity {

	private ImageView transImage = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.animation_trans);

		this.transImage = (ImageView) super.findViewById(R.id.transImage);
		this.transImage.setOnClickListener(new TransShow());

	}

	private class TransShow implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			AnimationSet set = new AnimationSet(true);
			TranslateAnimation translate = new TranslateAnimation(
					Animation.RELATIVE_TO_SELF, 0.0f,		//x轴开始位置
					Animation.RELATIVE_TO_SELF, 0.5f,		//x轴结束位置
					Animation.RELATIVE_TO_SELF, 0.0f,		//y轴开始位置
					Animation.RELATIVE_TO_SELF, 0.5f);		//y轴结束位置
			translate.setDuration(3000);
			set.addAnimation(translate);
			TransDemoActivity.this.transImage.startAnimation(set);
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
			intent.setClass(TransDemoActivity.this, AnimationActivity.class);
			startActivity(intent);
		}
		return super.onOptionsItemSelected(item);
	}

}
