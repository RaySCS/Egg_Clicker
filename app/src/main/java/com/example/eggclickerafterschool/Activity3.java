package com.example.eggclickerafterschool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //This activity just serves to show an image which has the instructions on how to play
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
    }

    public void goBackToMainActivity(View view){
        //purpose of this function is for user to return to main menu
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
