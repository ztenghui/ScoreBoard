package org.svcba.scoreboard.model;

public class PlayerStat
{
	private String _name;
	private int _1p_made;
	private int _1p_shoot;
	private int _2p_made;
	private int _2p_shoot;
	private int _3p_made;
	private int _3p_shoot;
	private int _p;
	private int _rb_f;
	private int _rb_b;
	private int _f;
	private int _to;
	private int _ass;
	private int _stl;
	public PlayerStat()
	{
		_1p_made = 0;
		_1p_shoot = 0;
		_2p_made = 0;
		_2p_shoot = 0;
		_3p_made = 0;
		_3p_shoot = 0;
		_p = 0;
		_rb_f = 0;
		_rb_b = 0;
		_f = 0;
		_to = 0;
		_ass = 0;
		_stl = 0;
	}
	public String getName()
	{
		return _name;
	}
	
	public void setName(String name)
	{
		_name = name;
	}
	
	public String get1P()
	{
		return ""+_1p_made+"/"+_1p_shoot;
	}
	public String get2P()
	{
		return ""+_2p_made+"/"+_2p_shoot;
	}
	public String get3P()
	{
		return ""+_3p_made+"/"+_3p_shoot;
	}
	public String getP()
	{
		return ""+_p;
	}
	public String getRB()
	{
		return ""+_rb_f+"/"+_rb_b;
	}
	public String getF()
	{
		return ""+_f;
	}
	public String getTO()
	{
		return ""+_to;
	}
	public String getAssist()
	{
		return "" + _ass;
	}
	public String getSteal()
	{
		return "" + _stl;
	}
	public void add1PMade()
	{
		_1p_shoot ++;
		_1p_made ++;
		_p ++;
	}
	public void add1PMiss()
	{
		_1p_shoot ++;
	}
	public void add2PMade()
	{
		_2p_shoot ++;
		_2p_made ++;
		_p += 2;
	}
	public void add2PMiss()
	{
		_2p_shoot ++;
	}
	public void add3PMade()
	{
		_3p_shoot ++;
		_3p_made ++;
		_p += 3;
	}
	public void add3PMiss()
	{
		_3p_shoot ++;
	}
	public void addRbF()
	{
		_rb_f ++;
	}
	public void addRbB()
	{
		_rb_b ++;
	}
	public void addF()
	{
		_f ++;
	}
	public void addTO()
	{
		_to ++;
	}
	public void addAssist()
	{
		_ass ++;
	}
	public void addSteal()
	{
		_stl ++;
	}
}
