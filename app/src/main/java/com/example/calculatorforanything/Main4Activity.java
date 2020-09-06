package com.example.calculatorforanything;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    EditText et1,et2;
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
        Button bt1 = (Button) findViewById(R.id.button1);
        tv1 = (TextView) findViewById(R.id.textView);
        tv1.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        tv1.setSelected(true);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (et1.getText().toString().trim().length() == 0) {
                    et1.requestFocus();
                    et1.setError("Field Is Empty!....");
                } else if (et2.getText().toString().trim().length() == 0) {
                    et2.requestFocus();
                    et2.setError("Field Is Empty!....");
                } else if (!et1.getText().toString().trim().matches("[0-9]+") && !et2.getText().toString().trim().matches("[0-9]+")) {
                    et1.requestFocus();
                    et1.setError("Enter Numbers Only!....");
                    et2.requestFocus();
                    et2.setError("Enter Numbers Only!....");
                } else if (!et2.getText().toString().trim().matches("[0-9]+") && et1.getText().toString().trim().matches("[0-9]+")) {
                    et2.requestFocus();
                    et2.setError("Enter Numbers Only!....");
                } else if (!et1.getText().toString().trim().matches("[0-9]+") && et2.getText().toString().trim().matches("[0-9]+")) {
                    et1.requestFocus();
                    et1.setError("Enter Numbers Only!....");
                } else if (!et1.getText().toString().trim().equals(et2.getText().toString().trim())) {
                    et2.requestFocus();
                    et2.setError("Password Is Incorrect");

                } else if (et1.getText().toString().trim().matches("[0-9]+") && et2.getText().toString().trim().matches("[0-9]+") && et1.getText().toString().trim().length() >= 4 && et2.getText().toString().trim().length() >= 4) {
                    if (et1.getText().toString().trim().equals(et2.getText().toString().trim())) {
                        Intent it = new Intent(Main4Activity.this, Main3Activity.class);
                        Toast.makeText(Main4Activity.this, "Password Set Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(it);
                    }


                }
            }

        });
    }
}
