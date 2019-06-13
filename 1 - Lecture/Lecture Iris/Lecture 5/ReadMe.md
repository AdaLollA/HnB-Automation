# Lecture 5
## Project 2 Presentation
### Group 1
We presented as Group 1

### Group 2
- goal: home automation < 20.000 €
- automatic garage
- NFC Chip in right hand to open door
- pool opens automatically
- mutliple cleaning robots & lawn mowers
- pool regulates heat&cooling itself
- home entertainment system
- smart security cameras
- lots of DIY (Wemos, Raspberries, ...)
- presentation was very nice - well thought-through

Are the costs for implementing the NFC Chip into the hand also calculated?

### Group 3
- family with several people
- very nice user story!
- smart pool
- Alexa
- smart washing machine
- set time for gaming by home automation - enforced by parents
- Toilet paper recorder (flic smart buttons)

Why not using Philips Hue but another system? -> Asked by Manuel

### Group 4
- Scenario guy very environment friendly
- using Loxone a lot
- invested a lot of thoughts in power redundancy and how much energy would be used by all the devices
- detect whether windows are open or closed
- close shutters automatically when room gets too hot
- context aware lighting
- team went a little bit crazy with all the Loxone things
- nice visualization of where f.e. speakers in the buidings are at the end of the presentation

Why did you choose to get all your devices from Loxone? Seems extremely expensive?

### OpenHab experiments
#### Philips Hue
1. Install OpenHab (start with start.bat, then open localhost:8080)
2. Open Paper UI
3. Add Hue Binding in Bindings
4. Got to Inbox -> +
    - Select Hue
    - OpenHab searches for Hue
    - Hue is found -> add as item
    - in inbox: add every Hue found as item
5. Go to Control
    - Both Hues can be turned off/on and the light changed here

#### Temperature and humidity sensor
We also tried a temperature and a humidity sensor.
1. Connect the temperature and the humidity sensor to a Wemos connected to a Raspberry
2. In setup.cpp we set the following:
    ```
    \\ add missing code
    ```
3. In OpenHab we had to set up a MQTT Broker
    1. Install the MQTT Binding in the Add-Ons
    2. Got to Inbox, select MQTT Binding
    3. Select MQTT Broker
    4. Set IP-Adress, username and password
4. Set up the MQTT Things
    1. Got to Inbox, select Generic MQTT Thing
    2. The broker is already selected
    3. Add a channel
        1. Set the channel
        2. Set an ID
        3. You can set a label to give the channel a name (f.e. "Temperature")
        4. Set the MQTT state topic (f.e. "node2/temperature/temperature")
            - the state topic could be empty if the channel should be write-only
            - the command topic can be empty if the channel is read-only
5. The MQTT Things are then visible in the control panel again

