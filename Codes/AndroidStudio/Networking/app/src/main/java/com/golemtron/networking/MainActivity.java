package com.golemtron.networking;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;


public class MainActivity extends AppCompatActivity {
    TextView mTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.textView1);

        final Button loadButton = (Button) findViewById(R.id.button1);
        loadButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                new SocketTask().execute();
//                new HttpUrlConnectionTask().execute();

                sendVolleyRequest();

            }
        });


    }

    private void sendVolleyRequest() {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://api.geonames.org/earthquakesJSON?north=44.1&south=-9.9&east=-22.4&west=55.2&username=taharushain";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        mTextView.setText("Response is: " + response.substring(0, 500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("That didn't work!");
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

//    private class SocketTask extends AsyncTask<Void, Void, String> {
//
//        private static final String HOST = "api.geonames.org";
//
//        // Get your own user name at http://www.geonames.org/login
//        private static final String USER_NAME = "taharushain";
//        private static final String HTTP_GET_COMMAND = "GET /earthquakesJSON?north=44.1&south=-9.9&east=-22.4&west=55.2&username="
//                + USER_NAME
//                + " HTTP/1.1"
//                + "Connection: close" + "\n\n";
//
//        private static final String TAG = "HttpGet";
//
//        @Override
//        protected String doInBackground(Void... params) {
//            Socket socket = null;
//            String data = "";
//
//            Log.d(TAG,"doInBackground");
//
//            try {
//                socket = new Socket(HOST, 80);
//                PrintWriter pw = new PrintWriter(new OutputStreamWriter(
//                        socket.getOutputStream()), true);
//                pw.println(HTTP_GET_COMMAND);
//
//                data = readStream(socket.getInputStream());
//                Log.d(TAG,"Data: "+data.toString());
//
//
//            } catch (UnknownHostException exception) {
//                exception.printStackTrace();
//            } catch (IOException exception) {
//                exception.printStackTrace();
//            } finally {
//                if (null != socket)
//                    try {
//                        socket.close();
//                    } catch (IOException e) {
//                        Log.e(TAG, "IOException");
//                    }
//            }
//            return data.toString();
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//            Log.d(TAG,"Result: "+result);
//            mTextView.setText(result);
//            mTextView.setText("ABCSDADASD\n"+result);
//            Toast.makeText(getApplication().getApplicationContext(),
//                    ""+result, Toast.LENGTH_SHORT).show();
//        }
//
//        private String readStream(InputStream in) {
//            BufferedReader reader = null;
//            StringBuffer data = new StringBuffer();
//            try {
//                reader = new BufferedReader(new InputStreamReader(in));
//                String line = "";
//                while ((line = reader.readLine()) != null) {
//                    data.append(line);
//                }
//            } catch (IOException e) {
//                Log.e(TAG, "IOException");
//            } finally {
//                if (reader != null) {
//                    try {
//                        reader.close();
//                    } catch (IOException e) {
//                        Log.e(TAG, "IOException");
//                    }
//                }
//            }
//            Log.d(TAG,"Data: "+data.toString());
//            return data.toString();
//        }
//    }

//    private class HttpUrlConnectionTask extends AsyncTask<Void, Void, String> {
//
//        private static final String TAG = "HttpGetTask";
//
//        // Get your own user name at http://www.geonames.org/login
//        private static final String USER_NAME = "taharushain";
//        private static final String _URL = "http://api.geonames.org/earthquakesJSON?north=44.1&south=-9.9&east=-22.4&west=55.2&username="
//                + USER_NAME;
//
//        @Override
//        protected String doInBackground(Void... params) {
//            String data = "";
//            HttpURLConnection httpUrlConnection = null;
//
//            try {
//                httpUrlConnection = (HttpURLConnection) new URL(_URL)
//                        .openConnection();
//
//                InputStream in = new BufferedInputStream(
//                        httpUrlConnection.getInputStream());
//
//                data = readStream(in);
//
//            } catch (MalformedURLException exception) {
//                Log.e(TAG, "MalformedURLException");
//            } catch (IOException exception) {
//                Log.e(TAG, "IOException");
//            } finally {
//                if (null != httpUrlConnection)
//                    httpUrlConnection.disconnect();
//            }
//            return data.toString();
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//            mTextView.setText(result);
//        }
//
//        private String readStream(InputStream in) {
//            BufferedReader reader = null;
//            StringBuffer data = new StringBuffer("");
//            try {
//                reader = new BufferedReader(new InputStreamReader(in));
//                String line = "";
//                while ((line = reader.readLine()) != null) {
//                    data.append(line);
//                }
//            } catch (IOException e) {
//                Log.e(TAG, "IOException");
//            } finally {
//                if (reader != null) {
//                    try {
//                        reader.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//            return data.toString();
//        }
//    }

}