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

public class EditarCategoria extends AppCompatActivity {

    EditText edtCatId, edtCategoria, edtDescricao;
    Button btnCatEditar, btnCatDeletar, btnCatCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editarcategoria);

//        Setando os ids dos EditText
        edtCatId = findViewById(R.id.edtCatId);
        edtCategoria = findViewById(R.id.edtCategoria);
        edtDescricao = findViewById(R.id.edtDescricao);

//        Setando os ids do Button
        btnCatEditar = findViewById(R.id.btnCatEditar);
        btnCatCancelar = findViewById(R.id.btnCatCancelar);
        btnCatDeletar = findViewById(R.id.btnCatDeletar);

        Intent in = getIntent();

        String id = in.getStringExtra("id").toString();
        String categoria = in.getStringExtra("categoria").toString();
        String descricao = in.getStringExtra("descricao").toString();


        edtCatId.setText(id);
        edtCategoria.setText(categoria);
        edtDescricao.setText(descricao);

        btnCatEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditarCategoria();
            }
        });

    }

    public void EditarCategoria(){
        try{
            String id = edtCatId.getText().toString();
            String categoria = edtCategoria.getText().toString();
            String descricao = edtDescricao.getText().toString();

            SQLiteDatabase db = openOrCreateDatabase("supervenda", Context.MODE_PRIVATE, null);
            String sql = "update categoria set categoria = ?,descricao = ? where id=?";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1, categoria);
            statement.bindString(2, descricao);
            statement.bindString(3, id);
            statement.execute();
            Toast.makeText(this, "Cadastrado atualizada com Sucesso.", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(getApplicationContext(), Main.class);
            startActivity(i);
        } catch (Exception ex){
            Toast.makeText(this, "Não atualizado!", Toast.LENGTH_SHORT).show();
        }
    }
}
