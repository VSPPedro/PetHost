package com.example.pedro.pethost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class CadastroAnfitriaoActivity extends AppCompatActivity {
    private static final int ANFITRIAO = 1;
    private Firebase firebase;
    private EditText nome;
    private EditText endereco;
    private EditText telefone;
    private EditText email;
    private EditText senha;
    private Button cadastrar;
    private UserAnfitriao user;

    /**
     * Construtor da classe
     * @author Matheus Mayer <matheusmayerduarte@gmail.com>
     */
    public CadastroAnfitriaoActivity()
    {
        this.user = new UserAnfitriao();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_anfitriao);
        Firebase.setAndroidContext(this);
        this.firebase = FirebaseSingleton.getInstance();
        this.iniciarComponentes();
        this.cadastrar.setOnClickListener(new OnClick());
    }

    /**
     * Metodo servirá para recuperar os componentes da view
     * @author Matheus Mayer <matheusmayerduarte@gmail.com>
     */
    private void iniciarComponentes()
    {
        this.nome = (EditText) findViewById(R.id.etUsuarioNomeAnfitrao);
        this.endereco = (EditText) findViewById(R.id.etUsuarioEnderecoAnfitrao);
        this.telefone = (EditText) findViewById(R.id.etUsuarioTelefoneAnfitrao);
        this.email = (EditText) findViewById(R.id.etEmailAnfitriao);
        this.senha = (EditText) findViewById(R.id.etSenhaCadastroAnfitrao);
        this.cadastrar = (Button) findViewById(R.id.btCadastrarAnfitriao);
    }

    /**
     * Metodo repassa a responsabilidade de persistir ao model
     * @author Matheus Mayer <matheusmayerduarte@gmail.com>
     */
    private void salvarAnfitriao()
    {
        user.insert();
    }

    /**
     * Metodo cria o objeto UserAnfitriao para ser persistido no firebase
     * @author Matheus Mayer <matheusmayerduarte@gmail.com>
     */
    private void setDadosUser()
    {
        user.setNome(this.nome.getText().toString());
        user.setEmail(this.email.getText().toString());
        user.setEndereco(this.endereco.getText().toString());
        user.setTelefone(this.telefone.getText().toString());
        user.setSenha(this.senha.getText().toString());
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
            CadastroAnfitriaoActivity.this.setDadosUser();
            CadastroAnfitriaoActivity.this.salvarAnfitriao();
        }
    }
}
