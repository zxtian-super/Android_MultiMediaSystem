package com.macya.multimediasystem;

import com.macya.multimedia.animation.AnimationActivity;
import com.macya.multimedia.draw.*;
import com.macya.multimedia.music.MusicPlayerActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MultiMediaSystem extends Activity {

	private Button drawBut = null;
	private Button AnimationBut = null;
	private Button MusicBut = null;
	private Button VideoBut = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_multi_media_system);
		
		this.drawBut = (Button)super.findViewById(R.id.drawBut);
		this.drawBut.setOnClickListener(new DrawProject());
		
		this.AnimationBut = (Button)super.findViewById(R.id.animationBut);
		this.AnimationBut.setOnClickListener(new AnimationProject());
		
		this.MusicBut = (Button)super.findViewById(R.id.musicBut);
		this.MusicBut.setOnClickListener(new MusicProject());
		
		this.VideoBut = (Button)super.findViewById(R.id.videoBut);
		this.VideoBut.setOnClickListener(new VideoProject());
	}

	/**
	 * define the class of DrawProject
	 * jump to another activity to experience drawing
	 * @author SAMSUNG
	 *
	 */
	public class  DrawProject implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MultiMediaSystem.this, DrawActivity.class);
			startActivity(intent);
		}
		
	}
	
	/**
	 * define the class of AnimationProject
	 * realize the effect of animation
	 * all effects:alpha,scale,translate,rotate
	 * @author SAMSUNG
	 *
	 */
	public class AnimationProject implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MultiMediaSystem.this, AnimationActivity.class);
			startActivity(intent);
		}
		
	}
	
	/**
	 * define the class of MusicProject
	 * @author SAMSUNG
	 *
	 */
	public class MusicProject implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MultiMediaSystem.this, MusicPlayerActivity.class);
			startActivity(intent);
		}
		
	}
	
	/**
	 * define the class of VideoProject
	 * @author SAMSUNG
	 *
	 */
	public class VideoProject implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.multi_media_system, menu);
		return true;
	}

}
