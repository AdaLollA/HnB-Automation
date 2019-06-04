#Lecture #2

## Setting up the Pi, creating nodes and dongles

- 70% of flashing wemos on the raspberry pi fails
- ulno is preflashing us the nodes we need to do the LED blink on
- it would be possible to flash them by ourself via this [link](https://github.com/iotempire/iotempower/blob/master/doc/installation.rst#installation-on-linux)
- if wemos blinks 10x it is in reboot mode

		output(blue, ONBOARDLED, "off", "on").set("off");
		input(b1, D3, "depressed", "pressed");

- commands to do on the pi:
	- iot
	- upgrade cache

- make the pi work to adopt nodes:
	
		iot
		rm -rf /home/iot/.platformio/packages/framework-arduinoespressif8266
		cd iot-test/node1/ 
 		compile
 
 
## RGB-LED w/ smartphone and nodeRED
 
 
 - https://iotgateway/doc/node_help/rgb_single
 
 		rgb_single(led, D1, D2, D3, true);
 		
## RGB-LED-Strip w/ nodered

- https://iotgateway/doc/node_help/rgb_strip

		rgb_strip(strip, 7, WS2812, D4, GRB);

## Smart Lock

 		
 
