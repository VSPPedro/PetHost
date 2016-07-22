package com.example.pedro.pethost;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Pedro on 22/07/2016.
 * BroadCastReceiver
 */
public class BateriaBaixa extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        AlertDialog.Builder aDBuilder = new AlertDialog.Builder(context);
        aDBuilder.setTitle("Bateria Fraca");
        aDBuilder.setMessage("Bateria fraca!");
        AlertDialog alert = aDBuilder.create();
        alert.show();
    }
}
