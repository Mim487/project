package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Fifth extends AppCompatActivity {
    WebView wv;
    public static String vd_url = "";
    LinearLayout l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    LinearLayout vd;
    ImageView img5;
    boolean work = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fifth);
        vd = findViewById(R.id.vd);
        wv = findViewById(R.id.wv);

        l1 = findViewById(R.id.l1);
        l2 = findViewById(R.id.l2);
        l3 = findViewById(R.id.l3);
        l4 = findViewById(R.id.l4);
        l5 = findViewById(R.id.l5);
        l6 = findViewById(R.id.l6);
        l7 = findViewById(R.id.l7);
        l8 = findViewById(R.id.l8);
        l9 = findViewById(R.id.l9);
        l10 = findViewById(R.id.l10);
        img5 = findViewById(R.id.img5);

        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (work){
                    wv.setVisibility(View.GONE);


                }else {
                    wv.setVisibility(View.VISIBLE);


                }
                work = false;


            }
        });

        wv = findViewById(R.id.wv);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl(vd_url);


        wv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ok = new Intent(Fifth.this,MainActivity.class);
                startActivity(ok);
            }
        });


        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               wv.loadUrl("https://www.youtube.com/embed/AIvaEjihqi8?si=Z8BEJmVUOfuyJGf9");
               wv.setVisibility(View.VISIBLE);

            }
        });
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wv.loadUrl("https://www.youtube.com/embed/AIvaEjihqi8?si=Z8BEJmVUOfuyJGf9");
                wv.setVisibility(View.VISIBLE);



            }
        });
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wv.loadUrl("https://www.youtube.com/embed/Y9YQggN56sM?si=0FDB9zD-NXcgRrkX");
                wv.setVisibility(View.VISIBLE);

            }
        });
        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wv.loadUrl("https://www.youtube.com/embed/NY1cMgz1JF0?si=PXJUz1sUJN0e_LMe");
                wv.setVisibility(View.VISIBLE);

            }
        });
        l5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wv.loadUrl("https://www.youtube.com/embed/VIgd99Tes5o?si=MrinURLspl4iQeqg");
                wv.setVisibility(View.VISIBLE);

            }
        });
        l6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wv.loadUrl("https://www.youtube.com/embed/R7aCOI4DuA0?si=ra7kAJHnSt5IIz4R");
                wv.setVisibility(View.VISIBLE);

            }
        });
        l7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wv.loadUrl( "https://www.youtube.com/embed/qsDekDjn9LA?si=9m7NkDp0PSXBtjju");
                wv.setVisibility(View.VISIBLE);

            }
        });
        l8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wv.loadUrl("https://www.youtube.com/embed/Re7zBF6gFRM?si=dYHoeN3r-MSXnSkj");
                wv.setVisibility(View.VISIBLE);

            }
        });
        l9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wv.loadUrl("https://www.youtube.com/embed/Dai9lZ4Sne0?si=RykwVmaMk9_vEGAv");
                wv.setVisibility(View.VISIBLE);

            }
        });
        l10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wv.loadUrl("https://www.youtube.com/embed/kMUijDNYq_M?si=ErXPDAjuCl9rVzW2");
                wv.setVisibility(View.VISIBLE);

            }
        });




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}