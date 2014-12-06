package com.tuatara.sample;

import android.app.Application;
import com.tuatara.sample.inject.ContextModule;
import com.tuatara.sample.inject.MainModule;
import dagger.ObjectGraph;

/**
 * @author Santiago Carrillo
 */
public class MyApplication
    extends Application
{
    private ObjectGraph objectGraph;


    @Override
    public void onCreate()
    {
        super.onCreate();

        objectGraph = ObjectGraph.create( new MainModule(), new ContextModule( this ) );
    }

    public void inject( Object injectionTarget )
    {
        objectGraph.inject( injectionTarget );
    }

}
