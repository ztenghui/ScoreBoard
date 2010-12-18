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

public class TimeoutActivity extends Activity
{
	public static final int RESULT_HOMETEAM = 0;
	public static final int RESULT_AWAYTEAM = 1;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dlg_timeout);
		Game game = ((SVCBAApp)getApplicationContext()).getGame();
		Button btn = (Button)findViewById(R.id.btn_timeout_hometeam);
		btn.setText(game.getHomeTeam().getName());
		btn.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0)
			{
				Intent intent = getIntent();
				intent.putExtra("team", RESULT_HOMETEAM);
				setResult(RESULT_OK,intent);
				finish();
			}
			
		});
		btn = (Button)findViewById(R.id.btn_timeout_awayteam);
		btn.setText(game.getAwayTeam().getName());
		btn.setOnClickListener(new OnClickListener(){

			public void onClick(View v)
			{
				Intent intent = getIntent();
				intent.putExtra("team", RESULT_AWAYTEAM);
				setResult(RESULT_OK,intent);
				finish();
			}
			
		});
	}
	
}
