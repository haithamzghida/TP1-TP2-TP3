package com.example.money_converter;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ed1;
    Button b1;
    RadioButton rb ,rb1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.txtamount);
        b1=findViewById(R.id.b11);
        rb=findViewById(R.id.rb);
        rb1=findViewById(R.id.rb1);




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double total = null;
                Double amount  = Double.parseDouble(ed1.getText().toString());

                if (rb.isChecked() ) {
                    total=amount*3.4;
                    Toast.makeText(getApplicationContext(),total.toString(),Toast.LENGTH_LONG).show();

                    rb1.setChecked(false);
                }
                else  if (rb1.isChecked() ) {
                    total=amount/3.4;
                    Toast.makeText(getApplicationContext(),total.toString(),Toast.LENGTH_LONG).show();

                    rb.setChecked(false);

                }

            }


        });

    }

}