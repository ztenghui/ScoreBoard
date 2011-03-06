package org.svcba.scoreboard.model;

import java.io.Serializable;
import java.util.Map;

public class Action implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -990090120097041783L;
	//.getResult
	static final public int MISS = 0;
	static final public int MADE = 1;
	
	static final public int TIMEOUT = 0;
	static final public int SUB_OFF = 1;
	static final public int SUB_ON = 2;
	static final public int FOUL = 3;
	static final public int TURNOVER = 4;
	static final public int SHOOT_1 = 5;
	static final public int SHOOT_2 = 6;
	static final public int SHOOT_3 = 7;
	static final public int REBOUND_F = 8;
	static final public int REBOUND_B = 9;
	static final public int ASSIST = 10;
	static final public int STEAL = 11;
	// getSide()
	static final public int HOME = 0;
	static final public int AWAY = 1;
	
	private long _time;
	private int _quarter;
	private int _moment;
	private int _action;
	private Team _team;
	private Map<String, Object> _who;
	private int _result;
	private int _side;
	
	public void setAction(int a)
	{
		_action = a;
	}
	
	public void setTeam(Team a)
	{
		_team = a;
	}
	public void setSide(int side)
	{
		_side = side;
	}
	public int getSide()
	{
		return _side;
	}
	public void setTime(long time, int quarter, int moment)
	{
		_time = time;
		_quarter = quarter;
		_moment = moment;
	}
	
	public void setPlayer(Map<String, Object> player)
	{
		_who = player;
	}
	
	public void setResult(int result)
	{
		_result = result;
	}
	
	public int getAction()
	{
		return _action;
	}
	
	public Team getTeam()
	{
		return _team;
	}
	
	public long getTime()
	{
		return _time;
	}
	
	public int getQuarter()
	{
		return _quarter;
	}
	
	public int getMoment()
	{
		return _moment;
	}
	
	public Map<String, Object> getPlayer()
	{
		return _who;
	}
	
	public int getResult()
	{
		return _result;
	}
}
