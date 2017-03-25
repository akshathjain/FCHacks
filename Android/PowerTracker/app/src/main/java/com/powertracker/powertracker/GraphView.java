package com.powertracker.powertracker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.provider.ContactsContract;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by 224336 on 3/25/2017.
 */
public class GraphView extends View {

    private double maxY;
    private double maxX;

    private ArrayList<DataPoint> data;

    public GraphView(Context context, AttributeSet attrs) {
        super(context, attrs);
        data=new ArrayList<>();
    }

    public GraphView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        data=new ArrayList<>();
    }

    //Helper function for overriden constructors

    public void addData(DataPoint d){
        data.add(d);
    }

    public void setMaxX(double maxX) {
        this.maxX = maxX;
    }

    public void setMaxY(double maxY) {
        this.maxY = maxY;
    }

    public void update(){
        invalidate();
    }

    @Override
    protected void onDraw(Canvas c){
        ArrayList<Double> temp =new ArrayList();
        for(DataPoint d:data){
            temp.add(d.getX());
        }
        Collections.sort(temp);
        maxX=temp.get(temp.size()-1)+1;
        int height=this.getHeight();
        int width=this.getWidth();
        Paint gridPaint=new Paint(Color.LTGRAY);
        for(int i=0;i<height;i+=height/5){
            c.drawLine(0,i,width,i,gridPaint);
        }
        for(int i=0;i<width;i+=width/5){
            c.drawLine(i,0,i,height,gridPaint);
        }
        Paint linePaint=new Paint(Color.BLACK);
        linePaint.setStrokeWidth(5);
        for(int i=0;i<data.size();i++){
            double x = data.get(i).getX() * width / maxX;
            double y = height-(data.get(i).getY() * height / maxY);
            double prevX=0;
            double prevY=0;
            if(i!=0){
                prevX = data.get(i-1).getX() * width / maxX;
                prevY = height-(data.get(i-1).getY() * height / maxY);
            }
            c.drawLine((float)prevX,(float)prevY,(float)x,(float)y,linePaint);
        }
    }
}
