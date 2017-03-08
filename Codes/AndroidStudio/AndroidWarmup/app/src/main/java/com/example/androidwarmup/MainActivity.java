package com.example.androidwarmup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;

import static android.provider.Contacts.SettingsColumns.KEY;
import static com.example.androidwarmup.util.LOGIN_KEY;
import static com.example.androidwarmup.util.PREF_KEY;

public class MainActivity extends AppCompatActivity {

    Button btn_login;
    EditText et_username;
    EditText et_password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);

        // For share preferences
        final SharedPreferences pref = getSharedPreferences(PREF_KEY, MODE_PRIVATE);
        Boolean logged = pref.getBoolean(LOGIN_KEY,false);


        if(logged){
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
            finish();
        }


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = et_username.getText().toString();
                String pass = et_password.getText().toString();

                if(checkUserPasswor(user, pass)){

                    SharedPreferences.Editor editor = pref.edit();
                    editor.putBoolean(LOGIN_KEY, true);
                    editor.commit();

                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),
                            "Incorrect Credentials",
                            Toast.LENGTH_SHORT).show();
                }



            }
        });


    }

    public Boolean checkUserPasswor(String username, String password){

        String[] user_array = {"hamza","faisal","simran","talha","taha","saadahme"};
        String[] password_array = {"1100","1101","1102","1103","1104","1105"};

        for(int i=0; i < user_array.length; i++){
            if(user_array[i].equals(username) && password_array[i].equals(password)){
                return true;
            }
        }

        return false;
    }

}
