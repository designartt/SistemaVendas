package com.example.sistemadevendas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class viewFabricante extends AppCompatActivity {

    ListView lst2;
    ArrayList<String> title = new ArrayList<String>();
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_fabricante);

        lst2 = findViewById(R.id.lst2);
        SQLiteDatabase db = openOrCreateDatabase("supervenda", Context.MODE_PRIVATE, null);
        final Cursor c = db.rawQuery("select * from fabricante", null);
        int id =            c.getColumnIndex("id");
        int fabricante =    c.getColumnIndex("fabricante");
        int sobre =         c.getColumnIndex("sobre");

        title.clear();

        arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, title);
        lst2.setAdapter(arrayAdapter);
        final ArrayList<fab> brann = new ArrayList<fab>();

        if (c.moveToNext()){
            do {
                fab fa = new fab();
                fa.id = c.getString(id);
                fa.fabricante = c.getString(fabricante);
                fa.sobre = c.getString(sobre);
                brann.add(fa);
                title.add(c.getString(id)+"\t" + c.getString(fabricante)+"\t" + c.getString(sobre)+"\t");
            } while (c.moveToNext());

            arrayAdapter.notifyDataSetChanged();
            lst2.invalidateViews();
        }

        lst2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String aaa;
                int position = 0;
                aaa = title.get(position).toString();
                fab fa = brann.get((i));

                Intent in = new Intent(getApplicationContext(), EditarFabricante.class);
                in.putExtra("id", fa.id);
                in.putExtra("fabricante", fa.fabricante);
                in.putExtra("sobre", fa.sobre);

                startActivity(in);
            }
        });

    }
}
