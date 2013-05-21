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
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class ScaleDemoActivity extends Activity {
	private ImageView scaleImage = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.animation_scale);

		this.scaleImage = (ImageView) super.findViewById(R.id.scaleImage);
		this.scaleImage.setOnClickListener(new ScaleShow());

	}

	private class ScaleShow implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			AnimationSet set = new AnimationSet(true);// ����һ��������
			ScaleAnimation scale = new ScaleAnimation(1, 0.0f, 1, 0.0f,		//x,y��ֱ��������С����
					Animation.RELATIVE_TO_SELF, 0.5f,			//������0.5���Ϊ������
					Animation.RELATIVE_TO_SELF, 0.5f);			//������0.5�߶�Ϊ������
			scale.setDuration(3000);
			set.addAnimation(scale);							//���Ӷ���
			ScaleDemoActivity.this.scaleImage.startAnimation(set);//��������
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
			intent.setClass(ScaleDemoActivity.this, AnimationActivity.class);
			startActivity(intent);
		}
		return super.onOptionsItemSelected(item);
	}
}
