package com.tuatara.sample.analytics;

import android.content.Context;
import com.google.android.gms.analytics.Tracker;
import com.tuatara.sample.BuildConfig;

import java.util.Map;

/**
 * @author Santiago Carrillo
 */
public class GoogleAnalytics
    implements Analytics
{

    Tracker tracker;

    @Override
    public void sendEvent( String event, Map<String, String> data )
    {
        tracker.setTitle( event );
        tracker.send( data );
    }

    @Override
    public void startTracking( Context context )
    {
        tracker = com.google.android.gms.analytics.GoogleAnalytics.getInstance( context ).newTracker(
            BuildConfig.GOOGLE_ANALYTICS_ID );
    }

    @Override
    public void stopTracking( Context context )
    {
        com.google.android.gms.analytics.GoogleAnalytics.getInstance( context ).setDryRun( true );
    }
}
