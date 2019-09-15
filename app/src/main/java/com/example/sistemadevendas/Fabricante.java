package com.example.sistemadevendas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Fabricante extends AppCompatActivity {

    EditText edt1, edt2;
    Button btnAdicionar, btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabricante);

        edt1 = findViewById(R.id.edtFabNome);
        edt2 = findViewById(R.id.edtFabSobre);

        btnAdicionar = findViewById(R.id.btnAdicionar);
        btnSair = findViewById(R.id.btnSair);

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Main.class);
                startActivity(intent);
            }
        });

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert();
            }
        });

    }

    private void insert(){
        try{
            String fabricante =     edt1.getText().toString();
            String sobre =          edt2.getText().toString();
            SQLiteDatabase db = openOrCreateDatabase("supervenda", Context.MODE_PRIVATE, null);
            db.execSQL("CREATE table if not exists fabricante(id integer primary key autoincrement, fabricante varchar, sobre varchar)");

            String sql = "insert into fabricante(fabricante, sobre) values (?,?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1, fabricante);
            statement.bindString(2, sobre);
            statement.execute();
            Toast.makeText(this, "Cadastrado com Sucesso.", Toast.LENGTH_SHORT).show();
            edt1.setText("");
            edt2.setText("");
            edt1.requestFocus();
        } catch (Exception ex){
            Toast.makeText(this, "Erro ao cadastrar!!!", Toast.LENGTH_SHORT).show();
        }
    }
}
