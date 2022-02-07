package com.example.testlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainListActivity extends Activity {

    private static final int SHOW_SUBACTIVITY = 1;
    private ListView listView;
    ArrayAdapter<String> todoItemsAdapter;
    public List<String> pointList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);
        initializeList(pointList);
        todoItemsAdapter = new ArrayAdapter<String>(this, R.layout.row_layout, R.id.listText, pointList);

        listView.setAdapter(todoItemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //String item = (String) listView.getItemAtPosition(position);
                Bundle bundle = new Bundle();
                //bundle.putInt("position", position);
                //bundle.putString("name", item);
                Intent intent = new Intent(getApplicationContext(), Activity2.class);
                intent.putExtras(bundle);
                startActivityForResult(intent, SHOW_SUBACTIVITY);


            }
        });
    }

    public void initializeList(List<String> aPointList) {
        for(int i=0; i<5; i++){
            aPointList.add(i,"mismo lugar");

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /*if (resultCode == Activity.RESULT_OK) {
            Bundle bundle = data.getExtras();
            int destiny = bundle.getInt("Destiny");
            if (destiny == 1) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        }*/
    }

}
