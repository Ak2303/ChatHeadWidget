package com.black.chathead;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class WidgetActivity extends AppCompatActivity {

    public int currFragment = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);

        Button changePage = (Button)findViewById(R.id.changeBtn);
        changePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Replaced Screen", "");
                replaceFragment();
            }
        });
    }


    private void replaceFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(currFragment == 1){

            fragmentTransaction.replace(R.id.fragmentLayout, new SecondScreen());
            currFragment = 2;

        }else{

            fragmentTransaction.replace(R.id.fragmentLayout, new FirstScreen());
            currFragment = 1;
        }
        fragmentTransaction.commit();
    }
}


