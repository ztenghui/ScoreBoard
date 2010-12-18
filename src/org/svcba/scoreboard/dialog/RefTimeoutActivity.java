package org.svcba.scoreboard.dialog;

import org.svcba.scoreboard.R;
import org.svcba.scoreboard.SVCBAApp;
import org.svcba.scoreboard.model.Game;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RefTimeoutActivity extends Activity
{
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dlg_ref_timeout);
		
		Button btn = (Button)findViewById(R.id.btn_go_on);
		btn.setOnClickListener(new OnClickListener(){
			public void onClick(View v)
			{
				Game game = ((SVCBAApp)getApplicationContext()).getGame();
				game.unsetRefTimeout();
				finish();
			}
		});
	}
	public void onBackPressed()
	{
		
	}
}
