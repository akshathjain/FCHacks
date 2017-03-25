package com.powertracker.powertracker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 224336 on 3/25/2017.
 */
public class DashboardFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView=inflater.inflate(R.layout.dashboard_fragment,container,false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        GraphView graph = (GraphView) getView().findViewById(R.id.graph);
        graph.setMaxY(1.5);
        graph.addData(new DataPoint(0,0));
        graph.addData(new DataPoint(5,0.8));
        graph.addData(new DataPoint(10,1.0));
        graph.addData(new DataPoint(15,0.5));
        graph.update();
    }
}
