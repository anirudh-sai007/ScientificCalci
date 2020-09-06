package com.example.calculatorforanything;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Main2Activity extends AppCompatActivity {
    EditText et1,et2;
    TextView tv1;
    Button bt1,bt2;
    String s1;
    String AES="AES";
    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        et1= (EditText) findViewById(R.id.edittext1);
        et2= (EditText) findViewById(R.id.edittext2);
        tv1=(TextView) findViewById(R.id.plaintext1);
        bt1=(Button) findViewById(R.id.button1);
        bt2=(Button) findViewById(R.id.button2);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    s1=encrypt(et1.getText().toString(),et2.getText().toString());
                    tv1.setText(s1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    s1=decrypt(s1,et2.getText().toString());
                } catch (Exception e) {
                    Toast.makeText(Main2Activity.this,"Wrong Password",Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
                tv1.setText(s1);
            }
        });
    }

    private String decrypt(String s1, String password) throws  Exception{
        SecretKeySpec key=generateKey(password);
        Cipher c=Cipher.getInstance(AES);
        c.init(Cipher.DECRYPT_MODE,key);
        byte[] decodedvalue=Base64.decode(s1,Base64.DEFAULT);
        byte[] decvalue=c.doFinal(decodedvalue);
        String decryptedValue=new String(decvalue);
        return decryptedValue;

    }

    private String encrypt(String Data,String password) throws  Exception
    {
        SecretKeySpec key=generateKey(password);
        Cipher c= Cipher.getInstance(AES);
        c.init(Cipher.ENCRYPT_MODE,key);
        byte[] encVal=c.doFinal(Data.getBytes());
        String encryptedvalue= Base64.encodeToString(encVal,Base64.DEFAULT);
        return encryptedvalue;
    }
    private SecretKeySpec generateKey(String s) throws Exception
    {
        final MessageDigest digest=MessageDigest.getInstance("SHA-256");
        byte[] bytes=s.getBytes("UTF-8");
        digest.update(bytes,0,bytes.length);
        byte[] key=digest.digest();
        SecretKeySpec secretKeySpec =new SecretKeySpec(key,"AES");
        return secretKeySpec;
    }




}
