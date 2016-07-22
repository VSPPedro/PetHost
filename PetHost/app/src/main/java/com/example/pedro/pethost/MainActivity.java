package com.example.pedro.pethost;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final int CADASTRO = 1;
    private static final int LOGIN = 1;
    private Button btCadastro;
    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Botão cadastro
        this.btCadastro = (Button) findViewById(R.id.buttoncadastro);
        this.btCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent("NOVO_CADASTRO");
                startActivityForResult(it, CADASTRO);
            }
        });

        //Botão Login
        this.btLogin = (Button) findViewById(R.id.buttonlogin);
        this.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent("NOVO_PERFIL_DONO");
                startActivityForResult(it, LOGIN);
            }
        });
    }
}
