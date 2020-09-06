package com.example.geedha.company_details_corporate;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Entity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class Getpassword extends AsyncTask<String,String,List<String>> {

    @Override
    protected List<String> doInBackground(String... params) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        List<String> allCompany = new ArrayList<>();
        HttpGet httpGet = new HttpGet("https://geedhaapp.herokuapp.com/getcompany");
        String data = null;
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity repEntity = response.getEntity();
            data = EntityUtils.toString(repEntity,"UTF-8");
            Gson gson = new Gson();
            Company[] ComObjects = gson.fromJson(data,Company[].class);
            for(Company x:ComObjects){
                allCompany.add(x.getPassword());
                Log.d("objdata",x.getPassword());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allCompany;
    }
}
