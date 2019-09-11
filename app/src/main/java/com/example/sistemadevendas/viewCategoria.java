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

import java.lang.reflect.Array;
import java.util.ArrayList;

public class viewCategoria extends AppCompatActivity {

    ListView lst1;
    ArrayList<String> title = new ArrayList<String>();
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_categoria);

        lst1 = findViewById(R.id.lst1);
        SQLiteDatabase db = openOrCreateDatabase("supervenda", Context.MODE_PRIVATE, null);
        final Cursor c = db.rawQuery("select * from categoria", null);
        int id = c.getColumnIndex("id");
        int categoria = c.getColumnIndex("categoria");
        int descricao = c.getColumnIndex("descricao");

        title.clear();

        arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, title);
        lst1.setAdapter(arrayAdapter);
        final ArrayList<cate> catee = new ArrayList<cate>();

        if (c.moveToNext()){
            do {
                cate ca = new cate();
                ca.id = c.getString(id);
                ca.categoria = c.getString(categoria);
                ca.descricao = c.getString(descricao);
                catee.add(ca);
                title.add(c.getString(id)+"\t" + c.getString(categoria)+"\t" + c.getString(descricao)+"\t");
            } while (c.moveToNext());

            arrayAdapter.notifyDataSetChanged();
            lst1.invalidateViews();
        }

        lst1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                String aaa;
                int position = 0;
                aaa = title.get(position).toString();
                cate ca = catee.get((i));

                Intent in = new Intent(getApplicationContext(), EditarCategoria.class);
                in.putExtra("id", ca.id);
                in.putExtra("categoria", ca.categoria);
                in.putExtra("descricao", ca.descricao);

                startActivity(in);
            }
        });

    }
}
