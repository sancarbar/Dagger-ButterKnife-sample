package com.tuatara.sample.ui.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.FrameLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.tuatara.sample.MyApplication;
import com.tuatara.sample.R;
import com.tuatara.sample.analytics.Analytics;
import com.tuatara.sample.ui.fragment.SampleFragment;

import javax.inject.Inject;


public class MainActivity
    extends ActionBarActivity
{

    @Inject
    Analytics analytics;

    @InjectView( R.id.fragmentContainer )
    FrameLayout fragmentContainer;


    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        ( (MyApplication) getApplication() ).inject( this );
        ButterKnife.inject( this );
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

    public void startSampleFragment( View view )
    {
        getSupportFragmentManager().beginTransaction().add( R.id.fragmentContainer, new SampleFragment() ).commit();
        fragmentContainer.setVisibility( View.VISIBLE );
    }
}
