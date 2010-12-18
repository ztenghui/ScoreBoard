package org.svcba.scoreboard.model;

import java.util.ArrayList;
import java.util.List;

public class Roster
{
	private List<Team> _teams;
	
	public Roster()
	{
		_teams = new ArrayList<Team>();
	}
	
	public List<Team> getAllTeams()
	{
		return _teams;
	}
	
	public void addTeam(Team team)
	{
		_teams.add(team);
	}
	
	public Team getTeamAt(int pos)
	{
		return _teams.get(pos);
	}
}
