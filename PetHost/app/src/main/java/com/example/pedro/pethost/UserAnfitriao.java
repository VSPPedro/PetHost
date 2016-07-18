package com.example.pedro.pethost;

import com.firebase.client.Firebase;

public class UserAnfitriao
{
    private int id;

    // Firebase ou object para passar como paramentro!?
    public void insert()
    {
        //adicionar mais um child ali após o contaAnfitriao para buscar o getId.
        Firebase firebase = FirebaseSingleton.getInstance().child("ContaAnfitriao");
        firebase.setValue(this);
    }

//    private boolean isDadosValidos(Firebase.CompletionListener dados)
//    {
//        if () {
//
//        }
//    }
}
