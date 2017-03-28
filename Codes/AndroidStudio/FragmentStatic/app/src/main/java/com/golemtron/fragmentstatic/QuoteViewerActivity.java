package com.golemtron.fragmentstatic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class QuoteViewerActivity extends AppCompatActivity implements
            TitlesFragment.ListSelectionListener {

        public static String[] mTitleArray;
        public static String[] mQuoteArray;
        private QuotesFragment mDetailsFragment;

        private static final String TAG = "QuoteViewerActivity";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Get the string arrays with the titles and qutoes
            mTitleArray = getResources().getStringArray(R.array.Titles);
            mQuoteArray = getResources().getStringArray(R.array.Quotes);

            setContentView(R.layout.activity_main);

            // Get a reference to the QuotesFragment
            mDetailsFragment = (QuotesFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.details);
        }

        // Called when the user selects an item in the TitlesFragment
        @Override
        public void onListSelection(int index) {
            if (mDetailsFragment.getShownIndex() != index) {

                // Tell the QuoteFragment to show the quote string at position index
                mDetailsFragment.showQuoteAtIndex(index);
            }
        }

        @Override
        protected void onDestroy() {
            Log.i(TAG, getClass().getSimpleName() + ":entered onDestroy()");
            super.onDestroy();
        }

        @Override
        protected void onPause() {
            Log.i(TAG, getClass().getSimpleName() + ":entered onPause()");
            super.onPause();
        }

        @Override
        protected void onRestart() {
            Log.i(TAG, getClass().getSimpleName() + ":entered onRestart()");
            super.onRestart();
        }

        @Override
        protected void onResume() {
            Log.i(TAG, getClass().getSimpleName() + ":entered onResume()");
            super.onResume();
        }

        @Override
        protected void onStart() {
            Log.i(TAG, getClass().getSimpleName() + ":entered onStart()");
            super.onStart();
        }

        @Override
        protected void onStop() {
            Log.i(TAG, getClass().getSimpleName() + ":entered onStop()");
            super.onStop();
        }

    }