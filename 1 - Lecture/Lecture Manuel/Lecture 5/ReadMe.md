# Lecture 5
## S1810455012, Manuel Leibetseder

### Project 2 Presentations

#### My Jarvis
He has ann RFID chip implanted in his right hand

what happens if he is in the pool and the weather turns bad - does he get locked into the pool?

- big home entertainment system
- pool opens/closes automatically
- a lot of wemos, raspis

#### the family group user story

- has a good user story
- no Hue, another bulb including a motion sensor, normal switch (grandma aware)
- they thought of connectivity - 3 WIFI access points
- detailed pool plans
- they haven't found anything for smart garage
- flic.io - dash buttons for ordering (smart buttons)
- Why did you use other bulbs than Hue?

#### Automate friends home
- Roman, 35, rich bitch
- Using Loxone Stuff to automate the home
- Power Redundancy (Battery)
- Calculation of Power Usage
- different approach, work package based presentation
- Why did you use Loxone?


### Project 3 Requirement
- we should use mycroft.ai for voice control
 

### Home Gateways:
#### Home Assistant & openHAB

after installing the python packages required with
	
	
		sudo python3 install -m pip install homeassistant
		
we can view the home assistant UI by visiting 
		
		http://localhost:8123

We need to add the Philips Hue Homebridge and the lightbulbs to the home assistant environment via integration home assitant provides.

```yaml
mqtt:
  broker: 192.168.12.1
  username: iot
  password: iotempire
sensor:
  platform: mqtt
  name: "Temperature"
  state_topic: "node2/temperature/temperature"
  qos: 0
  unit_of_measurement: "ºC"

sensor 2:
  platform: mqtt
  name: "Humidity"
  state_topic: "node2/temperature/humidity"
  qos: 0
  unit_of_measurement: "%"
```

#### Raspberry Pi wrong config
we had the wronng configs commented in in iotempower.conf. MQTT and WIFI wasn't working any more. Lesson learnt - don't mean like you read. We read on the slides we should comment in everything in that conf. Be more careful


#### We helped group 2 (Pirklbauer, Schneglberger)
- with openHAB
- with Philips Hue

#### KNX
- Iris tried to install the program but don't work on her system
- Alex installed the program and it worked
- ETS5 is not supported on macOS

- KNX introduction from ulno was like non existing. we hadn't any idea what we should do and were searcing serial numbers to get something out of the big metal thingy.


- restarting the hardware and connecting it with the USB finally we got a connection to the GIRA 108000
- We then were able to to add:
	- A building
	- A floor
	- A room
- and added a:
	- main group
	- middle group
	- group access
- we connected the access group with the device we added
- the device is MDT AMI-0816.01 (switch)
- we were able to turn physical button on and off via software write value  
