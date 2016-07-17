package com.example.pedro.pethost;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.Button;

public class CadastroActivity extends AppCompatActivity {
    private static final int CADASTRODONO = 1;
    private static final int CADASTROANFITRIAO = 1;
    private Button btCadastroDono;
    private Button btCadastroAnfitriao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //Botão cadastro
        this.btCadastroDono = (Button) findViewById(R.id.buttoncadastrardono);
        this.btCadastroDono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent("NOVO_CADASTRO_DONO");
                startActivityForResult(it, CADASTRODONO);
            }
        });

        //Botão Login
        this.btCadastroAnfitriao = (Button) findViewById(R.id.buttoncadastraranfitriao);
        this.btCadastroAnfitriao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent("NOVO_CADASTRO_ANFITRIAO");
                startActivityForResult(it, CADASTROANFITRIAO);
            }
        });
    }

}

