package com.example.pedro.pethost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.firebase.client.Firebase;

public class DonoActivity extends AppCompatActivity {
    private static final int DONO = 1;
    private Button btLoginDono;
    private Firebase firebase;

    public DonoActivity()
    {
        this.firebase = FirebaseSingleton.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_dono);
    }

    /**
     * Metodo que resgata os componentes da view
     * @author Matheus Mayer <matheusmayerduarte@gmail.com>
     */
    private void iniciarComponentes()
    {

    }
}
