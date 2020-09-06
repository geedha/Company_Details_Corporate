package com.example.geedha.company_details_corporate;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class Addplacement extends AsyncTask<String,String,String> {

    @Override
    protected String doInBackground(String... strings) {
        Log.d("post","task enry");

        /*
        String name = (String)strings[0];
        String email = (String)strings[1];
        String password = (String)strings[2];
        String cgpa = (String)strings[3];
        String phonenumber = (String)strings[4];
        Log.d("postablr","enty");
        for(String x:strings){
            Log.d("userinp",x);
        Name = (EditText)findViewById(R.id.edittext1);
        Location = (EditText)findViewById(R.id.edittext2);
        Domain = (EditText)findViewById(R.id.edittext3);
        Eligibility = (EditText)findViewById(R.id.edittext4);
        Startingsalary = (EditText)findViewById(R.id.edittext5);
        No_of_rounds = (EditText)findViewById(R.id.edittext6);
        }
         */

        String name = (String)strings[0];
        String location = (String)strings[1];
        String domain = (String)strings[2];
        String eligibility = (String)strings[3];
        String startingsalary = (String)strings[4];
        String no_of_rounds = (String)strings[5];


        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://geedhaapp.herokuapp.com/addplacement");
        Log.d("post","client");

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("name",name));
        params.add(new BasicNameValuePair("location",location));
        params.add(new BasicNameValuePair("domain",domain));
        params.add(new BasicNameValuePair("eligibility",eligibility));
        params.add(new BasicNameValuePair("startingsalary",startingsalary));
        params.add(new BasicNameValuePair("no_of_rounds",no_of_rounds));

        Log.d("value",name);
        Log.d("location",location);
        Log.d("domain",domain);
        Log.d("eligibility",eligibility);
        Log.d("startingsalary",startingsalary);
        Log.d("no_of_rounds",no_of_rounds);
        try{
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            Log.d("post","entity");
            client.execute(httpPost);
            Log.d("post","done with posting");

            client.close();
        }catch (Exception e)
        {
            Log.d("post","error");

            e.printStackTrace();
        }
        return "done";
    }
}