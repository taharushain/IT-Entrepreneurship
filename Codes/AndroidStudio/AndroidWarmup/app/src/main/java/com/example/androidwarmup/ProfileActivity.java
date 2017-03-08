package com.example.androidwarmup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {


    TextView tv_name, tv_fname,tv_batch,tv_contact,tv_gender,tv_age;
    ImageView iv_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", -1);



        if(position == -1){
            Toast.makeText(this, "Invalid Employee", Toast.LENGTH_SHORT).show();
        }else{
            Employee emp = getData().get(position);

            tv_name = (TextView) findViewById(R.id.tv_name);
            tv_fname = (TextView) findViewById(R.id.tv_fname);
            tv_batch = (TextView) findViewById(R.id.tv_batch);
            tv_contact = (TextView) findViewById(R.id.tv_contact);
            tv_gender = (TextView) findViewById(R.id.tv_gender);
            tv_age = (TextView) findViewById(R.id.tv_age);
            iv_profile = (ImageView) findViewById(R.id.iv_profile);

            tv_name.setText("NAME: "+emp.getName());
            tv_fname.setText("FATHER NAME: "+emp.getFatherName());
            tv_batch.setText("BATCH: "+emp.getBatch());
            tv_contact.setText("CONTACT: "+emp.getContact());
            if(emp.getGender()=='f'){
                tv_gender.setText("GENDER: Female");
            }else{
                tv_gender.setText("GENDER: Male");
            }


            tv_age.setText("AGE: "+emp.getAge());

            iv_profile.setImageDrawable(getResources()
                    .getDrawable(R.drawable.default_image));

        }



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

}
