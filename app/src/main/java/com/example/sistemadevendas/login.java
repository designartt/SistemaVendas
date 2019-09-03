package com.example.sistemadevendas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText edtUser, edtSenha;
    Button btnLogin, btnSair;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        edtUser = findViewById(R.id.user);
        edtSenha = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);
        btnSair = findViewById(R.id.btnSair);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });
        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void Login(){
        String usuario = edtUser.getText().toString();
        String senha = edtSenha.getText().toString();

        if ((usuario.equals(""))||(senha.equals(""))){
            Toast.makeText(this, "Usuário e senha não pode ser vazio!", Toast.LENGTH_SHORT).show();
        } else if(usuario.equals("luiz") && senha.equals("123")){
            Toast.makeText(this, "Parabéns!!!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(login.this, Main.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Usuário ou senha incorretos!", Toast.LENGTH_SHORT).show();
        }
    }
}
