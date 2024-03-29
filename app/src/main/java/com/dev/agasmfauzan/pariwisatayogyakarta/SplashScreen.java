package com.dev.agasmfauzan.pariwisatayogyakarta;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        EasySplashScreen config = new EasySplashScreen( SplashScreen.this )
                .withFullScreen()
                .withTargetActivity( MainActivity.class )
                .withSplashTimeOut( 5000 )
                .withBackgroundColor( Color.parseColor("#074E72") )
                .withLogo( R.mipmap.ic_launcher )
                .withHeaderText( "Agas Moch Fauzan M" )
                .withFooterText( "Copyright 2019, Thanks for icon from flaticon/freepik")
                .withBeforeLogoText( "Pariwisata Yogyakarta" );

        config.getHeaderTextView().setTextColor( Color.WHITE );
        config.getFooterTextView().setTextColor( Color.WHITE );
        config.getBeforeLogoTextView().setTextColor( Color.WHITE );

        View view = config.create();


        setContentView(view );
    }
}
