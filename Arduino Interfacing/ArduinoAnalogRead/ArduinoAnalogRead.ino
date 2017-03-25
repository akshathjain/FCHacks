int analogPin1 = 1;     // potentiometer wiper (middle terminal) connected to analog pin 3
int analogPin4 = 4;     // potentiometer wiper (middle terminal) connected to analog pin 3

                       // outside leads to ground and +5V

int val1 = 0;           // variable to store the value read
int val4 = 0;           // variable to store the value read



void setup()

{

  Serial.begin(9600);          //  setup serial

}



void loop()

{

  val1 = analogRead(analogPin1);
  val4 = analogRead(analogPin4);

  float voltage1 = val1 * 2 * (5.0 / 1023.0);// read the input pin and convert to voltage
  float voltage4 = val4 / 10 * (5.0 / 1023.0);// read the input pin and convert to voltage

  Serial.print("Analog 1 Voltage: ");             // debug value
  Serial.println(voltage1); 
  Serial.print("Analog 4 Voltage: ");             // debug value
  Serial.println(voltage4);             // debug value

}

