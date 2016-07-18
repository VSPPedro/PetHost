package com.example.pedro.pethost;

import com.firebase.client.Firebase;

/**
 * Esta classe servirá para que haja apenas uma instância do firebase
 * @author Matheus Mayer <matheusmayerduarte@gmail.com>
 * @since 18/07/2016
 */
public class FirebaseSingleton
{
//    private static FirebaseSingleton uniqueInstance;
    private static Firebase uniqueInstance;
    private FirebaseSingleton(){}

    /**
     * Este metodo servirá para retornar a unica instancia do firebase
     * @author Matheus Mayer <matheusmayerduarte@gmail.com>
     * @return
     */
    public static Firebase getInstance()
    {
        if (uniqueInstance == null){
            uniqueInstance = new Firebase("https://hospet-17bf7.firebaseio.com/");
        }
        return uniqueInstance;
    }
}
