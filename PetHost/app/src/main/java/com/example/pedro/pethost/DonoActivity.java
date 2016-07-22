package com.example.pedro.pethost;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class DonoActivity extends AppCompatActivity {
    private static final int DONO = 1;
    private static final int LOGIN = 1;
    private Firebase firebase;
    private EditText nome;
    private EditText email;
    private EditText senha;
    private UserDono user;
    private Button cadastrar;

    /**
     * Construtor da classe
     * @author Matheus Mayer <matheusmayerduarte@gmail.com>
     */
    public DonoActivity()
    {
        this.user = new UserDono();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_dono);
        Firebase.setAndroidContext(this);
        this.firebase = FirebaseSingleton.getInstance();
        this.iniciarComponentes();
        this.cadastrar.setOnClickListener(new OnClick());
    }
    /**
     * Metodo cria o objeto UserAnfitriao para ser persistido no firebase
     * @author Matheus Mayer <matheusmayerduarte@gmail.com>
     */
    private void setDadosUser()
    {
        user.setNome(this.nome.getText().toString());
        user.setEmail(this.email.getText().toString());
        user.setSenha(this.senha.getText().toString());
    }

    /**
     * Metodo que resgata os componentes da view
     * @author Matheus Mayer <matheusmayerduarte@gmail.com>
     */
    private void iniciarComponentes()
    {
        this.nome = (EditText) findViewById(R.id.etUsuarioNome);
        this.email = (EditText) findViewById(R.id.etUsuarioEmail);
        this.senha = (EditText) findViewById(R.id.etSenhaCadastro);
        this.cadastrar = (Button) findViewById(R.id.btCadastrarDono);
    }

    /**
     * Metodo repassa a responsabilidade de persistir ao model
     * @author Matheus Mayer <matheusmayerduarte@gmail.com>
     */
    private void salvarDono()
    {
        user.insert();
    }

    /**
     * Esta classe servirá para monitorar o click do botao cadastrar
     * @author Matheus Mayer <matheusmayerduarte@gmail.com>
     */
    private class OnClick implements View.OnClickListener
    {
        /**
         * Metodo que monitora os clicks do botao cadastrar
         * @author Matheus Mayer <matheusmayerduarte@gmail.com>
         * @param v
         */
        @Override
        public void onClick(View v)
        {
            DonoActivity.this.setDadosUser();
            DonoActivity.this.salvarDono();
            Intent it = new Intent("NOVO_PERFIL_DONO");
            startActivityForResult(it, LOGIN);
        }
    }
}
