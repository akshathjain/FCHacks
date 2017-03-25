package com.powertracker.powertracker;

/**
 * Created by 224336 on 3/25/2017.
 */
public class Device {
    private String name;
    private boolean status;
    private int percent;
    private double powerUsed;

    public Device(String name){
        this.name=name;
        status=true;
        percent=0;
        powerUsed=0;
    }

    public double getPowerUsed() {
        return powerUsed;
    }

    public int getPercent() {
        return percent;
    }

    public String getName() {
        return name;
    }

    public boolean getStatus(){
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public void setPowerUsed(double powerUsed) {
        this.powerUsed = powerUsed;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
