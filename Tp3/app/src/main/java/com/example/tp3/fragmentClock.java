package com.example.tp3;

import android.os.Bundle;
import android.text.Layout;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

public class fragmentClock extends Fragment {
    Boolean digitalOk = true ;

    @Override
    public  void setArguments(Bundle args){
        super.setArguments(args);
        digitalOk = args.getBoolean("digitalOk");
    }

    @Override
    public View onCreateView (LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState){
        View v = null;
        if(digitalOk){
            v= inflater.inflate(R.layout.frag_digital, container ,false);

        }else {
            v= inflater.inflate(R.layout.frag_numeric, container ,false);
        }
        return  v ;


    }
    




}

