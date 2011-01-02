package org.svcba.scoreboard.dialog;

import org.svcba.scoreboard.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ActionRemoveActivity extends Activity
{
	public static final int RESULT_HOMETEAM = 0;
	public static final int RESULT_AWAYTEAM = 1;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dlg_action_remove);
		Button btn = (Button)findViewById(R.id.btn_confirm_remove);
		
		btn.setText("Confirm");
		btn.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0)
			{
				Intent intent = getIntent();
				setResult(RESULT_OK,intent);
				finish(); 
			}
			
		});
		btn = (Button)findViewById(R.id.btn_cancel_remove);
		btn.setText("Cancel");
		btn.setOnClickListener(new OnClickListener(){

			public void onClick(View v)
			{
				Intent intent = getIntent();
				setResult(RESULT_CANCELED,intent);
				finish(); 
			}
			
		});
	}
	
}
