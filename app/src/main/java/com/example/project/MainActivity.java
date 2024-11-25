package com.example.project;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class MainActivity extends AppCompatActivity {
    TextView text,text1,text2,text3,text4;
    LinearLayout l1;

    private InterstitialAd mInterstitialAd;
    LinearLayout adContainerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);
        text2 = findViewById(R.id.text2);
        text1 = findViewById(R.id.text1);
        text = findViewById(R.id.text);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent food = new Intent(MainActivity.this,second.class);
                startActivity(food);
                finish();
            }
        });




        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Bus = new Intent(MainActivity.this,Third.class);
                startActivity(Bus);
                finish();
            }
        });
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Truck = new Intent(MainActivity.this,Forth.class);
                startActivity(Truck);
                finish();
            }
        });

        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Launch = new Intent(MainActivity.this,Fifth.class);
                startActivity(Launch);
                finish();
            }
        });
        text4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Ride = new Intent(MainActivity.this,Sixth.class);
                startActivity(Ride);
                finish();
            }
        });





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



    }


}