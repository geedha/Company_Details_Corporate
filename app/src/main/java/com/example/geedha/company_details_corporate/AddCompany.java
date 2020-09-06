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

public class AddCompany extends AsyncTask<String,String,String> {

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
        }
         */

        String name = (String)strings[0];
        String email = (String)strings[1];
        String password = (String)strings[2];


        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://geedhaapp.herokuapp.com/companyadd");
        Log.d("post","client");

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("name",name));
        params.add(new BasicNameValuePair("email",email));
        params.add(new BasicNameValuePair("password",password));

        Log.d("value",name);
        Log.d("email",email);
        Log.d("pass",password);

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