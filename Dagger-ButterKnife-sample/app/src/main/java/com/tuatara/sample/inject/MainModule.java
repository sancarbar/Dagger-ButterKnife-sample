package com.tuatara.sample.inject;

import android.content.Context;
import com.tuatara.sample.ui.activity.MainActivity;
import com.tuatara.sample.analytics.Analytics;
import com.tuatara.sample.analytics.AnalyticsCollection;
import com.tuatara.sample.analytics.FlurryAnalytics;
import com.tuatara.sample.analytics.GoogleAnalytics;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Santiago Carrillo
 */
@Module( injects = { MainActivity.class }, includes = ContextModule.class )
public class MainModule
{

    @Provides
    @Singleton
    public Analytics getAnalytics( Context context )
    {
        List<Analytics> analyticsList = new ArrayList<>(2);
        analyticsList.add( new FlurryAnalytics() );
        analyticsList.add( new GoogleAnalytics() );
        return new AnalyticsCollection( analyticsList );
    }
}
