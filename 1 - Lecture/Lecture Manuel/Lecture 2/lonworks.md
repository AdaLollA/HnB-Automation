## Project 2

- Automate Friends home
- shopping list
- things you buy
- how expensive
- work packages
- estimated execution time
- scenario needs to justify why buy this stuff
- link sources


- every solution is fine (expensive or cheap)
- kanban (task management; packages)

### Story
- first we need to develop a story to justify our expenses
- writing scenario
- wednesday we need to present this stuff



## Theory 
Bacnet, Lonworks, Modbus:

- functionality, 
- effort to use/implement, 
- speed, 
- throughput, 
- latency, 
- length, 
- flexibility, 
- importance, 
- usage example, 
- domain


## Lonworks 
- local operating network
- address needs of control application 
- created by Echelon Corporation/Motorola
- 2010 90mio devices installed with LonWorks technology
- industries: building, home, street lightning, transportation, utility, industrial automation

- use IP to connect hardware to monitoring systems
- designed for low bandwidth

- functionality:
	- embedded machine control
	- municipal and highway/tunnel/street lighting
	- heating and air conditioning systems
	- intelligent electricity metering
	- subway train control
	- building lighting
	- stadium lighting
	- speaker control
	- security systems
	- fire detection and suppression
	- newborn location monitoring/alarming
	- remote power generation load control

- working with standards provided by LonWorks (SNVT)
- e.g. thermostat temp SVNT produce no of 0-65535 --> -274 - 6279.5 degrees celsius

- for networking devices
- over media like twisted pair, powerlines, fiber optics 
- used for automation of functions within buildings (e.g. lighting)


### Resources
- https://www.setra.com/blog/what-is-the-difference-between-bacnet-modbus-and-lonworks
- https://en.wikipedia.org/wiki/LonWorks
- http://www.circon.com/wp-content/uploads/2011/03/LonWorks-Fundamentals.pdf
- https://www.ecmweb.com/content/basics-lonworks
- https://www.rtautomation.com/technologies/lonworks/

### advantages
- Web based tool; saves time and cost
- Numerous developers of Lonworks products in the market
- Less Architecture at device level

### disadvantages
- Outdated
- Controlled devices & variables are connected to a separate control device. (Not recommended due to network interruptions producing system failures)
- Extensions are allowed only through the LonMark Consortium.
- Hardware specific, and requires the - Neuron chip for network movement of the protocol.
- Close to “plug & play” ability, yet still far from achieving interconnectivity using Microsoft Windows.

### Usage
- no hardware
- just software/firmware
- four elements
	- Lontalk protocol
	- Neuron chips
	- Lonwork transceivers
	- network management and application software

- LonTalk:
	- supports fastest data rate of 1,25million bits/second
	- supports more than 500 transaction per second
	- optional priority feature
	
- Neuron Chip:
	- node program writes new value into output
	- new value is propagated across network
	- all nodes with input network connected to that output receive the output

- Transceivers include:
	- 78kbps twisted pair transreceiver
	- 1.25mbps twisted pair transceiver    
	- power line transceiver
	- radio frequency transceiver

- Networking management and application tool
	- LonMaker Integration Tool
	- MS Visio graphic Interface
	- installing a node
	- specify which cable connected
	- SVNT must be the same (standard)

### Implementation on ESP8266 based Wemos D1 Mini
The core of the concept are the three 8 bit processors that are refered to as the Neuron Chip. They are responsible for the following utilities:

 - Media Access
 - Network
 - Application

Since we are working on a single 32 bit processor on the Wemos D1 Mini we are not capable of implementing this concept without additional hardware. If we really wanted to we could aquire these resources from the [echelon store](https://www.echelon.com/products/category/chips). The required chip is called **Neuron XXXX Processor**.