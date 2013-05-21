package com.macya.multimedia.music;

import com.macya.multimediasystem.MultiMediaSystem;
import com.macya.multimediasystem.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MusicPlayerActivity extends Activity {

	// 播放功能需要的相关变量成员
	private ImageButton pause = null;
	private ImageButton stop = null;
	private TextView info = null;
	private MediaPlayer player = null;
	private boolean pauseFlag = false;
	private boolean playFlag = false;

	// 构建ListView 需要的相关成员变量
	private int[] pic = { R.drawable.ic_launcher, R.drawable.ic_launcher,
			R.drawable.ic_launcher };
	private int[] music = { R.raw.music, R.raw.music, R.raw.music };
	private String musicData[][] = { { "秋天的通话", "4:05" }, { "天空之城", "3:50" },
			{ "秋日私语", "3:20" } };
	private List<Map<String, String>> list = new ArrayList<Map<String, String>>();
	private ListView musicList = null;
	private SimpleAdapter adapter = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_musicplayer);

		// 取得各组件
		this.musicList = (ListView) super.findViewById(R.id.musiclist);
		this.pause = (ImageButton) super.findViewById(R.id.pauseBut);
		this.stop = (ImageButton) super.findViewById(R.id.stopBut);
		this.info = (TextView) super.findViewById(R.id.stateInfo);

		/**
		 * 给List中添加数据
		 */
		for (int i = 0; i < this.musicData.length; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("picture", String.valueOf(this.pic[i]));
			map.put("title", this.musicData[i][0]);
			map.put("time", this.musicData[i][1]);
			this.list.add(map);// 将mp3数据添加进list中
		}

		/**
		 * 实例化SimpleAdapter
		 */
		this.adapter = new SimpleAdapter(this, this.list, R.layout.music_list,
				new String[] { "picture", "title", "time" }, new int[] {
						R.id.musicPic, R.id.title, R.id.time });
		this.musicList.setAdapter(adapter);
		this.musicList.setOnItemClickListener(new MusicItemClick());
		
		this.pause.setOnClickListener(new PauseOnClickListener());
		this.stop.setOnClickListener(new StopOnClickListener());
	}
	
	private void addMusicItem(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("picture", String.valueOf(this.pic[0]));
		map.put("title", "青花瓷");
		map.put("time", "3:20");
		this.list.add(map);
		this.adapter.notifyDataSetChanged();//更新列表数据
	}
	
	
	/**
	 * realize the action of item which was clicked 
	 * @author SAMSUNG
	 *
	 */
	private class MusicItemClick implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			MusicPlayerActivity.this.player = MediaPlayer.create(MusicPlayerActivity.this, music[position]);
			
			//停止播放
			if(MusicPlayerActivity.this.player != null){
				MusicPlayerActivity.this.player.stop();	
			}
			
			MusicPlayerActivity.this.player.setOnCompletionListener(new OnCompletionListener(){
				@Override
				public void onCompletion(MediaPlayer arg0) {
					// TODO Auto-generated method stub
					MusicPlayerActivity.this.playFlag = false;	//播放完毕
					MusicPlayerActivity.this.player.release();	//释放资源
				}
			});
			
			//播放操作
			if(!MusicPlayerActivity.this.playFlag){
				try{
					MusicPlayerActivity.this.player.prepare();		//进入到预备状态
					MusicPlayerActivity.this.player.start();		//播放文件
					MusicPlayerActivity.this.info.setText("正在播放音频文件...");
				//	MusicPlayerActivity.this.playFlag = true;
				}catch(Exception e){
					MusicPlayerActivity.this.info.setText("文件播放出现异常"+e);
				}
			}
		}
		
	}
	
	/**
	 * 暂停按钮触发事件
	 * @author SAMSUNG
	 *
	 */
	private class PauseOnClickListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			if(MusicPlayerActivity.this.player != null){
				if(MusicPlayerActivity.this.pauseFlag){				//为true表示由暂停变为播放
					MusicPlayerActivity.this.player.start();		//播放文件	
					MusicPlayerActivity.this.pauseFlag = false;		//修改标记位
				}else{												//为false表示由播放变为暂停
					MusicPlayerActivity.this.player.pause();		//暂停播放
					MusicPlayerActivity.this.pauseFlag = true;		//修改标记位
				}
			}
		}
	}
	
	/**
	 * 停止按钮触发事件
	 * @author SAMSUNG
	 *
	 */
	private class StopOnClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(MusicPlayerActivity.this.player != null){
				MusicPlayerActivity.this.player.stop();
				MusicPlayerActivity.this.playFlag = false;
				MusicPlayerActivity.this.info.setText("停止播放音频文件...");
			}
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		menu.add(Menu.NONE,Menu.FIRST+1,1,"Return to MainMenu");
		menu.add(Menu.NONE,Menu.FIRST+2,2,"Add music item");
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		if(item.getItemId() == Menu.FIRST+1){
			Intent intent = new Intent();
			intent.setClass(MusicPlayerActivity.this, MultiMediaSystem.class);
			startActivity(intent);
		}else if(item.getItemId() == Menu.FIRST+2){
			this.addMusicItem();
		}
		return super.onOptionsItemSelected(item);
	}
}
