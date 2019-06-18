# Project Setup
## General
We used Openhab on one of the Raspberries as interface.
    1. flash Openhab image onto the Raspberry SD
    ...

## Scenario 1 - Smart Lock
1. connect a lock to a relais
2. connect relais to a Wemos Node adopted by one of our Raspberries
3. connect the RFID reader to another Wemos Node
4. configure setup.cpp in iotgateway:
    ```
    relais(lock, D3, "on", "off");
    ```
5. add the lock in OpenHab
    1. Setup a MQTT Broker
        - add MQTT Binding
        - in inbox, select add by MQTT Binding
        - select MQTT Broker
        - set IP Address of Raspberry in the MQTT Broker
    2. Setup a Generic MQTT Thing
        - select the MQTT broker as broker
        - after setting up, add a channel
        - select text value
        - set topic command topic to node#/lock/set
        - set on/off to the lock in the control panel
        - lock can be opened/locked via openhab

## Scenario 2 - Adapt light according to natural light
1. connect the light sensor to a Wemos Node
2. setup Hue Lamp
3. add light sensor in OpenHab
    1. add channel to the Generic MQTT Thing created in the Smart Lock
    2. set MQTT topic to node#/photo
    3. sensor value is shown in control panel
4. add Hue lamp to OpenHab
    1. Use Hue Binding to add Hue
    2. Hue brightness is editable in control panel
5. type "\\ip-address" in the explorer (the IP-Adress of the Raspberry where Openhabian is installed has to be used) - the Openhabian folder can be seen now
6. open the configuration folder
7. add item "Light" and "Hue_Light" to ["haba.items"](./openhab_files/haba.items) in the items folder
8. add rule "Natural Light" to ["haba.rules"](./openhab_files/haba.rules) in the rules folder
    - the rule uses the sensed light intensity and adapt Hue brightness accordingly

## Scenario 3 - Auomatic air dampening
1. connect the humidity sensor to a Wemos Node
2. plug Z-Wave controller in on the Raspberry where Openhabian is installed
3. add humidity sensor in OpenHab
    1. add channel to the Generic MQTT Thing created in the Smart Lock
    2. set MQTT topic to node#/temperature/humidity
    3. sensor value is shown in control panel
4. add Plug to OpenHab
    1. Use the Z-Wave Binding to add a Z-Wave Controller (security: none)
    2. Use Z-Wave Binding to find Z-Wave Node
    3. Add Z-Wave Node
    4. Plug can be switched on or off in control panel
5. type "\\ip-address" in the explorer (the IP-Adress of the Raspberry where Openhabian is installed has to be used) - the Openhabian folder can be seen now
6. open the configuration folder
7. add item "Plug" and "Humidity" to ["haba.items"](./openhab_files/haba.items) in the items folder
8. add rule "Air Dampener" to ["haba.rules"](./openhab_files/haba.rules) in the rules folder
    - the rule uses the sensed humidity
    - if the humidity is below a certain value, the plug is turned on
    - if not, the plug is turned off

## Scenario 4 - Fire Alarm
When a fire sensor gets a below a certain value, a fire alarm shall be made visible by turning a Hue Lamp on and red.
1. connect fire sensor to a Wemos Node
2. setup Hue Lamp
3. add fire sensor in OpenHab
    1. add channel to the Generic MQTT Thing created in the Smart Lock
    2. set MQTT topic to node#/fire
    3. sensor value is shown in control panel
4. add Hue lamp to OpenHab
    1. Use Hue Binding to add Hue
    2. Hue brightness and color is editable in control panel
5. type "\\ip-address" in the explorer (the IP-Adress of the Raspberry where Openhabian is installed has to be used) - the Openhabian folder can be seen now
6. open the configuration folder
7. add item "Fire" and "Hue_Color" to ["haba.items"](./openhab_files/haba.items) in the items folder
8. add rule "Fire Alarm" to ["haba.rules"](./openhab_files/haba.rules) in the rules folder
    - the rule uses the sensed fire intensity
    - if the intensity is below a certain value, the lamp is turned on and a HSB value is sent to the lamp
        - turns brightness to 100%
        - turns light red
    - if no, the lamp is turned off

## Scenario 5 - Garden Watering