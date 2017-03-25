package com.powertracker.powertracker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * Created by 224336 on 3/25/2017.
 */
public class DeviceListFragment extends Fragment {




    TextView wms;
    TextView wmp;
    TextView wmper;
    TextView tvs;
    TextView tvp;
    TextView tvper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView=inflater.inflate(R.layout.device_list_fragment,container,false);

        wms=(TextView) rootView.findViewById(R.id.run1);
        wmp=(TextView) rootView.findViewById(R.id.power1);
        wmper=(TextView) rootView.findViewById(R.id.per1);
        tvs=(TextView) rootView.findViewById(R.id.run2);
        tvp=(TextView) rootView.findViewById(R.id.power2);
        tvper=(TextView) rootView.findViewById(R.id.per2);

        Runnable mRunnable=new Runnable() {
            @Override
            public void run() {
                while(true){
                    getActivity().runOnUiThread(new Runnable(){
                        public void run(){
                            boolean run1=Math.random()<0.75;
                            boolean run2=Math.random()<0.75;
                            double pow1=0;
                            double pow2=0;
                            DecimalFormat df=new DecimalFormat("#.##");
                            if(run1){
                                wms.setText("Status: Running");
                                pow1=(Math.random()*0.5)+1;
                            }
                            else{
                                wms.setText("Status: Off");
                            }
                            wmp.setText(df.format(pow1)+" kW");
                            if(run2){
                                tvs.setText("Status: Running");
                                pow2=(Math.random()*0.2)+0.2;
                            }
                            else{
                                tvs.setText("Status: Off");
                            }
                            tvp.setText(df.format(pow2)+" kW");
                            int per1=(int) (pow1/(pow1+pow2)*100);
                            int per2=(int) (pow2/(pow1+pow2)*100);
                            wmper.setText(per1+"%");
                            tvper.setText(per2+"%");
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

        return rootView;
    }
}
