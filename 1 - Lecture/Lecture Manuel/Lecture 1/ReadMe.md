# Lecture 1
## S1810455012, Manuel Leibetseder


# Movie Takeaways 

- big bang
	- home automation
	- M2M communication

- siemens
	- security
	- flexibility
	- max efficiency
	- comfort
	- wellbeing for users
	- synergy between saftey, security, comfort
	- adaptable, sensitive, connected systems
	- easy change in needs 
	- standardized interfaces
	- flexible usage
	- optimized usage
	- dynamic route management
	- intelligent networking
	- intelligent energy management systems
	- new energy storage concepts
	- consumption consumization
	- lighting and climate control
	- discrete access controls
	- discrete navigation through buildings
	- lighting installations
	- different supporting solutions
	- realtime information exchange
	
- bosch
	- coffee machine automation
	- door
	- clean
	- mow the lawn
	- IoT
	- stock check
	- automatied parking

# Discussion

- light and entertainment

- Domains and Topics
	- Energy Informatic Systems
	- Navigation and Routing
	- Machine to machine interaction
	- Security Automation
	
- Technologies
	- M2M interaction
	- lights
	- wireless communication
	- smart grids
	- resource management
	- virtual/augmented reality
	- wired communication
	- remote control
	- external access
	- control flow modeling
	- integration/synthesis
	

### what might be doable?
### what not?
### when?
 
### Weird stuff
- lack of privacy
- remote access
- room exchange

## Where is the killer app?
- no killer app there
- all big vendors good at integrating
- e.g.
	- google home
	- homekit
	- alexa

***

# Building a smart lock documentation

Two resources were needed to get started with building something with the raspberry pi and ulno iotempower:

- [Github](https://github.com/iotempire/iotempower)
- [Etcher](https://etcher.io)

## Getting started with Raspberry Pi and iOTempower

- downloading [Arduino Studio](https://www.arduino.cc/download_handler.php)
- [Downloading Image](https://github.com/iotempire/iotempower)
- Install [Etcher](https://etcher.io)
- Flash SD Card with Etcher

### Notes from Ulno Demonstration
- plug in screen to pi
- switch on an led on wemos when tapping button on another wemos
- dongle = screen
- raspberry pi is used as a gateway
- changing password (help teammember iris and alex)
- plugging in pi to determine wifi network

**DOWNLOAD OF THE IMAGE WAS CORRUPT**

- we need to start over again
- downloading backup image from 10.20.99.155:8000 (ulno pc)

- flashing again

***

# Adoption phase
- morsing code = setup phase
- start user menu
- yeyeboys (dj-bobo-fanclub)
- iot: iotempire
- iotgateway.local
- Adoption steps:
	- plug in wemos
	- press button twice
	- select from menu on iotgateway 

- using the the display wemos for checking and adopting the other wemos
- we deleted all node files, so we have to use another raspberry pi image to start over again

# Personal Opinion // Lesson Learnt
The reason nothing was working was because of a software update. Something was added to the wemos and therefore the node update wasn't able to take place.

Overall it was a good introduction, but lacking in pratical examples - because of the failure of the update we weren't able to do anything for about 2hrs and maybe need to catch that up on our next session.