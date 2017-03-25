package com.powertracker.powertracker;

/**
 * Created by 224336 on 3/25/2017.
 */
public class DataPoint {
    private double x;
    private double y;
    public DataPoint(double x, double y){
        this.x=x;
        this.y=y;
    }

    public double getX(){
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
