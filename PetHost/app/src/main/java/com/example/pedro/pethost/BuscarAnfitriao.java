package com.example.pedro.pethost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;
import java.util.List;

public class BuscarAnfitriao extends AppCompatActivity {
    private Button button;
    private ListView listview;
    private EditText editText;
    private UserAnfitriao anfitriao;
    private List <UserAnfitriao> lista;
    private Firebase firebase;

    public BuscarAnfitriao()
    {
//        Firebase.setAndroidContext(this);
        Log.i("BD", "DepoisDOContexto");
        this.lista = new ArrayList<UserAnfitriao>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("BD", "entrouNaClasse");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_anfitriao);
        Firebase.setAndroidContext(this);
        this.instaciaComponentes();
        Log.i("BD", "AntesDeCarregar");
//        this.carregarAnfitrioes();
//        AnfitriaoAdapter adapter = new AnfitriaoAdapter(this.lista , this);
//        this.listview.setAdapter(adapter);
        this.button.setOnClickListener(new OnClick());
        this.atualizaAdapter();
    }

    private void instaciaComponentes()
    {
        this.button = (Button) findViewById(R.id.btBuscar);
        this.listview = (ListView) findViewById(R.id.listaResultados);
        this.editText = (EditText) findViewById(R.id.etUsuarioNomeAnfitrao);
    }

    private void atualizaAdapter()
    {
        this.listview.setAdapter(new AnfitriaoAdapter(this.lista , this));
    }

    public void carregarAnfitrioes()
    {
        firebase = FirebaseSingleton.getInstance().child("ContaAnfitriao");
        firebase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String nome = dataSnapshot.child("nome").getValue(String.class);
                String telefone = dataSnapshot.child("telefone").getValue(String.class);
                UserAnfitriao anfitriao = new UserAnfitriao();
                anfitriao.setNome(nome + "  -  " + telefone);
                lista.add(anfitriao);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Log.i("BD", "CARREGOUINFORMACOES");
    }

    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            BuscarAnfitriao.this.carregarAnfitrioes();
            Log.i("BD", "passouPeloCarregamento");
            BuscarAnfitriao.this.atualizaAdapter();
            Log.i("BD","AtualizouOAdapter");
        }
    }
}
