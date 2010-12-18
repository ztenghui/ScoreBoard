package org.svcba.scoreboard.dialog;

import java.util.HashMap;
import java.util.Map;

import org.svcba.scoreboard.R;
import org.svcba.scoreboard.SVCBAApp;
import org.svcba.scoreboard.model.Roster;
import org.svcba.scoreboard.model.Team;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddPlayerActivity extends Activity
{
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dlg_add_player);
		
		Spinner spin = (Spinner)findViewById(R.id.add_player_team);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.team_name_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        
        Button btn = (Button)findViewById(R.id.btn_add_player);
        btn.setOnClickListener(new OnClickListener(){
			public void onClick(View v)
			{
				EditText edit = (EditText)findViewById(R.id.add_player_name);
				String name = edit.getText().toString();
				if (name.length() == 0)
				{
					Toast.makeText(v.getContext(), R.string.err_input_player_name, Toast.LENGTH_LONG).show();
				}
				else
				{
					Spinner s = (Spinner)findViewById(R.id.add_player_team);
					int pos = s.getSelectedItemPosition();
					Roster roster = ((SVCBAApp)getApplicationContext()).getRoster();
					Team team = roster.getTeamAt(pos);
					int number = team.getAllPlayers().size();
					Map<String, Object> player = new HashMap<String, Object>();
					player.put("name", name);
					player.put("avator", R.drawable.avator);
					player.put("number", number+1);
					team.addPlayer(player);
					finish();
				}
			}
        });

	}
}
