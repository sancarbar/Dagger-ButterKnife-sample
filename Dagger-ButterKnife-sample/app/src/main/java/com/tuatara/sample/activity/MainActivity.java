package com.tuatara.sample.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import com.tuatara.sample.MyApplication;
import com.tuatara.sample.R;
import com.tuatara.sample.analytics.Analytics;

import javax.inject.Inject;


public class MainActivity
    extends ActionBarActivity
{

    @Inject
    Analytics analytics;

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        ( (MyApplication) getApplication() ).inject( this );
    }


    @Override
    protected void onStart()
    {
        super.onStart();
        analytics.startTracking( this );
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        analytics.stopTracking( this );
    }
}
