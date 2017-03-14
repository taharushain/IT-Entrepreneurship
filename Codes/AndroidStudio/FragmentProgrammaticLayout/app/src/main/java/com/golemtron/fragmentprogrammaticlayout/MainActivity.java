package com.golemtron.fragmentprogrammaticlayout;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements TitlesFragment.ListSelectionListener {

    public static String[] mTitleArray;
    public static String[] mQuoteArray;

    // Get a reference to the QuotesFragment
    private final QuotesFragment mQuoteFragment = new QuotesFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the string arrays with the titles and qutoes
        mTitleArray = getResources().getStringArray(R.array.Titles);
        mQuoteArray = getResources().getStringArray(R.array.Quotes);

        setContentView(R.layout.activity_main);

        // Get a reference to the FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Begin a new FragmentTransaction
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();

        // Add the TitleFragment
        fragmentTransaction.add(R.id.title_frame, new TitlesFragment());

        // Add the QuoteFragment
        fragmentTransaction.add(R.id.quote_frame, mQuoteFragment);

        // Commit the FragmentTransaction
        fragmentTransaction.commit();
    }

    // Called when the user selects an item in the TitlesFragment
    @Override
    public void onListSelection(int index) {
        if (mQuoteFragment.getShownIndex() != index) {

            // Tell the QuoteFragment to show the quote string at position index
            mQuoteFragment.showQuoteAtIndex(index);
        }
    }
}