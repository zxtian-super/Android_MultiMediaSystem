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

	// ���Ź�����Ҫ����ر�����Ա
	private ImageButton pause = null;
	private ImageButton stop = null;
	private TextView info = null;
	private MediaPlayer player = null;
	private boolean pauseFlag = false;
	private boolean playFlag = false;

	// ����ListView ��Ҫ����س�Ա����
	private int[] pic = { R.drawable.ic_launcher, R.drawable.ic_launcher,
			R.drawable.ic_launcher };
	private int[] music = { R.raw.music, R.raw.music, R.raw.music };
	private String musicData[][] = { { "�����ͨ��", "4:05" }, { "���֮��", "3:50" },
			{ "����˽��", "3:20" } };
	private List<Map<String, String>> list = new ArrayList<Map<String, String>>();
	private ListView musicList = null;
	private SimpleAdapter adapter = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_musicplayer);

		// ȡ�ø����
		this.musicList = (ListView) super.findViewById(R.id.musiclist);
		this.pause = (ImageButton) super.findViewById(R.id.pauseBut);
		this.stop = (ImageButton) super.findViewById(R.id.stopBut);
		this.info = (TextView) super.findViewById(R.id.stateInfo);

		/**
		 * ��List���������
		 */
		for (int i = 0; i < this.musicData.length; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("picture", String.valueOf(this.pic[i]));
			map.put("title", this.musicData[i][0]);
			map.put("time", this.musicData[i][1]);
			this.list.add(map);// ��mp3������ӽ�list��
		}

		/**
		 * ʵ����SimpleAdapter
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
		map.put("title", "�໨��");
		map.put("time", "3:20");
		this.list.add(map);
		this.adapter.notifyDataSetChanged();//�����б�����
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
			
			//ֹͣ����
			if(MusicPlayerActivity.this.player != null){
				MusicPlayerActivity.this.player.stop();	
			}
			
			MusicPlayerActivity.this.player.setOnCompletionListener(new OnCompletionListener(){
				@Override
				public void onCompletion(MediaPlayer arg0) {
					// TODO Auto-generated method stub
					MusicPlayerActivity.this.playFlag = false;	//�������
					MusicPlayerActivity.this.player.release();	//�ͷ���Դ
				}
			});
			
			//���Ų���
			if(!MusicPlayerActivity.this.playFlag){
				try{
					MusicPlayerActivity.this.player.prepare();		//���뵽Ԥ��״̬
					MusicPlayerActivity.this.player.start();		//�����ļ�
					MusicPlayerActivity.this.info.setText("���ڲ�����Ƶ�ļ�...");
				//	MusicPlayerActivity.this.playFlag = true;
				}catch(Exception e){
					MusicPlayerActivity.this.info.setText("�ļ����ų����쳣"+e);
				}
			}
		}
		
	}
	
	/**
	 * ��ͣ��ť�����¼�
	 * @author SAMSUNG
	 *
	 */
	private class PauseOnClickListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			if(MusicPlayerActivity.this.player != null){
				if(MusicPlayerActivity.this.pauseFlag){				//Ϊtrue��ʾ����ͣ��Ϊ����
					MusicPlayerActivity.this.player.start();		//�����ļ�	
					MusicPlayerActivity.this.pauseFlag = false;		//�޸ı��λ
				}else{												//Ϊfalse��ʾ�ɲ��ű�Ϊ��ͣ
					MusicPlayerActivity.this.player.pause();		//��ͣ����
					MusicPlayerActivity.this.pauseFlag = true;		//�޸ı��λ
				}
			}
		}
	}
	
	/**
	 * ֹͣ��ť�����¼�
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
				MusicPlayerActivity.this.info.setText("ֹͣ������Ƶ�ļ�...");
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
