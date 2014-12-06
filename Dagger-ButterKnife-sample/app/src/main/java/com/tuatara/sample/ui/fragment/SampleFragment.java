package com.tuatara.sample.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.tuatara.sample.R;

/**
 * @author Santiago Carrillo
 */
public class SampleFragment
    extends Fragment
{

    @InjectView( R.id.label )
    TextView label;


    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container,
                              @Nullable Bundle savedInstanceState )
    {
        View view = inflater.inflate( R.layout.fragment_sample, container, false );
        ButterKnife.inject( this, view );
        return view;
    }

    @OnClick( R.id.updateLabelValue )
    public void updateLabelValue( View view )
    {
        label.setText( getString( R.string.injection_worked_properly ) );
    }
}
