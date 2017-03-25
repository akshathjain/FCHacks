package com.powertracker.powertracker;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by 224336 on 3/25/2017.
 */
public class DeviceHolder extends RecyclerView.ViewHolder{
    TextView name;
    TextView status;
    TextView power;
    TextView percent;

    public DeviceHolder(View itemView) {
        super(itemView);
    }
}
