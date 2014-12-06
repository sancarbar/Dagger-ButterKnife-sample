package com.tuatara.sample.inject;

import android.content.Context;
import dagger.Module;
import dagger.Provides;

/**
 * @author Santiago Carrillo
 */
@Module( library = true )
public class ContextModule
{
    private final Context context;


    public ContextModule( Context context )
    {
        this.context = context;
    }

    @Provides
    public Context provideContext()
    {
        return context;
    }
}
