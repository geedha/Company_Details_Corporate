package com.example.geedha.company_details_corporate;
import android.content.Context;
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

public class RegisterActivity extends AppCompatActivity {

    EditText Email, Password, Name ;
    Button Register;
    //String NameHolder, EmailHolder, PasswordHolder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Register = (Button)findViewById(R.id.buttonRegister);

        Email = (EditText)findViewById(R.id.editEmail);
        Password = (EditText)findViewById(R.id.editPassword);
        Name = (EditText)findViewById(R.id.editName);


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               AddCompany task = new AddCompany();
                task.execute(Name.getText().toString(),Email.getText().toString(),Password.getText().toString());
                Log.d("post","posted");
                Toast.makeText(getApplicationContext(),"Doneee",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }








}


