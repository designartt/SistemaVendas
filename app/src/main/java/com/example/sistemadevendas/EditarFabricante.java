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

public class EditarFabricante extends AppCompatActivity {

    EditText edtID, edt1, edt2;
    Button btnEditar, btnDeletar, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editarfabricante);

        //        Setando os ids dos EditText
        edtID = findViewById(R.id.edtID);
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);

//        Setando os ids do Button
        btnEditar = findViewById(R.id.btnEditar);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnDeletar = findViewById(R.id.btnDeletar);

        Intent in = getIntent();

        String id = in.getStringExtra("id").toString();
        String fabricante = in.getStringExtra("fabricante").toString();
        String sobre = in.getStringExtra("sobre").toString();


        edtID.setText(id);
        edt1.setText(fabricante);
        edt2.setText(sobre);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditarFabricante();
            }
        });

        btnDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DeletarFabricante();
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

    public void EditarFabricante() {

        try {
            int id = Integer.parseInt(edtID.getText().toString());
            String fabricante = edt1.getText().toString();
            String sobre = edt2.getText().toString();
            SQLiteDatabase db = openOrCreateDatabase("supervenda", Context.MODE_PRIVATE, null);

            String sql = "update fabricante set fabricante = ?, sobre = ? where id = ?";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1, fabricante);
            statement.bindString(2, sobre);
            statement.bindLong(3, id);
            statement.execute();

            Toast.makeText(this, "Atualizado com sucesso!!!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getApplicationContext(), viewFabricante.class);
            startActivity(intent);

        } catch (Exception ex) {
            Toast.makeText(this, "Categoria não atualizada.", Toast.LENGTH_SHORT).show();
        }
    }

    public void DeletarFabricante(){
        try{
            String id = edtID.getText().toString();

            SQLiteDatabase db = openOrCreateDatabase("supervenda", Context.MODE_PRIVATE, null);
            String sql = "delete from fabricante where id=?";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1, id);
            statement.execute();
            Toast.makeText(this, "Cadastrado deletado com Sucesso.", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(getApplicationContext(), viewFabricante.class);
            startActivity(i);
        } catch (Exception ex){
            Toast.makeText(this, "Categoria não deletada!", Toast.LENGTH_SHORT).show();
        }
    }
}
