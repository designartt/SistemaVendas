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


    EditText edtNome, edtDescricao;
    Button btnAdicionar, btnSair;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabricante);

        edtNome = findViewById(R.id.edtCategoria);
        edtDescricao = findViewById(R.id.edtDescricao);

        btnAdicionar = findViewById(R.id.btnAdicionarCategoria);
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
            String nome = edtNome.getText().toString();
            String descricao = edtDescricao.getText().toString();
            SQLiteDatabase db = openOrCreateDatabase("supervenda", Context.MODE_PRIVATE, null);
            db.execSQL("CREATE table if not exists fabricante(id integer primary key autoincrement, nome varchar, descricao varchar)");

            String sql = "insert into categoria(categoria, descricao) values (?,?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1, nome);
            statement.bindString(2, descricao);
            statement.execute();
            Toast.makeText(this, "Cadastrado com Sucesso.", Toast.LENGTH_SHORT).show();
            edtNome.setText("");
            edtDescricao.setText("");
            edtNome.requestFocus();
        } catch (Exception ex){
            Toast.makeText(this, "Fabricante não cadastrada.", Toast.LENGTH_SHORT).show();
        }
    }
}
