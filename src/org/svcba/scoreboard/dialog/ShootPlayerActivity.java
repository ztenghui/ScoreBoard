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

public class ShootPlayerActivity extends Activity
{
	public static final int RESULT_HOMETEAM = 0;
	public static final int RESULT_AWAYTEAM = 1;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.dlg_shoot);
		Game game = ((SVCBAApp)getApplicationContext()).getGame();
		ListView lv = (ListView)findViewById(R.id.hometeam_selection);
		SimpleAdapter sa = new SimpleAdapter(this, game.getHomeTeam().getOnCourt(),R.layout.hometeam_selection, new String[]{"name","avator"},new int[]{R.id.hometeam_selection_name,R.id.hometeam_selection_img});
		lv.setAdapter(sa);
		lv.setOnItemClickListener(new OnItemClickListener(){

			public void onItemClick(AdapterView<?> parent, View view, int pos, long id)
			{
				Intent intent = getIntent();
				intent.putExtra("team", RESULT_HOMETEAM);
				intent.putExtra("pos", pos);
				setResult(RESULT_OK, intent);
				finish();
			}
			
		});
		lv = (ListView)findViewById(R.id.awayteam_selection);
		sa = new SimpleAdapter(this, game.getAwayTeam().getOnCourt(), R.layout.awayteam_selection, new String[]{"name", "avator"}, new int[]{R.id.awayteam_selection_name, R.id.awayteam_selection_img});
		lv.setAdapter(sa);
		lv.setOnItemClickListener(new OnItemClickListener(){

			public void onItemClick(AdapterView<?> parent, View view, int pos, long id)
			{
				Intent intent = getIntent();
				intent.putExtra("team", RESULT_AWAYTEAM);
				intent.putExtra("pos", pos);
				setResult(RESULT_OK, intent);
				finish();
			}
			
		});
	}
}
