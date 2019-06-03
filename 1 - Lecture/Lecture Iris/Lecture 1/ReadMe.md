# Lecture 1
## Self Presentation
### Who are you?
- Iris Pöchtrager, 23 years old
- Studied Software Engineering in the Bachelor, now Mobile Computing
- Working at softaware in Asten

### What do I expect from H&B Automation?
I expect to learn how I can automate a few thing myself at home - f.e. lights, and other things. I expect to get a kickstart in this area to be easily able to deepen the knowledge later if I want to.

### If I were in a team with 4 persons, I would bring to the table:
#### Strengths
- Punctuality
- Perfectionism
- Accuracy

#### Weaknesses
- Sometimes not a lot of time & a little stressed
- Impatient
- Perfectionism


## Videos
### Big Bang Theorie
- Turning on light
- Turning on stereo
- Racing cars
- Public access to turning on/off things
- Sending signal over internet
- Very feasible - done today

### Siemens Video
- Very fast elevators - increase efficiency
- Increase comfort, security, safety
- Using Holograms to interact with
- Not yet feasible - maybe with AR
- Siemens video 
- Exchange blocks of a building (use as elevator??!) - not feasible
- Intelligent energy management system -> mix in from public system
- Consumption optimization - integrate in building management system
- Guide people through buildings with signals on their phone
- Safe evacuation with system - emergency mode, with lights and sounds
- Separate people when safe rooms are full
- Networking city districts

### Bosch Videos
- Mow the lawn like a bosch: let all lawn mowers go at same time
- Park like a bosch video: automated parking
- Wake up like a bsoch: automatic coffee brewing

### Domains:
- Security Domain
- Energy Management
- Navigation and Routing
- Home Automation
- Resource Management
- Privacy (mentioned negatively)

### Technologies:
- Machine to machine communication (lawn mowers)
- Lights
- Wireless Communication
- Virtual Reality
- Remote Control/External Access
- Cloud
- Synthesis/Integration

### Crazy/Weird:
- Lack of privacy (Cars)
- Remote Access (Cars)
- Building with block came out to be used as an elevator


### Feasibility:
- Holograms possible to do (with AR/VR)
- Lots of things in Bosch videos feasible!

## Internet of Things
### Domains
- Logistics
- Health
- Home automatism
- Machine to Machine communication

### Main problems
The IoT exposes things to the network, but there are still issues/problems with doing this in a [controlled way](https://ieeexplore.ieee.org/stamp/stamp.jsp?tp=&arnumber=7196499).

[Limitations due to hardware:](https://ieeexplore.ieee.org/stamp/stamp.jsp?tp=&arnumber=7196499)
- Computational and energy constraint: mostly battery driven devices - expensive algorithms cannot be ported directly to these devices
- Memory constraint: limited RAM and Flash memory
- Tamper resitent packaging: Might be deployed in remote regions and left unattended - attacker could tamper devices by device capture

[Limitations due to software:](https://ieeexplore.ieee.org/stamp/stamp.jsp?tp=&arnumber=7196499)
- Embedded software constraint: thin network protocol stacks - devices might lack enough security modules -> protocol stack should be thin but robust & fault tolerant
- Dynamic security patch: remote reprogrammng might not be possible for IoT devices - protocol stack might not have ability to receiving and integration new code/library

[Limitations due to network:](https://ieeexplore.ieee.org/stamp/stamp.jsp?tp=&arnumber=7196499)
- Mobility
- Scalability
- Multiplicity of devices
- Multiplicity of communication medium: devices connect via a range of wireless links - difficult to find a comprehensive security protocol
- Multi-Protocol Networking: devices might use proprietary network procotol for communication with proximal networks
- Dynamic network topology: devices might join or leave a network at anytime from anywhere

[IoT plaforms/frameworks:](https://www.sciencedirect.com/science/article/pii/S2214212617302934)
- AWS IoT from Amazon
- ARM Bed from ARM & other partners
- Azure IoT Suite from Microsoft
- Brillo/Weave from Google
- Calvin from Ericsson
- HomeKit from Apple
- Kura from Eclipse
- SmartThings from Samsung

[Frameworks role:](https://www.sciencedirect.com/science/article/pii/S2214212617302934)
- indentify structure which coordinates and controls processes are conducted by various IoT elements
- structure: set of rules, protocols and regulations
- organize way of processing data and exchange messages between involved parties
- should support high level implementation of IoT applications
- hide complexity of infrastructure protocols

[Gateways role:](https://ieeexplore.ieee.org/abstract/document/5703542)
- sensors have no uniform standardization
- settle with heterogenity between various sensor networks and mobile communication networks or internet
- bridge traditional communication networks with sensor networks -> easier network communication

## Hello World of IoT and H&B Automation
### Demo Notes
- not start Pi without shutting it down properly
- start up: see yellow LED blinking a lot
- should display as new network when started properly
- after flashing SD
    - open SD ("boot") 
    - can edit wifi-file: name of wifi
    - log into network shown on little screen
- go to: iotgateway.local - accept connection
- see webportal now - all documentation there
- today: first little tutorial
- go to example folder - file manager shown there
- there should be no key - key has to be generated on first time
- open User Menu with F2 - can then adopt devides

### Project notes
- wrong image at the beginning
- As we had one adapter that was very fast and one that was very slow, it was faster to use the first adapter for both teams of our group. Therefore only one of us (Lorenz) then downloaded the new image and flashed the SD Cards of both groups with the fast adapter.
- using Etcher for flashing the image onto the SD Card
- we did not decompress the image before flashing it

### Adoption Phase
- to get into adoption phase, press button twice while starting
- use the User Menu to search for node while node is still blinking
- **Encountered Problems:**
    1. The adoption did not manage to upload all the necessary files (Error Code: 10)!
        -> using wrong charger (not the standalone charger but rather a dock). this almost broke the Raspberry Pi because the charger does not provide enough power to the Pi because it uses a not good enough protocol
        -> connected too many dongles to the Pi which is always a bad thing to do. connect only as many dongles to the Pi as necessary! thus, we removed all dongles except one from the Pi.

    2. We accidentally deleted the node1 and node2 folder. We tried to abort the deletion of the folders, however it was already too late. We now have two options to fix the problem:
        1. First, we could use the web interface to fix the issue. However, by deleting the folder structure we could not access the menu.
        2. Second, as we could not access the menu in the web interface, we flashed a new SD card.

    3. Even with a fresh image we could not scan for adoptable nodes. We decided to reset the node. After resetting, we put it back into adoption mode. This did not work again.

    As we could not solve the above problems, we asked Ulli for help. He suggested trying it with his kit to find the source of the problem (or at least limit it to a certain area).






