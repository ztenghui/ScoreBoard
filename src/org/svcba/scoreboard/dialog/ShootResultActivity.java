package org.svcba.scoreboard.dialog;

import org.svcba.scoreboard.R;
import org.svcba.scoreboard.SVCBAApp;
import org.svcba.scoreboard.model.Game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ShootResultActivity extends Activity
{
	public static final int MADE = 0;
	public static final int MISS = 1;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dlg_shoot_result);
		
		Game game = ((SVCBAApp)getApplicationContext()).getGame();
		ImageView iv = (ImageView)findViewById(R.id.shoot_player_img);
		iv.setImageResource((Integer)game.getTempAction().getPlayer().get("avator"));
		
		TextView tv = (TextView)findViewById(R.id.shoot_player_name);
		tv.setText((String)game.getTempAction().getPlayer().get("name"));
		
		Button btn =(Button)findViewById(R.id.btn_shoot_made);
		btn.setOnClickListener(new OnClickListener(){

			public void onClick(View v)
			{
				Intent intent = getIntent();
				intent.putExtra("result", MADE);
				setResult(RESULT_OK, intent);
				finish();
			}
			
		});
		
		btn = (Button)findViewById(R.id.btn_shoot_miss);
		btn.setOnClickListener(new OnClickListener(){

			public void onClick(View v)
			{
				Intent intent = getIntent();
				intent.putExtra("result", MISS);
				setResult(RESULT_OK, intent);
				finish();
			}
			
		});
	}
}
