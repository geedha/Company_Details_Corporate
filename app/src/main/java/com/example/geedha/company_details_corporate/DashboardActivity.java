package com.example.geedha.company_details_corporate;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DashboardActivity extends AppCompatActivity {
    EditText Name,Location,Domain,Eligibility,Startingsalary,No_of_rounds ;
    Button insert ;
    String nameholder,locationholder,domainholder,startingsalaryholder,no_of_roundsholder;
    Integer eligibilityholder;
    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder ;
    //SQLiteHelper2 sqLiteHelper;
    Boolean EditTextEmptyHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        insert = (Button)findViewById(R.id.button1);

        Name = (EditText)findViewById(R.id.edittext1);
        Location = (EditText)findViewById(R.id.edittext2);
        Domain = (EditText)findViewById(R.id.edittext3);
        Eligibility = (EditText)findViewById(R.id.edittext4);
        Startingsalary = (EditText)findViewById(R.id.edittext5);
        No_of_rounds = (EditText)findViewById(R.id.edittext6);


        //qLiteHelper = new SQLiteHelper2(this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String send = " Hey new offer for you! Name  of the company:  "+Name.getText().toString()+"Location of the Interview " +
                        ": "+Location.getText().toString()+"If Your Interested please attend it ..";

                Addplacement task = new Addplacement();
                task.execute(Name.getText().toString(),Location.getText().toString(),Domain.getText().toString(),Eligibility.getText().toString(),Startingsalary.getText().toString(),No_of_rounds.getText().toString());
                Log.d("post","posted");
                Toast.makeText(getApplicationContext(),"Doneee",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(DashboardActivity.this, MessageActivity.class);
                intent.putExtra("String",send );
                startActivity(intent);

            }
        });






    }





}