package org.svcba.scoreboard.dialog;

import org.svcba.scoreboard.R;
import org.svcba.scoreboard.SVCBAApp;
import org.svcba.scoreboard.model.Action;
import org.svcba.scoreboard.model.Game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class AssistActivity extends Activity
{
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setTitle(R.string.assist);
		setContentView(R.layout.dlg_assist);
		
		Game game = ((SVCBAApp)getApplicationContext()).getGame();
		Intent intent = getIntent();
		int team = intent.getIntExtra("team", 0);
		SimpleAdapter sa;
		if (team == Action.HOME)
		{
			sa = new SimpleAdapter(this, game.getHomeTeam().getOnCourt(),R.layout.list_player,new String[]{"name","avator"},new int[]{R.id.list_player_name,R.id.list_player_img});
		}
		else
		{
			sa = new SimpleAdapter(this, game.getAwayTeam().getOnCourt(),R.layout.list_player,new String[]{"name","avator"},new int[]{R.id.list_player_name,R.id.list_player_img});
		}
		ListView lv = (ListView)findViewById(R.id.list_assist);
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
