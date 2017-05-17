package com.taharushain.ireviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Book> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        sendVolleyRequest();

    }

    private void sendVolleyRequest() {
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);

        String url = Constants.BOOK_INDEX_URL;

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        data = handleResponse(response);
                        BookAdapter bookAdapter = new BookAdapter(
                                MainActivity.this,
                                0,
                                data);
                        progressBar.setVisibility(View.INVISIBLE);
                        listView.setAdapter(bookAdapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(MainActivity.this, ""+error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    private ArrayList<Book> handleResponse(String response) {
        ArrayList<Book> books = new ArrayList<>();


        try {
            JSONArray jsonArray = (JSONArray) new JSONTokener(response).nextValue();
            Toast.makeText(this, "Response: "+response, Toast.LENGTH_SHORT).show();
            Log.d("API call", "res:" + response);

            for(int i=0; i< jsonArray.length(); i++){
                JSONObject innerJsonObject = (JSONObject) jsonArray.get(i);

                Book book = new Book();
                book.setId(innerJsonObject.getInt("id"));
                book.setAuthor(innerJsonObject.getString("author"));
                book.setName(innerJsonObject.getString("name"));
                book.setReviewer_id(innerJsonObject.getInt("reviewer_id"));
                books.add(book);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return books;
    }


}
