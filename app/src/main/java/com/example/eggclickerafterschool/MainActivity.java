package com.example.eggclickerafterschool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonPlay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doButtonAction(View view){
        openGameActivity();
    }

    public void openGameActivity(){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

    public void openHelpActivity(View view){
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }

    public void openStoreActivity(View view){
        Intent intent = new Intent(this, Activity4.class);
        startActivity(intent);
    }


}
