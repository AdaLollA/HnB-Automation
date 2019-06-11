# Lecture 3
## S1810455024, Alexander Stelzhammer

### Research: ModBus
#### [Functionality](https://www.schneider-electric.com/en/faqs/FA168406/)
- enables communication among many devices connected to the same network
- serial communications protocol
- transmit information over serial lines between electronic devices
- device requesting information: Modbus Master
- devices supplying information: Modbus Slaves
- Simples setup:
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
- with high-performance intranet with high-speed Ethernet switches guaranteeing performance - in theory up to 60% efficiency when transferring registers in buld
- [typical transmission speed](https://www.schneider-electric.com/en/faqs/FA168406/): 9600 baud (bits per second)
- generally rather slow

#### [Throughput](http://www.modbus.org/faq.php)
- 10BaseT Ethernet carries about 1.25 Mbps raw
- Theorectical throughput is: 1.25/2 * 60% = 360.000 registers per second
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


### Exercise: RFID Lock

We divided the tasks for the RFID lock to work in parallel. 