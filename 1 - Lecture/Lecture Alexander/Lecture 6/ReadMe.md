# Lecture 6
## S1810455024, Alexander Stelzhammer

### Project 3: Brainstorming
#### Usable devices
- Smart Lock + RFID Scanner with Two-Factor-Authentication
- Humidity Sensor (several)
- Temperature Sensor (several)
- Brightness Sensor (several)
- Philip Hue LED Lamps (1 color, 1 white)

#### Automation Software
- OpenHAB
- home-assistant

#### Scenarios

Our protagonist is called Yeet. He is ... and his occupation is .... 

##### Scenario #1
Yeet arrives home and wants to get into the house. He takes out his RFID chip, holds it on the scanner and the door unlocks.

##### Scenario #2
The brightness sensor continually measures the brightness in the room and the Philip Hue lights in the house, if turned on, are dimmed accordingly to the brightness in the room.

##### Scenario #3
Yeet is very sensitive to dry air in his flat. Using his home automation skills he connected his air damper to a Z-Wave plug. A humidity sensor provides values how dry the air is and once a certain threshold is reached, the plug is activated and the air damper starts running to make the air more humid.

##### Scenario #4
Yeet has a date with his soon-to-be third girlfriend. He is in a hurry and leaves the house but forgets to water his favorite plant. This, however, is no big deal as he installed a DIY watering system for his favorite plant. A water pump is triggered as soon as the respective humidity, brightness, and temperature sensor reach a certain combined value.

##### Scenario #5
Gas/fire sensor for detecting burning stove?


### Project 3: Watering System
Lorenz and I were tasked with the implementation of the watering system. We spent two days on the weekend to setup the hardware and its wiring as well as programming the Wemos D1 Mini to read the sensors and react accordingly to them.
We faced several difficulties, mainly due to inappropriate hardware and our toolbox looked away in FH2 on a Sunday afternoon.
If you want to know more about our adventures on said weekend, please refer to [Lorenz' documentation](../../../4%20-%20Project3/Watering%20System/readme.md).

### Thoughts/Opinion
#### Thoughts on the team
Working together with Manuel, Michael, Lorenz, and Iris worked really well. We used divide and conquer to split the several tasks among all team members. With Michael and Lorenz being our hardware guys, Manuel, Iris, and I focused on implementing and configuring the gadgets to send MQTT messages or something similar. Lorenz and I focused on implementing the Vertical Gardening gadget and really enjoyed figuring out the sensors that I ordered from Amazon.

#### Thoughts on the watering system
Implementing the watering system was not easy. The sensors that were ordered on Amazon turned out to give some problems. We did not have enough Wemos devices to use the analog pin of each sensor (which would give actual numerical readings instead of LOW or HIGH). Thus, we used a board that was lying around in Lorenz's room that already had a built in I²C temperature sensor. We used the only analog pin of the Wemos to measure the ground moisture of the plant as it is the most critical aspect of the watering system. The remaining brightness sensor provided digital readings (LOW/HIGH) and was calibrated accordingly to not be too sensitive.

#### Thoughts on Arduino IDE and implementing
Next up was the implementation of the Wemos. Having only worked with the pre-flashed Wemos during the lectures, it required a lot of googling and troubleshooting to write actual C++ code in the Arduino IDE to connect the Wemos to the network, to read the sensors, to publish their read values via MQTT and to subscribe to a MQTT topic. With the help of Lorenz however, we managed to get a working watering system.
All in all I learned the most during this process. Finally, it became clearer how the IoTFramework might work and how I would be able to install my own Home and Building Automation aspects at home.

#### Thoughts/Opinion
The video was a lot of teamwork. Figuring out a sort of "script" what to do and how to tell a story proved to be difficult at first, but as soon as the first scenario was filmed the ideas kept flowing and we improvised a lot. The end result turned out the way it is thanks to Manuel who did the whole processing of the raw materials into a finished video product.