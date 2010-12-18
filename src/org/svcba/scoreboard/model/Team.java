package org.svcba.scoreboard.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.svcba.scoreboard.R;

public class Team
{
	private List<Map<String, Object>> _players;
	private List<Map<String, Object>> _oncourt;
	private List<Map<String, Object>> _offcourt;
	private String _name;
	
	public Team()
	{
		_players = new ArrayList<Map<String, Object>>();
		_oncourt = new ArrayList<Map<String, Object>>();
		_offcourt = new ArrayList<Map<String, Object>>();
		for (int i = 0; i<5; i++)
		{
			_oncourt.add(empty());
		}
		_name = "";
	}
	
	public void setName(String name)
	{
		_name = name;
	}
	
	public String getName()
	{
		return _name;
	}
	
	public List<Map<String, Object>> getAllPlayers()
	{
		return _players;
	}
	
	public List<Map<String, Object>> getOnCourt()
	{
		return _oncourt;
	}
	
	public List<Map<String, Object>> getOffCourt()
	{
		return _offcourt;
	}
	public void addPlayer(Map<String, Object> player)
	{
		_players.add(player);
		_offcourt.add(player);
	}
	public void moveToCourt(int pos)
	{
		boolean full = true;
		for (Map<String, Object> p : _oncourt)
		{
			if (p.get("number").equals(-1))
			{
				full = false;
				break;
			}
		}
		if (full)
		{
			return ;
		}
		for (Map<String, Object> p : _oncourt)
		{
			if (p.get("number").equals(-1))
			{
				_oncourt.remove(p);
				Map<String, Object> np = _offcourt.get(pos);
				_offcourt.remove(pos);
				_oncourt.add(np);
				break;
			}
		}
	}
	public void moveFromCourt(int pos)
	{
		if (_oncourt.get(pos).get("number").equals(-1))
		{
			return ;
		}
		Map<String, Object> player = _oncourt.get(pos);
		_oncourt.remove(pos);
		_oncourt.add(empty());
		_offcourt.add(player);
	}
	private Map<String, Object> empty()
	{
		Map<String,Object> empty = new HashMap<String, Object>();
		empty.put("name", "");
		empty.put("number", -1);
		empty.put("avator", R.drawable.avator);
		return empty;
	}
}
