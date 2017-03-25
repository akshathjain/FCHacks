package com.powertracker.powertracker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
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
    int hour;
    TextView costView;
    TextView powerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView=inflater.inflate(R.layout.dashboard_fragment,container,false);
        costView =(TextView) rootView.findViewById(R.id.cost);
        powerView =(TextView) rootView.findViewById(R.id.power);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        graph = (GraphView) getView().findViewById(R.id.graph);
        graph.setMaxY(1.5);
        powerData=new ArrayList<>();
        graph.setData(powerData);
        hour=0;
        cost=0;
        Runnable mRunnable=new Runnable() {
            @Override
            public void run() {
                while(true){
                    getActivity().runOnUiThread(new Runnable(){
                        public void run(){
                            graph.invalidate();
                            double input=(Math.random()*2)+8;
                            powerUsed=120*input/1000.0;
                            cost=powerUsed*0.132;

                            hour++;
                            graph.addData(new DataPoint(hour,powerUsed));


                            DecimalFormat pFormat=new DecimalFormat("#0.00");
                            DecimalFormat cFormat=new DecimalFormat("$#0.00");
                            powerView.setText(pFormat.format(powerUsed)+" kW");
                            costView.setText("Cost/Hour: "+cFormat.format(cost));
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
