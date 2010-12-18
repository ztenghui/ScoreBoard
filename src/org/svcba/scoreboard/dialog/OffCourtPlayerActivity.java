package org.svcba.scoreboard.dialog;

import org.svcba.scoreboard.R;
import org.svcba.scoreboard.SVCBAApp;
import org.svcba.scoreboard.model.Game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class OffCourtPlayerActivity extends Activity
{
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dlg_offcourt_player);
		
		Game game = ((SVCBAApp)getApplicationContext()).getGame();
		ListView lv = (ListView)findViewById(R.id.offcourt_player);
		SimpleAdapter sa;
		Intent intent = getIntent();
		int team = intent.getIntExtra("team", 0);
		if (team == ShootPlayerActivity.RESULT_HOMETEAM)
		{
			sa = new SimpleAdapter(this, game.getHomeTeam().getOffCourt(),R.layout.list_player,new String[]{"name","avator"},new int[]{R.id.list_player_name,R.id.list_player_img});
		}
		else
		{
			sa = new SimpleAdapter(this, game.getAwayTeam().getOffCourt(),R.layout.list_player,new String[]{"name","avator"},new int[]{R.id.list_player_name,R.id.list_player_img});
		}
		lv.setAdapter(sa);
		lv.setOnItemClickListener(new OnItemClickListener(){

			public void onItemClick(AdapterView<?> parent, View v, int pos, long id)
			{
				Intent intent = getIntent();
				intent.putExtra("pos", pos);
				setResult(RESULT_OK, intent);
				finish();
			}
			
		});
	}
}
