package com.example.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayList<StudentItem> dummyData = getDummyData();
        Log.d("MainActivity", dummyData.size()+"");
        final StudentListAdapter studentListAdapter = new StudentListAdapter(this,0, dummyData);
        listView.setAdapter(studentListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StudentItem studentItem = studentListAdapter.getStudentItem(position);
                Toast.makeText(MainActivity.this,
                        ""+studentItem.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });


    }


    public ArrayList<StudentItem> getDummyData(){
        ArrayList<StudentItem> studentItems = new ArrayList<>();

        for(int i=1; i <= 100; i++){
            StudentItem studentItem = new StudentItem("John Doe "+i,
                    4/i,
                    "Johnny Bravo "+i,
                    getResources().getDrawable(R.drawable.student_image));
            studentItems.add(studentItem);
        }

        return studentItems;
    }
}
