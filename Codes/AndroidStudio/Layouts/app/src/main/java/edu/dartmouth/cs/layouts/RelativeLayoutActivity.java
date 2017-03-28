package edu.dartmouth.cs.layouts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class RelativeLayoutActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.relative_layout);
	}

	public void onGoBackClicked(View v) {

		Intent intent = new Intent(RelativeLayoutActivity.this,
				MainLayoutActivity.class);
		startActivity(intent);
	}

	public void onClickConan(View v) {

		Toast.makeText(this, getString(R.string.ui_conans_message),
				Toast.LENGTH_LONG).show();

		}

}
