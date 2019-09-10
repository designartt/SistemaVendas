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

    EditText edtID, edtCategoria, edtDescricao;
    Button btnEditar, btnDeletar, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editarcategoria);

//        Setando os ids dos EditText
        edtID = findViewById(R.id.edtCatId);
        edtCategoria = findViewById(R.id.edtCategoria);
        edtDescricao = findViewById(R.id.edtDescricao);

//        Setando os ids do Button
        btnEditar = findViewById(R.id.btnEditar);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnDeletar = findViewById(R.id.btnDeletar);

        Intent in = getIntent();

        String id = in.getStringExtra("id").toString();
        String categoria = in.getStringExtra("categoria").toString();
        String descricao = in.getStringExtra("descricao").toString();


        edtID.setText(id);
        edtCategoria.setText(categoria);
        edtDescricao.setText(descricao);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditarCategoria();
            }
        });

        btnDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DeletarCategoria();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( getApplicationContext(), Main.class);
                startActivity(i);
            }
        });

    }

    public void EditarCategoria() {

        try {
            int id = Integer.parseInt(edtID.getText().toString());
            String categoria = edtCategoria.getText().toString();
            String descricao = edtDescricao.getText().toString();
            SQLiteDatabase db = openOrCreateDatabase("supervenda", Context.MODE_PRIVATE, null);

            String sql = "update categoria set categoria = ?, descricao = ? where id = ?";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1, categoria);
            statement.bindString(2, descricao);
            statement.bindLong(3, id);
            statement.execute();

            Toast.makeText(this, "Atualizado com sucesso!!!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getApplicationContext(), viewCategoria.class);
            startActivity(intent);

        } catch (Exception ex) {
            Toast.makeText(this, "Categoria não atualizada.", Toast.LENGTH_SHORT).show();
        }
    }

    public void DeletarCategoria(){
        try{
            String id = edtID.getText().toString();

            SQLiteDatabase db = openOrCreateDatabase("supervenda", Context.MODE_PRIVATE, null);
            String sql = "delete from categoria where id=?";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1, id);
            statement.execute();
            Toast.makeText(this, "Cadastrado deletado com Sucesso.", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(getApplicationContext(), Main.class);
            startActivity(i);
        } catch (Exception ex){
            Toast.makeText(this, "Categoria não deletada!", Toast.LENGTH_SHORT).show();
        }
    }
}
