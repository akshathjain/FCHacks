import bluetoothDesktop.*;
import processing.serial.*;
import java.util.*;

Serial port;
Bluetooth bt;

void setup(){
  size(500,500);
  String portName = Serial.list()[0];
  port = new Serial(this, portName, 9600);
}

void draw(){
  String[] val = new String[2];
  if(port.available() > 0){
    //println(port.readString());
    for(int i = 0; i < 2; i++){
       String temp = port.readString();
       if(temp != null){
         val[i] = temp;
       }
    }
    println(val[0]);
    println(val[1]);
    println(" ");
  }
}