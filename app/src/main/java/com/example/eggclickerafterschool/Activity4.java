package com.example.eggclickerafterschool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity4 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        textViewPtsAvailable = (TextView)findViewById(R.id.textViewPtsAvailable);
        transactionUpdate = (TextView)findViewById(R.id.transactionUpdate) ;
        textViewPtsAvailable.setText("Points: " +  Activity2.pointsAcrossActivities);
    }

    TextView textViewPtsAvailable;

    ImageView pOneImageView;
    ImageView pTwoImageView;
    ImageView pThreeImageView;
    ImageView pFourImageView;
    ImageView pFiveImageView;
    ImageView pSixImageView;

    int pOneTap = 0;
    int pTwoTap = 0;
    int pThreeTap = 0;
    int pFourTap = 0;
    int pFiveTap = 0;
    int pSixTap = 0;
    TextView transactionUpdate;

    public void goBackToMainActivity(View view){
        //purpose of this function is for user to return to main menu
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void purchasePowerUpOne(View view){
        //Purpose of all of these power up functions is for user to purchase them and use them
        pOneTap++;
        if(pOneTap == 1){
            transactionUpdate.setText("Are you sure? If yes, tap again");
        }
        if(pOneTap == 2){
            if( Activity2.pointsAcrossActivities >= 50){
                transactionUpdate.setText("Transaction Successful!");
                Activity2.powerUpOnePurchased = true;
                Activity2.powerUpTwoPurchased = false;
                Activity2.pointsAcrossActivities-=50;
                textViewPtsAvailable.setText("Points: " +  Activity2.pointsAcrossActivities);
            }
            else{
                transactionUpdate.setText("Transaction Unsuccessful!");
            }
        }
    }

    public void purchasePowerUpTwo(View view){
        pTwoTap++;
        if(pTwoTap == 1){
            transactionUpdate.setText("Are you sure? If yes, tap again");
        }
        if(pTwoTap == 2){
            if( Activity2.pointsAcrossActivities >= 100){
                transactionUpdate.setText("Transaction Successful!");
                Activity2.powerUpTwoPurchased = true;
                Activity2.powerUpOnePurchased = false;
                Activity2.pointsAcrossActivities-=100;
                textViewPtsAvailable.setText("Points: " +  Activity2.pointsAcrossActivities);
            }
            else{
                transactionUpdate.setText("Transaction Unsuccessful!");
            }
        }
    }

    public void purchasePowerUpThree(View view){
        pThreeTap++;
        if(pThreeTap == 1){
            transactionUpdate.setText("Are you sure? If yes, tap again");
        }
        if(pThreeTap == 2){
            if( Activity2.pointsAcrossActivities >= 200){
                transactionUpdate.setText("Transaction Successful!");
                Activity2.powerUpThreePurchased = true;
                Activity2.powerUpFourPurchased = false;
                Activity2.pointsAcrossActivities-=200;
                textViewPtsAvailable.setText("Points: " +  Activity2.pointsAcrossActivities);
            }
            else{
                transactionUpdate.setText("Transaction Unsuccessful!");
            }
        }
    }

    public void purchasePowerUpFour(View view){
        pFourTap++;
        if(pFourTap == 1){
            transactionUpdate.setText("Are you sure? If yes, tap again");
        }
        if(pFourTap == 2){
            if( Activity2.pointsAcrossActivities >= 300){
                transactionUpdate.setText("Transaction Successful!");
                Activity2.powerUpFourPurchased = true;
                Activity2.powerUpThreePurchased = false;
                Activity2.pointsAcrossActivities-=300;
                textViewPtsAvailable.setText("Points: " +  Activity2.pointsAcrossActivities);
            }
            else{
                transactionUpdate.setText("Transaction Unsuccessful!");
            }
        }
    }

    public void purchaseThemeUpOne(View view){
        pFiveTap++;
        if(pFiveTap == 1){
            transactionUpdate.setText("Are you sure? If yes, tap again");
        }
        if(pFiveTap == 2){
            if(Activity2.pointsAcrossActivities >= 350){
                transactionUpdate.setText("Transaction Successful!");
                Activity2.pointsAcrossActivities-=350;
                Activity2.themeOnePurchased = true;
                Activity2.themeTwoPurchased = false;
                textViewPtsAvailable.setText("Points: " +  Activity2.pointsAcrossActivities);
            }
            else{
                transactionUpdate.setText("Transaction Unsuccessful!");
            }
        }
    }

    public void purchaseThemeUpTwo(View view){
        pSixTap++;
        if(pSixTap == 1){
            transactionUpdate.setText("Are you sure? If yes, tap again");
        }
        if(pSixTap == 2){
            if(Activity2.pointsAcrossActivities >= 500){
                transactionUpdate.setText("Transaction Successful!");
                Activity2.pointsAcrossActivities-=500;
                Activity2.themeOnePurchased = false;
                Activity2.themeTwoPurchased = true;
                textViewPtsAvailable.setText("Points: " +  Activity2.pointsAcrossActivities);
            }
            else{
                transactionUpdate.setText("Transaction Unsuccessful!");
            }
        }
    }
}
