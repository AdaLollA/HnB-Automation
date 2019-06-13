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

## Scenario 3 - Auomatic air dampening

## Scenario 4 - Garden Watering