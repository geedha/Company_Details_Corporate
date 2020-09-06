package com.example.geedha.company_details_corporate;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.provider.Telephony;
//import android.support.v4.app.ActivityCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MessageActivity extends AppCompatActivity {


    private Button btnSms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

       // final String txtMessage = "Hey! new Offer for you";
        btnSms = (Button) findViewById(R.id.buttonSend);

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Getallstudents task = new Getallstudents();
                Long[] data = {656L,65L};
                List<Long> get = null;
                Intent intent = getIntent();

                String message = intent.getStringExtra("String");

                try {
                    get = task.execute().get();


                    data = get.toArray(new  Long[0]);

                    Log.d("post","params:"+data[0].toString());



                    }






                catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    SmsManager sms = SmsManager.getDefault();

// the message
                    //String message = "Hello";

// the phone numbers we want to send to
                    String numbers[] = {"9786498218", "9443121490"};


                    String output = "";

                    for (int i = 0; i < data.length; i++) {
                        output += "\"" + data[i] + "\"";
                        if (i != data.length - 1) {
                            output += "; ";
                        }
                    }
                    Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                    i.putExtra("address", output);
                    i.putExtra("sms_body", message);
                    Toast.makeText(MessageActivity.this, "SMS Sent", Toast.LENGTH_SHORT).show();

                    i.setType("vnd.android-dir/mms-sms");
                    startActivity(i);


                } catch (Exception e) {
                    Toast.makeText(MessageActivity.this, "SMS Failed to Send, Please try again", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }

        });
    }

}