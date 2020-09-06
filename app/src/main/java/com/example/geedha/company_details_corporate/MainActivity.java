package com.example.geedha.company_details_corporate;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    Button LogInButton, RegisterButton ;
    EditText Email, Password ;
    String EmailHolder, PasswordHolder;
    Boolean EditTextEmptyHolder;
    SQLiteDatabase sqLiteDatabaseObj;
    //SQLiteHelper sqLiteHelper;
    Cursor cursor;
    String TempPassword = "NOT_FOUND" ;
    public static final String UserEmail = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LogInButton = (Button)findViewById(R.id.buttonLogin);

        RegisterButton = (Button)findViewById(R.id.buttonRegister);

        Email = (EditText)findViewById(R.id.editEmail);
        Password = (EditText)findViewById(R.id.editPassword);

        //sqLiteHelper = new SQLiteHelper(this);

        //Adding click listener to log in button.
        LogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Calling EditText is empty or no method.
                ///CheckEditTextStatus();

                // Calling login method.
                //LoginFunction();
                String[] data = {"apple","mango"};
                String[] password = {"appale","orange"};
                Getallcompany task = new Getallcompany();
                Getpassword pass = new Getpassword();
                int posemail = 0;
                int pospass = 0;

                try {
                    List<String> get = task.execute().get();
                    data = get.toArray(new  String[0]);
                    List<String> get2 = pass.execute().get();
                    password = get2.toArray(new String[0]);
                    boolean emailcheck = Arrays.asList(data).contains(Email.getText().toString());
                    boolean passcheck = Arrays.asList(password).contains(Password.getText().toString());
                    Log.d("post","params:"+emailcheck);

                    Log.d("post","params:"+passcheck);
                    if( TextUtils.isEmpty(Email.getText().toString()) || TextUtils.isEmpty(Password.getText().toString())){
                        Toast.makeText(MainActivity.this,"Please Fill the Email and Password",Toast.LENGTH_LONG).show();

                    }
                    else {

                        if(emailcheck && passcheck){
                            posemail =Arrays.asList(data).indexOf(Email.getText().toString());
                            pospass = Arrays.asList(password).indexOf(Password.getText().toString());
                            if(posemail == pospass){
                                Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(MainActivity.this,"your password is wrong",Toast.LENGTH_LONG).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this,"Your password or email is wrong",Toast.LENGTH_LONG).show();
                        }
                    }

                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        // Adding click listener to register button.
        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Opening new user registration activity using intent on button click.
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);

            }
        });

    }


}