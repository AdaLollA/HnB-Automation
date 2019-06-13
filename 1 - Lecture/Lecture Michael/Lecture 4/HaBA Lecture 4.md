### HaBA Lecture 4

##### Author: Michael Breiteneder

##### Presentations

* Team 1 (my team)
  * BACNet
  * LonWorks
  * Modbus
* Team 2
  - SPI
    - no maximum device restriction
    - millions of bytes per second transmission possible
    - most run on 3.3V
  - I2C
    - allows different voltage levels
    - Special signal combination for start and stop
    - slave can lower data rate
    - is low-active > 1 is no volate
  - 1-Wire
    - devices get energy from bus
    - different voltage levels
    - Slaves show existence "pulse"
  - RS232
    - uses start and stop bit to synchronize
    - only 2 devices can be connected > connected devices are local
  - RS422
    - one sender, multipe receivers
    - uses a shared bus for more receivers
  - RS485
    - more devices can transmit data (three state logic)
    - up to 10Mbit binary rate
  - Question
    - how does SPI detect how fast it can transmit data if slower devices are present? does the master or slave(s) set the speed?

- Team 2
  - Zigbee
    - uses same frequency as WiFi
    - no central controller
    - many smart device families/manufacturers support it
  - ZWAVE
    - Low-energy radio waves with bigger range than Bluetooth
    - extremely safe > 128-bit security
  - X10
    - connection over power line?
    - power circuit interference can cause problems
  - DMX
    - no automatic error checking and correction
    - less home automation, more stages and music applications
  - Question
    - Does Zigbee use the same channels as WiFi? Do they interfere as heavy as WiFi networks, as they use the same frequency?
- Team 3
  - KNX
    - Separates power supply and device control 
    - 3 different modes
  - Ebus
    - only master can initiate communication
    - 256*2 communication operations
    - used for heating infrastructure
  - Canbus
    - automotive industry
    - messages have IDs and priority
  - Question
    - ?

##### KNX Training

[online course](http://wbt5.knx.org/)

Solved online course during class

[Certificate]()

##### Lab Work

Wired the smart lock and RFID chip again. Adopted the Wemos nodes in the IoT framework. The rest of the team worked on the Node-red and webhook implementation, so the smart lock can be unlocked from a smart phone.

[link to documentation]()

##### Conclusion

