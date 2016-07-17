package com.example.pedro.pethost;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PerfilDono extends AppCompatActivity {
    private static final int FOTO = 1;
    private TextView textHelloUser;
    private Button bCaptureImage;
    private Button bBuscarAnfitriao;
    private ImageView fotoPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_dono);

        this.fotoPerfil = (ImageView) findViewById(R.id.imageUsuarioPerfil);
        this.textHelloUser = (TextView) findViewById(R.id.nomeUsuarioPerfil);

        //Botão mudar foto
        this.bCaptureImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(it, PerfilDono.this.FOTO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            if (requestCode == FOTO){
                PerfilDono.this.fotoPerfil.setImageBitmap((Bitmap) data.getParcelableExtra("data"));
            }
        }
    }
}
