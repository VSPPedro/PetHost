package com.example.pedro.pethost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.firebase.client.Firebase;

public class CadastroAnfitriaoActivity extends AppCompatActivity {
    private static final int ANFITRIAO = 1;
    Firebase firebase;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_anfitriao);
        firebase = FirebaseSingleton.getInstance();
    }
}
