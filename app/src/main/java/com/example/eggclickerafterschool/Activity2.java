package com.example.eggclickerafterschool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    public static int pointsAcrossActivities = 0;

    public static boolean powerUpOnePurchased = false;
    public static boolean powerUpTwoPurchased = false;
    public static boolean powerUpThreePurchased = false;
    public static boolean powerUpFourPurchased = false;
    public static boolean themeOnePurchased = false;
    public static boolean themeTwoPurchased = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        pointTextView = (TextView)findViewById(R.id.pointTextView);
        tapsNeededTextView = (TextView)findViewById(R.id.tapsNeededTextView);
        timeTakenView = (TextView)findViewById(R.id.timeTakenView);
        multiplierTextView = (TextView)findViewById(R.id.multiplierTextView);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.eggimage);
        yokeImageView = (ImageView)findViewById(R.id.yokeImageView);
        backgroundImageView = (ImageView)findViewById(R.id.backgroundImageView);
        yokeImageView.setVisibility(View.INVISIBLE);
        whichLevelEgg = 0;
        numTapsNeededDisplay = 0;
        arrayOfTapsNeeded = new int[]{5,10,25,50,75,100,200,400,800,1600,3200,6400,12800};//initializing the array with values for taps needed
        if(powerUpOnePurchased){
            multiplierTextView.setText("Multiplier: 2x");//determing what multiplier is being used
        }
        else if(powerUpTwoPurchased){
            multiplierTextView.setText("Multiplier: 4x");
        }
        else{
            multiplierTextView.setText("Multiplier: 1x");
        }
        if(themeOnePurchased) {
            backgroundImageView.setImageResource(R.drawable.themetwo);//determining which theme the background is
        }
        else if(themeTwoPurchased) {
            backgroundImageView.setImageResource(R.drawable.themeone);
        }
        else{
            backgroundImageView.setImageResource(android.R.color.transparent);//or else the regular white
        }
        setNumberTapsNeeded();
        eggHittingSound = MediaPlayer.create(this, R.raw.actualhitegg);//creating the sounds
        eggCrackedSound = MediaPlayer.create(this, R.raw.crackingeggsound);

    }

    MediaPlayer eggHittingSound;
    MediaPlayer eggCrackedSound;
    //consider start button. setNumberTapsNeeded();
    int numberOfTapsTotal = 0;//total taps does not change
    int numberOfTapsCurrentRound = 0;
    int whichLevelEgg;
    double numTapsNeededDisplay;
    double numTapsNeededCurrentRound = 0;
    int[] arrayOfTapsNeeded;
    TextView pointTextView;
    TextView tapsNeededTextView;
    TextView timeTakenView;
    TextView multiplierTextView;
    ImageView imageView;
    ImageView yokeImageView;
    ImageView backgroundImageView;


    long aMillisPressed;
    long bMillisPressed;

    public void handleClick(View view){

        if(powerUpOnePurchased){
            incrementTaps(2);
            multiplierTextView.setText("Multiplier: 2x");
        }
        else if(powerUpTwoPurchased){
            incrementTaps(4);
            multiplierTextView.setText("Multiplier: 4x");
        }
        else{
            incrementTaps(1);
            multiplierTextView.setText("Multiplier: 1x");
        }

    }

    public void incrementTaps(int multiplier){
        //Purpose of this function is to add to the total taps and call another function to check if egg has been cracked
        numberOfTapsTotal+=multiplier;
        pointsAcrossActivities+=multiplier;
        numberOfTapsCurrentRound+=multiplier;
        pointTextView.setText("Points: " + numberOfTapsTotal);
        numTapsNeededDisplay-=multiplier;
        tapsNeededTextView.setText("Taps Needed: " + numTapsNeededDisplay);
        compareClicksNeeded();
    }
    int totalDone = 0;
    long initialTime = 0;
    long endTime = 0;
    public void compareClicksNeeded(){
        //Purpose of this function is to not only record the time taken to crack an egg
        //But also, to check whether or not if an egg has been cracked by comparing it to the egg clicks needed array
        if(initialTime == 0){
            initialTime = System.currentTimeMillis();
        }
        else {

        }
        if(numberOfTapsCurrentRound >= numTapsNeededCurrentRound){
            eggCrackedSound.start();
            numberOfTapsCurrentRound = 0;
            numTapsNeededCurrentRound = 0;
            whichLevelEgg++;
            imageView.setImageResource(R.drawable.crackedegg);//setting images to the cracked egg
            yokeImageView.setVisibility(View.VISIBLE);
            setNumberTapsNeeded();
            endTime = System.currentTimeMillis();
            long diff = endTime - initialTime;
            initialTime = endTime;
            timeTakenView.setText("Time Taken: " + diff/1000.0 + " s");//getting the time in regular format for seconds
        }
        else{
            imageView.setImageResource(R.drawable.eggimage);
            yokeImageView.setVisibility(View.INVISIBLE);
        }
    }

    public void setNumberTapsNeeded(){
        //Purpose of this function is to let the user know how many more clicks they need to crack an egg
        numTapsNeededDisplay = arrayOfTapsNeeded[whichLevelEgg];//changed for display purposes
        numTapsNeededCurrentRound = arrayOfTapsNeeded[whichLevelEgg];//does not change
        if(powerUpThreePurchased){
            numTapsNeededDisplay = (int)(numTapsNeededDisplay*.75);
            numTapsNeededCurrentRound = (int)(numTapsNeededCurrentRound*.75);
        }
        if(powerUpFourPurchased){
            numTapsNeededDisplay = (int)(numTapsNeededDisplay*.50);
            numTapsNeededCurrentRound = (int)(numTapsNeededCurrentRound*.50);
        }
        tapsNeededTextView.setText("Taps Needed: " + numTapsNeededDisplay);
    }


    public void goBackToMainActivity(View view){
        //purpose of this function is for user to return to main menu
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
