package com.example.tp1;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] notes1 = {"17","6","13","17"};
        final String[] notes2 = {"19","8","13","11",};
        final String[] notes3 = {"12","6","12","17"};
        final String[] matiere = {"matiere 1","matiere 2","matiere 3"};

        final ListView notesList = findViewById(R.id.note_list);
        AutoCompleteTextView mes_matieres = findViewById(R.id.matieresTv);


        MaligneAdapter ml1 = new MaligneAdapter(this, notes1);
        MaligneAdapter ml2 = new MaligneAdapter(this, notes2);
        MaligneAdapter ml3 = new MaligneAdapter(this, notes3);

        //final Object[] closeup = { arrayAdapter1, arrayAdapter2, arrayAdapter3 };
        final Object[] closeup = { ml1, ml2, ml3 };

        mes_matieres.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, matiere));

        notesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String val = adapterView.getItemAtPosition(i).toString();
                Toast success = Toast.makeText(getApplicationContext(),"succes",Toast.LENGTH_SHORT);
                Toast failed = Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_SHORT);
                int calc = Integer.parseInt(val);

                if (calc >= 10) {
                    success.show();
                } else failed.show();
            }
        });

        mes_matieres.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int index = adapterView.getPositionForView(view);

                for(int key = 0; key <= matiere.length; key++ ) {
                    notesList.setAdapter((ListAdapter) closeup[index]);
                }

            }
        });
    }
}