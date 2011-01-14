package org.svcba.scoreboard.dialog;

import java.util.List;

import org.svcba.scoreboard.R;
import org.svcba.scoreboard.SVCBAApp;
import org.svcba.scoreboard.model.Action;
import org.svcba.scoreboard.model.Game;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActionRemoveActivity extends Activity {
	public static final int RESULT_HOMETEAM = 0;
	public static final int RESULT_AWAYTEAM = 1;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dlg_action_remove);
		
		// Update the info
		int pos2Remove = getIntent().getIntExtra("pos2Remove", 0);
		Game game = ((SVCBAApp)getApplicationContext()).getGame();
		List<Action> action = game.getActions();
		Action displayAction = action.get(action.size()-1-pos2Remove);
		
		// should merge the code with NormalActivity::updateAction()
		String realAction = new String();
		Resources res = getResources();
		boolean notImplemnted = false;
		switch (displayAction.getAction())
		{
			case Action.TIMEOUT:				
				realAction = res.getString(R.string.notimplemented);
				notImplemnted = true;
				break;
			case Action.SUB_OFF:				
				realAction = res.getString(R.string.notimplemented);
				notImplemnted = true;
				break;
			case Action.SUB_ON:				
				realAction = res.getString(R.string.notimplemented);
				notImplemnted = true;
				break;
			case Action.FOUL:				
				realAction = res.getString(R.string.foul);				
				break;
			case Action.TURNOVER:				
				realAction = res.getString(R.string.turnover);
				break;
			case Action.SHOOT_1:
				realAction = res.getString(R.string.shoot1);				
				break;
			case Action.SHOOT_2:				
				realAction = res.getString(R.string.shoot2);				
				break;
			case Action.SHOOT_3:				
				realAction = res.getString(R.string.shoot3);
				break;
			case Action.REBOUND_B:				
				realAction = res.getString(R.string.rebound_b);				
				break;
			case Action.REBOUND_F:				
				realAction = res.getString(R.string.rebound_f);				
				break;
			case Action.STEAL:				
				realAction = res.getString(R.string.steal);				
				break;
			case Action.ASSIST:				
				realAction = res.getString(R.string.assist);				
				break;
			default:
				break;
		}
		
		TextView textAction = (TextView) findViewById(R.id.action_to_remove);
		if (!notImplemnted)
		{
			textAction.setText((CharSequence) displayAction.getPlayer().get("name") + "  " + realAction);
		}
		else
		{
			textAction.setText(realAction);
		}
		// Show the buttons
		Button btn = (Button) findViewById(R.id.btn_confirm_remove);

		btn.setText(R.string.confirm);
		btn.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				Intent intent = getIntent();
				setResult(RESULT_OK, intent);
				finish();
			}

		});
		btn = (Button) findViewById(R.id.btn_cancel_remove);
		btn.setText(R.string.cancel);
		btn.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent intent = getIntent();
				setResult(RESULT_CANCELED, intent);
				finish();
			}

		});
	}

}
