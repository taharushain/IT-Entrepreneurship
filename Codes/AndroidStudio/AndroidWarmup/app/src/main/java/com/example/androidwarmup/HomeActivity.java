package com.example.androidwarmup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.provider.Contacts.SettingsColumns.KEY;
import static com.example.androidwarmup.util.LOGIN_KEY;
import static com.example.androidwarmup.util.PREF_KEY;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ListView listView = (ListView) findViewById(R.id.lv_users);
        EmployeeAdapter adapter = new EmployeeAdapter(this,0,getData());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),
                        ProfileActivity.class);

                intent.putExtra("position",position);

                startActivity(intent);


            }
        });

    }


    public ArrayList<Employee> getData(){
        ArrayList<Employee> data = new ArrayList<>();

        for(int i=1; i<=50; i++){
            Employee emp = new Employee();
            emp.setId(i);

            emp.setFatherName("Rambo"+i);
            emp.setAge((int)(Math.random()*45+22));

            if(i%2==0){
                emp.setName("Jane Doe"+ i);
                emp.setGender('f');
                emp.setBatch("Spring "+(1994+i));
            }else{
                emp.setName("John Doe"+ i);
                emp.setGender('m');
                emp.setBatch("Fall "+(1994+i));
            }
            emp.setContact("XXXXXXXXX");
            emp.setImage(getResources().getDrawable(R.drawable.default_image));


            data.add(emp);


        }

        return data;


    }

    public void logout(View v){
        // For share preferences
        final SharedPreferences pref = getSharedPreferences(PREF_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(LOGIN_KEY, false);
        editor.commit();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
