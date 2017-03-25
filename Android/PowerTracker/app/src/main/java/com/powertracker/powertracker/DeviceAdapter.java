package com.powertracker.powertracker;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 224336 on 3/25/2017.
 */
public class DeviceAdapter extends RecyclerView.Adapter<DeviceHolder>{

    String[] data;

    public DeviceAdapter(){

    }

    @Override
    public DeviceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(DeviceHolder holder, int position) {

    }

    public int getItemCount(){
        return data.length;
    }
}
