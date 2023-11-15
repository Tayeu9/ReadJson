package com.example.readjson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    CustomAdapter adapter ;
    ListView listView;
    ArrayList<Lolicon> arrayloli;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listloli);
        arrayloli = new ArrayList<Lolicon>();
        new ReadJSON().execute("https://raw.githubusercontent.com/Tayeu9/7teams/main/dataloli.json");
    }
    private  class  ReadJSON extends AsyncTask<String,Void,String>{
        @Override
        protected String doInBackground(String... strings) {
            StringBuilder content = new StringBuilder();
            try {
                URL url =new URL(strings[0]);
                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader= new BufferedReader(inputStreamReader);
                String line="";
                while ((line=bufferedReader.readLine())!=null)
                {
                    content.append(line);
                }
                bufferedReader.close();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return content.toString();
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject object = new JSONObject(s);
                JSONArray array =object.getJSONArray("loli");
                for (int i=0;i<array.length();i++)
                {
                    JSONObject objectloli = array.getJSONObject(i);
                    String ten =objectloli.getString("name");
                    String age =objectloli.getString("age");
                    String img =objectloli.getString("img");
                    arrayloli.add(new Lolicon(ten,age,img));
                }
                adapter=new CustomAdapter(MainActivity.this, android.R.layout.simple_list_item_1,arrayloli);
                 listView.setAdapter(adapter);

            } catch (JSONException e) {
                throw new RuntimeException(e);
            }


        }
    }
}