package com.powertracker.powertracker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 224336 on 3/25/2017.
 */
public class DashboardFragment extends Fragment {

    private ArrayList<DataPoint> powerData;
    static GraphView graph;
    double powerUsed;
    double cost;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView=inflater.inflate(R.layout.dashboard_fragment,container,false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        graph = (GraphView) getView().findViewById(R.id.graph);
        graph.setMaxY(1.5);
        powerData=new ArrayList<>();
        powerData.add(new DataPoint(0,0.0));
        powerData.add(new DataPoint(5,0.4));
        powerData.add(new DataPoint(10,0.6));
        powerData.add(new DataPoint(15,1.2));
        powerData.add(new DataPoint(20,0.8));
        powerData.add(new DataPoint(30,1.3));
        powerData.add(new DataPoint(35,1.2));
        graph.setData(powerData);


        Runnable mRunnable=new Runnable() {
            @Override
            public void run() {
                while(true){
                    getActivity().runOnUiThread(new Runnable(){
                        public void run(){
                            graph.invalidate();

                            System.out.println("invalidated");
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread myThread=new Thread(mRunnable);
        myThread.start();
    }
}
