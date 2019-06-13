# Lecture 4
## S1810455012, Manuel Leibetseder

(cross-checked with teammates due to meeting during presentations)

### Busses and protocol presentations

- note 2 most important things 
- one question/team that could be asked

For reference, here are all presentations of that day:

- [SPI, I2C, OneWire, Rs-232, RS422, RS485](SPI_I2C_Onewire_RS-232_RS-422_RS-485.pdf)
- [KNX, Ebus, Canbus](presentation_KNX_Ebus_Canbus.pdf)
- [BacNet, LonWorks, ModBus](Bus__Protocol_Research.pdf)

### Research Department Meeting
As I was not present during the presentations, I am referring to my teammates notes on the presentations.

- Iris
- Lorenz
- Micheal

***

#### Ebus

- heating & infrastructure components
- EU standard
- 25 masters/228 slaves

##### Physical Layer
- Master/Slave communication
- 254 primary and 254 secondary commannds

##### Package Structure
- master can initiate communication

##### Data-Link Layer
- master request
- slave response
- master ACK
- master SYN
- master/slave Success message

##### Application Layer
- generic protocols
- expansion packs


***

#### CanBus

- wiring
- automotive industry
- two different standards
- diagnostice interface (purpose)
- support different bus structures
- message orientated
- multi master
- highest priority wins

#### Bus Node
- u-Controller
- CAN-Controller
- CAN-Transeiver

#### Can High
- Transmits data
- normally used for safety- time critical stuff
- two cables different signals

#### Can Low
- confort domain
- simple actors (switches/nobs)

***
***

### Challenges
We got new challenges and needed to complete them. First of all there was a KNX online class to take so we learn the ground rules of ETS5 program to work with KNX.

#### KNX Class



### Personal Opinion // Lesson Learnt

I found it quite interesting to research about the history of older IoT and automation technology, but in my opinion the presentations were a bit too long. 15 minutes/presentation should have been enough to catch up with the hard facts.


