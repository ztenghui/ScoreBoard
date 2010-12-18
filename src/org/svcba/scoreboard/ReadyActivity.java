package org.svcba.scoreboard;

import org.svcba.scoreboard.model.Game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ReadyActivity extends Activity
{
	private Game _game;
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ready);
		
		SVCBAApp app = (SVCBAApp)getApplicationContext();
		_game = app.getGame();
		TextView tv = (TextView)findViewById(R.id.tx_hometeam);
		tv.setText(_game.getHomeTeam().getName());
		tv = (TextView)findViewById(R.id.tx_awayteam);
		tv.setText(_game.getAwayTeam().getName());
		
        Button button = (Button)findViewById(R.id.btn_start);
        button.setOnClickListener(new OnClickListener(){

			public void onClick(View view)
			{
				Intent intent = new Intent(view.getContext(),NormalActivity.class);
				startActivity(intent);
				finish();
			}
        });
	}
}
