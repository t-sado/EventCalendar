package io.sado.eventcalendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class ListActivity extends AppCompatActivity {
    private ArrayList<HashMap<String,String>> Data = new ArrayList<HashMap<String, String>>();
    private HashMap<String,String> InputData1 = new HashMap<>();
    private HashMap<String,String> InputData2 = new HashMap<>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView =(ListView)findViewById(R.id.schedule_listView);
        //first Data
        InputData1.put("date","2019/02/02");
        InputData1.put("name","birthday");
        Data.add(InputData1);

        InputData2.put("date","2019/02/03");
        InputData2.put("name","baseball");
        Data.add(InputData2);

        //simpleAdapter create
        SimpleAdapter simpleAdapter;
        simpleAdapter = new SimpleAdapter(this,
                Data,
                android.R.layout.simple_list_item_2,
                new String[]{"date","name"},
                new int[]{android.R.id.text1,android.R.id.text2});
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(ListActivity.this ,Data.get(position).toString(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ //back key tapped
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
