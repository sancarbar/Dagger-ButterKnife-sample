package com.tuatara.sample.analytics;

import android.content.Context;

import java.util.Map;

/**
 * @author Santiago Carrillo
 */
public interface Analytics
{

    public void sendEvent( String event, Map<String, String> data );

    public void startTracking( Context context );

    public void stopTracking( Context context );
    
}
