# Lecture 3
## Debate
I was moderator in the debate. The things I still remember that the debaters talked about are the following:
1. A lot of worries concerning children/education were raised. Points mentioned were:
    - People are gonnna loose a lot of abilities, if they don't have to do anything manually anymore
    - Children won't need to learn anything anymore, intellectual resources are wasted through the use of IoT
    - Children won't be able to explore things anymore (example of kid having to find capital and then using f.e. the globe for it)
2. Security issues were also mentioned. Points mentioned in this area:
    - There has been a study where an institute proved a statistic that 25% of the home IoT can be hacked in very short time
    - If you do not use your WiFi but a separate network (not on Cloud) IoT is secure
    - Integrating such a system would come with some costs for average people though as they are not very familiar with f.e. network structures
3. Helping disabled persons with IoT. Points mentioned:
    - If a person is sitting in a wheelchair, the person can do things by voice that he/she can't otherwise
4. Some talk was also about increasing comfort and productivity of person with IoT.

## Project 2 Notes
- Who lives in this house (requirements usw)
- How are they related to me
- How many persons are we/What do we do (are we hackers, ...)

## Bus & Protocol Research
### ModBus
#### [Functionality](https://www.schneider-electric.com/en/faqs/FA168406/)
- enables communication among many devices connected to the same network
- serial communications protocol
- transmit information over serial lines between electronic devices
- device requesting information: Modbus Master
- devices supplying information: Modbus Slaves
- Simplest setup:
    - single serial cable
    - connecting serial ports on two devices: Master and Slave
    - data is sent as series of bits
    - bits are sent as a voltages (0 = positive, 1 = negative)
    - typical transmission speed: 9600 baud (bits per second)
- Bits are combined and shown in hexadecimal (block of 4 bits = one of sixteen characters)
- Data storing in Standard Modbus
    - four different tables
    - two tables: on/off discrete values (coils)
    - two tables: store numerical values (registers)
    - Coil/Register Nubmers can be thought of as location names (do not appear in actual messages - data addresses are used in messages)
- CRC is added at end of every modbus message for error detection

#### [Effort to use/implement](https://www.setra.com/blog/what-is-the-difference-between-bacnet-modbus-and-lonworks)
- no costs to use - no charge for usage or licensing fees
- lot of amount of configuration and programming required
- easy to deploy and maintain

#### [Speed](http://www.modbus.org/faq.php)
- if running Modbus TCP/IP over Internet - no better than typical internet response times
- with high-performance intranet with high-speed Ethernet switches guaranteeing performance - in theory up to 60% efficiency when transferring registers in bulk
- [typical transmission speed](https://www.schneider-electric.com/en/faqs/FA168406/): 9600 baud (bits per second)
- generally rather slow

#### [Throughput](http://www.modbus.org/faq.php)
- 10BaseT Ethernet carries about 1.25 Mbps raw
- Theorectical throughput is: 1.25/2 * 60% = 360.000 registers per second when transferring registers in bulk
- 100BaseT speed is 10 times greater

#### [Latency](https://en.wikipedia.org/wiki/Modbus)
- high latency

#### [Length]((http://www.modbus.org/faq.php))
- Modbus uses Ethernet and the TCP/IP protocol. Theoretically, there is no limit to the length, as it can also communicate via internet.

#### [Flexibility]((http://www.modbus.org/faq.php))
- interoperability among different vendors' devices
- compatibility with a large installed base of Modbus-compatible devices 
- not industry specific
- uses standards like Ethernet and TCP/IP
- vendor-independent
 
#### [Importance](http://www.modbus.org/faq.php)
 - used to exchange information between devices, monitor, and program them. 
 - also used to manage distributed I/Os
    => making it the preferred protocol by the manufacturers of this type of devices
- simple
- low-cost development
- minimum hardware required

#### [Domain](http://www.modbus.org/faq.php)
- industrial electronic devices: transmit signals from instrumentation and control devices back to a main controller or data gathering system
- in multiple master-slave applications to monitor and program devices
- to communicate between intelligent devices and sensors and instruments
- to monitor field devices using PCs and HMIs

#### [Usage Example](https://www.setra.com/blog/what-is-the-difference-between-bacnet-modbus-and-lonworks)
- a system that measures temperature and humidity communicates the results to a computer
- send status alarm 
- fan schedule

#### Research to questions asked during presentation
**Serial vs. TCP/IP**
Two main types of Modbus:
- Modbus RTU = serial protocol
- Modbux TCP = working with TCP/IP

**Discovery**
[Not really a way to detect nodes](https://control.com/thread/1306158603#1306158603)
- very small resources needed to create nodes
- work has to be done manually (typing in codes, ...)

## RFID Project
In the RFID Project we split the work to get it done. The first steps to do were:
1. update the Raspberry Pi with the new image
    - this didn't work with the command over the user menu, because the command was wrong
    - did it over command line then ("iot upgrade")
    - I also started a Pull Request onto the library to fix the issue
2. adopt the Nodes again (somehow they were not recognized again on this day)
3. write the [ticket simulator](../../MQTT%20Ticket%20Simulator) in Java
    - simulates expiring tickets
    - holds references to the RFID cards and the phones belonging to the RFID cards
    - verifies that which person sent which token
4. setup the hardware
    - Smart Lock is connected to the RFID Reader
    - Lock is connected to a Raspberry Pi
    - When the RFID reader reads an RFID chip, a MQTT-message is sent to the Raspberry Pi
    - MQTT triggers a request to the ticket simulator which sends the authentication via a MQTT message

