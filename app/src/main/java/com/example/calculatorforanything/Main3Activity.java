package com.example.calculatorforanything;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Main3Activity extends AppCompatActivity {

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        SharedPreferences p=getSharedPreferences("p",MODE_PRIVATE);
        boolean f=p.getBoolean("f",true);
        if(f){
            showStartDialog();}
    }

    private void showStartDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Enter Your Password")
                .setMessage("Set Your Numeric 4 Digits Password And Confirm It By Pressing '=' Button ")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create().show();
        SharedPreferences p=getSharedPreferences("p",MODE_PRIVATE);
        SharedPreferences.Editor e=p.edit();
        e.putBoolean("p",false);
        e.apply();
    }
}
