package edu.dartmouth.cs.layouts;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewLayoutActivity extends ListActivity {

	static final String[] FACULTY = new String[] { "Chris Bailey-Kellogg",
			"Devin Balkcom", "Andrew Campbell", "Michael Casey",
			"Amit Chakrabarti", "Thomas H. Cormen ",
			"Robert L. (Scot) Drysdale, III", "Hany Farid", "Lisa Fleischer",
			"Gevorg Grigoryan", "Prasad Jayanti", "David Kotz", "Lorie Loeb",
			"Fabio Pellacini", "Daniel Rockmore", "Sean Smith",
			"Lorenzo Torresani", "Peter Winkler","Emily Whiting","Xia Zhou" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Don't have to do this anymore
		// setContentView(R.layout.listview_layout);

		// Define a new adapter
		ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this,
				R.layout.listview_layout, FACULTY);

		// Assign the adapter to ListView
		setListAdapter(mAdapter);

		// Define the listener interface
		OnItemClickListener mListener = new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// When clicked, show a toast with the TextView text
				Toast.makeText(getApplicationContext(),
						((TextView) view).getText() + " is an awesome prof!",
						Toast.LENGTH_SHORT).show();
			}
		};

		// Get the ListView and wired the listener
		ListView listView = getListView();
		listView.setOnItemClickListener(mListener);

	}
}
