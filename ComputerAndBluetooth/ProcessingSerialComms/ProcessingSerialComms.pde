import bluetoothDesktop.*;
import processing.serial.*;
import java.util.*;

Serial port;
Bluetooth bt;

void setup(){
  //String portName = Serial.list()[0];
  //port = new Serial(this, portName, 9600);
  
  //establish bluetooth connection
  try{
    bt = new Bluetooth(this);
    bt.start("powerServer");
    //bt.find(); //try to find bluetooth servers
  }catch(RuntimeException e){
    e.printStackTrace();
    println("error connecting to bluetooth");
  }
  
}

void deviceDiscoverEvent(Device device){
  println(device.name + " discovered");
}


void draw(){
 /* double[] val = new double[2];
  if(port.available() > 0){
      String temp = port.readString();
      String[] tarray = temp.split(" ");
      val[0] = Integer.parseInt(tarray[0]);
      val[1] = Integer.parseInt(tarray[1]);
  }*/
  
  //send bluetooth information about val
}