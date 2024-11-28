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
import androidx.cardview.widget.CardView;
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
    CardView l1,l2,l3,l4,l5;

    private InterstitialAd mInterstitialAd;
    LinearLayout adContainerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        l1 = findViewById(R.id.l1);
        l2 = findViewById(R.id.l2);
        l3 = findViewById(R.id.l3);
        l4 = findViewById(R.id.l4);
        l5 = findViewById(R.id.l5);


        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent food = new Intent(MainActivity.this,second.class);
                startActivity(food);
                finish();
            }
        });




        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Bus = new Intent(MainActivity.this,Third.class);
                startActivity(Bus);
                finish();
            }
        });
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Truck = new Intent(MainActivity.this,Forth.class);
                startActivity(Truck);
                finish();
            }
        });

        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Launch = new Intent(MainActivity.this,Fifth.class);
                startActivity(Launch);
                finish();
            }
        });
        l5.setOnClickListener(new View.OnClickListener() {
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
        adContainerView = findViewById(R.id.adContainerView);
        adContainerView.setVisibility(View.GONE);
        if (getString(R.string.show_admob_ad).contains("ON")) {
            initAdmobAd();
            loadBannerAd();
            loadFullscreenAd();
        }



    }
    private void initAdmobAd() {
        // AdMob Initialization
        MobileAds.initialize(this, initializationStatus -> {});
    }


    // Banner Ad Load Counter
    int BANNER_AD_CLICK_COUNT = 0;

    // loadBannerAd method
    private void loadBannerAd() {
        // Create a new ad view and set the ad unit ID and size
        AdView adView = new AdView(this);
        adView.setAdUnitId("ca-app-pub-3940256099942544/9214589741"); // Test Ad Unit ID
        adView.setAdSize(AdSize.BANNER);

        // Add the ad view to the container and load the ad
        adContainerView.removeAllViews();
        adContainerView.addView(adView);

        // Start loading the ad
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        adView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                if (BANNER_AD_CLICK_COUNT >= 2) {
                    if (adContainerView != null) adContainerView.setVisibility(View.GONE);
                } else {
                    if (adContainerView != null) adContainerView.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
            }

            @Override
            public void onAdClicked() {
                BANNER_AD_CLICK_COUNT++;
                if (BANNER_AD_CLICK_COUNT >= 2) {
                    if (adContainerView != null)adContainerView.setVisibility(View.GONE);
                }
            }
        });
    }

    // Fullscreen Ad Load Counter
    int FULLSCREEN_AD_LOAD_COUNT = 0;

    // loadFullscreenAd method
    private void loadFullscreenAd() {
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                mInterstitialAd = interstitialAd;
                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    @Override
                    public void onAdDismissedFullScreenContent() {
                        FULLSCREEN_AD_LOAD_COUNT++;
                        if (FULLSCREEN_AD_LOAD_COUNT < 3) loadFullscreenAd();
                        Log.d("FULLSCREEN_AD", "Ad dismissed. Load count: " + FULLSCREEN_AD_LOAD_COUNT);
                    }
                });
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                mInterstitialAd = null;
                Log.d("FULLSCREEN_AD", "Failed to load interstitial ad: " + loadAdError.getMessage());
            }
        });
    }

    // Show Interstitial Ad
    private void showInterstitial() {
        if (mInterstitialAd != null) {
            mInterstitialAd.show(this);
        } else {
            Log.d("INTERSTITIAL_AD", "Interstitial ad is not ready yet.");
        }
    }


}