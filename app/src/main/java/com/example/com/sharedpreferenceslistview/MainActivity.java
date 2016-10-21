package com.example.com.sharedpreferenceslistview;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_SHARED = "MY_KEY_SHARED";

    private ListView mListView;
    private ArrayAdapter<String> mAdapter;
    private String[] names = new String[] {"Raul", "Pepe", "Abe", "Dani"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Fill a list view
        mListView = (ListView) findViewById(R.id.a_main_list);
        // current context, layout, array of items
        mAdapter  = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(), names[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void gotTo2(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    /*
    * SharedPreferences are like session variables, they save data in an xml, primitives, plain text, json, string sets
    * */
    public void saveStuff(View view) {
        String now = (new Date()).toString();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_SHARED, now);
        editor.apply();
    }

    public void clear(View view) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //editor.remove("key");
        editor.clear();
        editor.apply();
    }

}
