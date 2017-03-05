package com.example.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        final StudentListAdapter studentListAdapter = new StudentListAdapter(this, getUsers());
        listView.setAdapter(studentListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StudentItem studentItem = studentListAdapter.getStudent(position);
                Toast.makeText(getApplicationContext(), studentItem.getName(), Toast.LENGTH_SHORT).show();
            }

        });

    }


    public ArrayList<StudentItem> getUsers(){
        ArrayList<StudentItem> arrayList = new ArrayList<>();
        for(int i=0; i < 200; i++){
            arrayList.add(new StudentItem("John Doe "+(i+1)));
        }

        return arrayList;
    }


}
