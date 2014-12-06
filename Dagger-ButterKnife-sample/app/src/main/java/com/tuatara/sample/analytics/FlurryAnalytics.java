package com.tuatara.sample.analytics;

import android.content.Context;
import com.flurry.android.FlurryAgent;
import com.tuatara.sample.BuildConfig;

import java.util.Map;

/**
 * @author Santiago Carrillo
 */
public class FlurryAnalytics
    implements Analytics
{
    @Override
    public void sendEvent( String event, Map<String, String> data )
    {
        if ( null != data )
        {
            FlurryAgent.logEvent( event, data );
        }
        else
        {
            FlurryAgent.logEvent( event );
        }
    }

    @Override
    public void startTracking( Context context )
    {
        FlurryAgent.onStartSession( context, BuildConfig.FLURRY_ID );
    }

    @Override
    public void stopTracking( Context context )
    {
        FlurryAgent.onEndSession( context );
    }
}
