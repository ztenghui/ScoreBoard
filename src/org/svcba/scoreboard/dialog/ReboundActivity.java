package org.svcba.scoreboard.dialog;

import org.svcba.scoreboard.R;
import org.svcba.scoreboard.SVCBAApp;
import org.svcba.scoreboard.model.Game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class ReboundActivity extends Activity
{
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setTitle(R.string.rebound);
		setContentView(R.layout.dlg_rebound);
		
		Game game = ((SVCBAApp)getApplicationContext()).getGame();
		ListView lv = (ListView)findViewById(R.id.rebound_hometeam);
		SimpleAdapter sa = new SimpleAdapter(this, game.getHomeTeam().getOnCourt(),R.layout.hometeam_selection, new String[]{"name","avator"},new int[]{R.id.hometeam_selection_name,R.id.hometeam_selection_img});
		lv.setAdapter(sa);
		lv.setOnItemClickListener(new OnItemClickListener(){

			public void onItemClick(AdapterView<?> parent, View view, int pos, long id)
			{
				Intent intent = getIntent();
				intent.putExtra("team", ShootPlayerActivity.RESULT_HOMETEAM);
				intent.putExtra("shoot", intent.getIntExtra("shoot", 0));
				intent.putExtra("pos", pos);
				setResult(RESULT_OK, intent);
				finish();
			}
			
		});
		lv = (ListView)findViewById(R.id.rebound_awayteam);
		sa = new SimpleAdapter(this, game.getAwayTeam().getOnCourt(), R.layout.awayteam_selection, new String[]{"name", "avator"}, new int[]{R.id.awayteam_selection_name, R.id.awayteam_selection_img});
		lv.setAdapter(sa);
		lv.setOnItemClickListener(new OnItemClickListener(){

			public void onItemClick(AdapterView<?> parent, View view, int pos, long id)
			{
				Intent intent = getIntent();
				intent.putExtra("team", ShootPlayerActivity.RESULT_AWAYTEAM);
				intent.putExtra("shoot", intent.getIntExtra("shoot", 0));
				intent.putExtra("pos", pos);
				setResult(RESULT_OK, intent);
				finish();
			}
			
		});

	}
}
