package com.qwx.themedemoapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout llBg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llBg = findViewById(R.id.ll_bg);

        findViewById(R.id.tv_change)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Context themeContext = null;
                        try {
                            themeContext = MainActivity.this.createPackageContext("com.qwx.themeapk", Context.CONTEXT_IGNORE_SECURITY);
                            Resources themeResource = themeContext.getResources();

                            llBg.setBackground(themeResource.getDrawable(themeResource.getIdentifier("ac_bg", "drawable","com.qwx.themeapk")));

                        } catch (PackageManager.NameNotFoundException e) {
                            e.printStackTrace();
                        }

                    }
                });
    }
}