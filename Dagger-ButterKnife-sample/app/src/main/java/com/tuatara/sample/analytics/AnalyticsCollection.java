package com.tuatara.sample.analytics;

import android.content.Context;

import java.util.List;
import java.util.Map;

/**
 * @author Santiago Carrillo
 */
public class AnalyticsCollection
    implements Analytics
{
    private final List<Analytics> analyticsList;

    public AnalyticsCollection( List<Analytics> analyticsList )
    {
        this.analyticsList = analyticsList;
    }


    @Override
    public void sendEvent( String event, Map<String, String> data )
    {
        for ( Analytics analytics : analyticsList )
        {
            analytics.sendEvent( event, data );
        }
    }

    @Override
    public void startTracking( Context context )
    {
        for ( Analytics analytics : analyticsList )
        {
            analytics.startTracking( context );
        }
    }

    @Override
    public void stopTracking( Context context )
    {
        for ( Analytics analytics : analyticsList )
        {
            analytics.stopTracking( context );
        }
    }
}
