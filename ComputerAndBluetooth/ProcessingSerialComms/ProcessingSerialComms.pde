import bluetoothDesktop.*;
import processing.serial.*;
import java.util.*;

Serial port;
Bluetooth bt;
final int w = 1000;
final int h = 700;

void setup(){
  size(1000, 700);
  textSize(50);
  String portName = Serial.list()[0];
  port = new Serial(this, portName, 9600);
}

int bellam = 0;
String val1 = "";
String val2 = "";

void draw(){
  if(port.available() > 0){
      String temp = port.readString();
      if(temp!=null && !temp.isEmpty() && !temp.equals("")){
        if(bellam % 2 == 0)
           val1 = temp;
         else
           val2 = temp;
        bellam++;
      }
   }
     
    fill(26,188, 288);
    rect(0,0, w, h/2);
    fill(26, 188, 156);
    rect(0,h/2, w,h/2);
    
    fill(255, 255, 255);
    text("Washing Machine: ", 20, h/4.0);
    text("32 inch LCD TV: ", 20, 3.0 * h / 4.0);
    text(val1.substring(0, val1.length() > 0 ? val1.length() - 1 : val1.length()) + " A", 500, h/4.0); 
    text(val2.substring(0, val2.length() > 0 ? val2.length() - 1 : val2.length()) + " A", 500, 3.0 * h / 4.0); 
}