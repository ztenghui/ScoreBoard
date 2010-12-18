package org.svcba.scoreboard;

import org.svcba.scoreboard.model.Game;
import org.svcba.scoreboard.model.Roster;

import android.app.Application;

public class SVCBAApp extends Application
{
	private Game _game;
	private Roster _roster;
	
	public SVCBAApp()
	{
		_game = new Game();
		_roster = new Roster();
	}
	public Game getGame()
	{
		return _game;
	}
	public Roster getRoster()
	{
		return _roster;
	}
}
