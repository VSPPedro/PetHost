package com.example.pedro.pethost;

import android.app.Application;

/**
 * Classe responsável por iniciar o contexto no Firebase
 * @author Matheus Mayer <matheusmayerduarte@gmail.com>
 */
public class CustomApplication extends Application
{
    /**
     * Metodo servirá para setar o contexto no Firebase
     * @author Matheus Mayer <matheusmayerduarte@gmail.com>
     */
    @Override
    public void onCreate()
    {
        super.onCreate();
        FirebaseSingleton.getInstance().setAndroidContext(this);
    }
}
