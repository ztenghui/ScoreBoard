package org.svcba.scoreboard;

import java.util.HashMap;
import java.util.Map;

import org.svcba.scoreboard.dialog.AddPlayerActivity;
import org.svcba.scoreboard.model.Game;
import org.svcba.scoreboard.model.Roster;
import org.svcba.scoreboard.model.Team;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;

public class ScoreBoard extends TabActivity {
	
	private Roster _roster;
	private Game _game;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main);

        SVCBAApp app = (SVCBAApp)getApplicationContext();
        _roster = app.getRoster();
        _game = app.getGame();
        initData();
        Resources res = getResources();
        
        Spinner spin = (Spinner)findViewById(R.id.spin_hometeam);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.team_name_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setOnItemSelectedListener(new OnItemSelectedListener(){
        	public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
        	{
        		Team team = _roster.getTeamAt(pos);
        		_game.setHomeTeam(team);
                GridView gv = (GridView)findViewById(R.id.grid_hometeam_starting_lineup);
                SimpleAdapter sa = new SimpleAdapter(parent.getContext(), _game.getHomeTeam().getOnCourt(), R.layout.starting_lineup, new String[]{"name", "avator"}, new int[]{R.id.name, R.id.img});
                gv.setAdapter(sa);
            	ListView lv = (ListView)findViewById(R.id.list_hometeam_player);
                sa = new SimpleAdapter(parent.getContext(), _game.getHomeTeam().getOffCourt(),R.layout.list_player,new String[]{"name","avator"},new int[]{R.id.list_player_name,R.id.list_player_img});
                lv.setAdapter(sa);
        	}
        	public void onNothingSelected(AdapterView<?> parent)
        	{
        		
        	}
        });
        spin.setAdapter(adapter);
        
        spin = (Spinner)findViewById(R.id.spin_awayteam);
        adapter = ArrayAdapter.createFromResource(this, R.array.team_name_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new OnItemSelectedListener(){
        	public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
        	{
        		Team team = _roster.getTeamAt(pos);
        		_game.setAwayTeam(team);
                GridView gv = (GridView)findViewById(R.id.grid_awayteam_starting_lineup);
                SimpleAdapter sa = new SimpleAdapter(parent.getContext(), _game.getAwayTeam().getOnCourt(), R.layout.starting_lineup, new String[]{"name", "avator"}, new int[]{R.id.name, R.id.img});
                gv.setAdapter(sa);
            	ListView lv = (ListView)findViewById(R.id.list_awayteam_player);
                sa = new SimpleAdapter(parent.getContext(), _game.getAwayTeam().getOffCourt(),R.layout.list_player,new String[]{"name","avator"},new int[]{R.id.list_player_name,R.id.list_player_img});
                lv.setAdapter(sa);
        	}
        	public void onNothingSelected(AdapterView<?> parent)
        	{
        		
        	}
        });
        
        spin = (Spinner)findViewById(R.id.spin_hometeam_color);
        adapter = ArrayAdapter.createFromResource(this, R.array.team_color_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setSelection(0);
        spin.setOnItemSelectedListener(new OnItemSelectedListener(){

			public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
			{
				if (pos == 0)
					_game.setHomeColor(Game.COLOR_DARK);
				else if (pos == 1)
					_game.setHomeColor(Game.COLOR_WHITE);
			}

			public void onNothingSelected(AdapterView<?> arg0)
			{
				
			}
        	
        });
        
        spin = (Spinner)findViewById(R.id.spin_awayteam_color);
        adapter = ArrayAdapter.createFromResource(this, R.array.team_color_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setSelection(1);
        spin.setOnItemSelectedListener(new OnItemSelectedListener(){

			public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
			{
				if (pos == 0)
					_game.setAwayColor(Game.COLOR_DARK);
				else if (pos == 1)
					_game.setAwayColor(Game.COLOR_WHITE);
			}

			public void onNothingSelected(AdapterView<?> arg0)
			{
				
			}
        	
        });

        GridView gridview = (GridView)findViewById(R.id.grid_hometeam_starting_lineup);
        SimpleAdapter sa = new SimpleAdapter(this, _game.getHomeTeam().getOnCourt(), R.layout.starting_lineup, new String[]{"name", "avator"}, new int[]{R.id.name, R.id.img});
        gridview.setAdapter(sa);
        gridview.setOnItemClickListener(new OnItemClickListener(){

			public void onItemClick(AdapterView<?> parent, View view, int pos, long id) 
			{
				_game.getHomeTeam().moveFromCourt(pos);
                GridView gv = (GridView)findViewById(R.id.grid_hometeam_starting_lineup);
                SimpleAdapter sa = new SimpleAdapter(parent.getContext(), _game.getHomeTeam().getOnCourt(), R.layout.starting_lineup, new String[]{"name", "avator"}, new int[]{R.id.name, R.id.img});
                gv.setAdapter(sa);
            	ListView lv = (ListView)findViewById(R.id.list_hometeam_player);
                sa = new SimpleAdapter(parent.getContext(), _game.getHomeTeam().getOffCourt(),R.layout.list_player,new String[]{"name","avator"},new int[]{R.id.list_player_name,R.id.list_player_img});
                lv.setAdapter(sa);
			}
        	
        });
        
        ListView listview = (ListView)findViewById(R.id.list_hometeam_player);
        sa = new SimpleAdapter(this, _game.getHomeTeam().getOffCourt(),R.layout.list_player,new String[]{"name","avator"},new int[]{R.id.list_player_name,R.id.list_player_img});
        listview.setAdapter(sa);
        listview.setOnItemClickListener(new OnItemClickListener(){
			public void onItemClick(AdapterView<?> parent, View view, int pos, long id) 
			{
				Team team = _game.getHomeTeam();
				team.moveToCourt(pos);
                GridView gv = (GridView)findViewById(R.id.grid_hometeam_starting_lineup);
                SimpleAdapter sa = new SimpleAdapter(parent.getContext(), _game.getHomeTeam().getOnCourt(), R.layout.starting_lineup, new String[]{"name", "avator"}, new int[]{R.id.name, R.id.img});
                gv.setAdapter(sa);
            	ListView lv = (ListView)findViewById(R.id.list_hometeam_player);
                sa = new SimpleAdapter(parent.getContext(), _game.getHomeTeam().getOffCourt(),R.layout.list_player,new String[]{"name","avator"},new int[]{R.id.list_player_name,R.id.list_player_img});
                lv.setAdapter(sa);
			}
        });

        gridview = (GridView)findViewById(R.id.grid_awayteam_starting_lineup);
        sa = new SimpleAdapter(this, _game.getAwayTeam().getOnCourt(), R.layout.starting_lineup, new String[]{"name", "avator"}, new int[]{R.id.name, R.id.img});
        gridview.setAdapter(sa);
        gridview.setOnItemClickListener(new OnItemClickListener(){

			public void onItemClick(AdapterView<?> parent, View view, int pos, long id) 
			{
				_game.getAwayTeam().moveFromCourt(pos);
                GridView gv = (GridView)findViewById(R.id.grid_awayteam_starting_lineup);
                SimpleAdapter sa = new SimpleAdapter(parent.getContext(), _game.getAwayTeam().getOnCourt(), R.layout.starting_lineup, new String[]{"name", "avator"}, new int[]{R.id.name, R.id.img});
                gv.setAdapter(sa);
            	ListView lv = (ListView)findViewById(R.id.list_awayteam_player);
                sa = new SimpleAdapter(parent.getContext(), _game.getAwayTeam().getOffCourt(),R.layout.list_player,new String[]{"name","avator"},new int[]{R.id.list_player_name,R.id.list_player_img});
                lv.setAdapter(sa);
			}
        	
        });

        listview = (ListView)findViewById(R.id.list_awayteam_player);
        sa = new SimpleAdapter(this, _game.getAwayTeam().getOffCourt(),R.layout.list_player,new String[]{"name","avator"},new int[]{R.id.list_player_name,R.id.list_player_img});
        listview.setAdapter(sa);
        listview.setOnItemClickListener(new OnItemClickListener(){
			public void onItemClick(AdapterView<?> parent, View view, int pos, long id) 
			{
				Team team = _game.getAwayTeam();
				team.moveToCourt(pos);
                GridView gv = (GridView)findViewById(R.id.grid_awayteam_starting_lineup);
                SimpleAdapter sa = new SimpleAdapter(parent.getContext(), _game.getAwayTeam().getOnCourt(), R.layout.starting_lineup, new String[]{"name", "avator"}, new int[]{R.id.name, R.id.img});
                gv.setAdapter(sa);
            	ListView lv = (ListView)findViewById(R.id.list_awayteam_player);
                sa = new SimpleAdapter(parent.getContext(), _game.getAwayTeam().getOffCourt(),R.layout.list_player,new String[]{"name","avator"},new int[]{R.id.list_player_name,R.id.list_player_img});
                lv.setAdapter(sa);
			}
        });
        
        TabHost tabhost = getTabHost();
        tabhost.addTab(tabhost.newTabSpec("tab_1").setIndicator(res.getText(R.string.hometeam),res.getDrawable(R.drawable.ic_tab_home)).setContent(R.id.tab_hometeam));
        tabhost.addTab(tabhost.newTabSpec("tab_2").setIndicator(res.getText(R.string.awayteam),res.getDrawable(R.drawable.ic_tab_away)).setContent(R.id.tab_awayteam));
        tabhost.addTab(tabhost.newTabSpec("tab_3").setIndicator(res.getText(R.string.game),res.getDrawable(R.drawable.ic_tab_game)).setContent(R.id.tab_game));
        
        Button button = (Button)findViewById(R.id.btn_setup_done);
        button.setOnClickListener(new OnClickListener(){

			public void onClick(View view)
			{
				if (_game.getHomeColor() == _game.getAwayColor())
				{
					showError(view, R.string.err_same_color);
					return ;
				}
				if (_game.getHomeTeam() == _game.getAwayTeam())
				{
					showError(view, R.string.err_same_team);
					return ;
				}
				Team team = _game.getHomeTeam();
				for (Map<String, Object> p : team.getOnCourt())
				{
					if (p.get("number").equals(-1))
					{
						showError(view, R.string.err_hometeam_starting_lineup_not_full);
						return ;
					}
				}
				team = _game.getAwayTeam();
				for (Map<String, Object> p : team.getOnCourt())
				{
					if (p.get("number").equals(-1))
					{
						showError(view, R.string.err_awayteam_starting_lineup_not_full);
						return ;
					}
				}
				Intent intent = new Intent(view.getContext(),ReadyActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
				finish();
				
			}
        	private void showError(View view, int message)
        	{
        		Toast.makeText(view.getContext(), message, Toast.LENGTH_LONG).show();
        	}
        });
    }
    
    protected void onResume()
    {
    	super.onResume();
    	
        ListView listview = (ListView)findViewById(R.id.list_hometeam_player);
        SimpleAdapter sa = new SimpleAdapter(this, _game.getHomeTeam().getOffCourt(),R.layout.list_player,new String[]{"name","avator"},new int[]{R.id.list_player_name,R.id.list_player_img});
        listview.setAdapter(sa);
    	
        listview = (ListView)findViewById(R.id.list_awayteam_player);
        sa = new SimpleAdapter(this, _game.getAwayTeam().getOffCourt(),R.layout.list_player,new String[]{"name","avator"},new int[]{R.id.list_player_name,R.id.list_player_img});
        listview.setAdapter(sa);
    }
    
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        case R.id.menu_quit:
        	System.exit(0);
            return true;
        case R.id.menu_add_player:
        	Intent intent = new Intent(this, AddPlayerActivity.class);
        	startActivity(intent);
        	return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    
    private void initData()
    {
    	
    	Resources res = getResources();
    	
    	Team team = new Team();
    	team.setName(res.getStringArray(R.array.team_name_array)[0]);
    	String[] players = res.getStringArray(R.array.qinglong_player);
    	for(int i = 0; i < players.length; i++)
    	{
    		Map<String, Object> player = new HashMap<String, Object>();
    		player.put("name", players[i]);
    		player.put("number", i+1);
    		player.put("avator", R.drawable.avator);
    		team.addPlayer(player);
    	}
    	_roster.addTeam(team);
    	_game.setHomeTeam(team);
    	_game.setAwayTeam(team);
    	
    	team = new Team();
    	team.setName(res.getStringArray(R.array.team_name_array)[1]);
    	players = res.getStringArray(R.array.linshigong_player);
    	for(int i = 0; i < players.length; i++)
    	{
    		Map<String, Object> player = new HashMap<String, Object>();
    		player.put("name", players[i]);
    		player.put("number", i+1);
    		player.put("avator", R.drawable.avator);
    		team.addPlayer(player);
    	}
    	_roster.addTeam(team);
    	
    	team = new Team();
    	team.setName(res.getStringArray(R.array.team_name_array)[2]);
    	players = res.getStringArray(R.array.zhuque_player);
    	for(int i = 0; i < players.length; i++)
    	{
    		Map<String, Object> player = new HashMap<String, Object>();
    		player.put("name", players[i]);
    		player.put("number", i+1);
    		player.put("avator", R.drawable.avator);
    		team.addPlayer(player);
    	}
    	_roster.addTeam(team);

    	team = new Team();
    	team.setName(res.getStringArray(R.array.team_name_array)[3]);
    	players = res.getStringArray(R.array.xuanwu_player);
    	for(int i = 0; i < players.length; i++)
    	{
    		Map<String, Object> player = new HashMap<String, Object>();
    		player.put("name", players[i]);
    		player.put("number", i+1);
    		player.put("avator", R.drawable.avator);
    		team.addPlayer(player);
    	}
    	_roster.addTeam(team);

    	team = new Team();
    	team.setName(res.getStringArray(R.array.team_name_array)[4]);
    	players = res.getStringArray(R.array.dijiu_player);
    	for(int i = 0; i < players.length; i++)
    	{
    		Map<String, Object> player = new HashMap<String, Object>();
    		player.put("name", players[i]);
    		player.put("number", i+1);
    		player.put("avator", R.drawable.avator);
    		team.addPlayer(player);
    	}
    	_roster.addTeam(team);

    	team = new Team();
    	team.setName(res.getStringArray(R.array.team_name_array)[5]);
    	players = res.getStringArray(R.array.berkeley_player);
    	for(int i = 0; i < players.length; i++)
    	{
    		Map<String, Object> player = new HashMap<String, Object>();
    		player.put("name", players[i]);
    		player.put("number", i+1);
    		player.put("avator", R.drawable.avator);
    		team.addPlayer(player);
    	}
    	_roster.addTeam(team);
    	
    	team = new Team();
    	team.setName(res.getStringArray(R.array.team_name_array)[6]);
    	players = res.getStringArray(R.array.sjsu_player);
    	for(int i = 0; i < players.length; i++)
    	{
    		Map<String, Object> player = new HashMap<String, Object>();
    		player.put("name", players[i]);
    		player.put("number", i+1);
    		player.put("avator", R.drawable.avator);
    		team.addPlayer(player);
    	}
    	_roster.addTeam(team);
    	
    	team = new Team();
    	team.setName(res.getStringArray(R.array.team_name_array)[7]);
    	players = res.getStringArray(R.array.titan_player);
    	for(int i = 0; i < players.length; i++)
    	{
    		Map<String, Object> player = new HashMap<String, Object>();
    		player.put("name", players[i]);
    		player.put("number", i+1);
    		player.put("avator", R.drawable.avator);
    		team.addPlayer(player);
    	}
    	_roster.addTeam(team);
    	
    }
    
}