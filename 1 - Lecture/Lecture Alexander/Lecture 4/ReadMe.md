# Lecture 4

## S1810455024, Alexander Stelzhammer

### Presentation: BacNET, LonWorks, ModBus
- More research has to be done:
  - Look up if there is a discovery protocol for ModBus

This question is answered by [Iris](../../Lecture%20Iris/Lecture%204/ReadMe.md#Discovery).

### Presentations of the others teams

#### Zigbee, Zwave, X10, DMX
##### Zigbee
- mesh topology (star, tree or net)
- wireless communication protocol with focus on machine to machine communication
- operating in same or overlapping areas of networks (internet) which can interfer (according to Ulno)
- end-devices only communicate with their parent nodes
- scalable, not breaking if removing/adding nodes dynamically
- no single point of failure
- self-healing
- domain:
    - home
    - building
    - industrial
    - retail
    - health
- usage:
    - smart metering
    - smart grid monitoring
- devices using/supporting:
    - Amazon Echo Plus
    - Philips Hue
    - Nuki Smart Locks

##### Z-Wave
- less expensive than Zigbee
- focus on home automation
- independent of central hub
- simple setup
- low latency
- 100 kBit/s
- range: up to 150 m
- domain: home automation


##### X10
- simple communication protocol
- devices very cheap
- low throughput
- latency: 1/2 to 3/4 second to receive responder
- interferences in power circuit can cause problems for further distances
- mostly used in US


##### DMX
- used for light control, fog machines, dimmers, christmas light
- digital communication, RS-485 for physical layer
- shielded twisted pair
- asynchronous serial data

#### SPI, I2C, Onewire, RS-232/RS-422/485
- full-duplex synchronous data bus
- clock, data and select lines
- data transmission between microcontrollers and small peripherals
- very high binary rate
- 3 types of signal:
    1. MOSI
    2. MISO
    3. SS
- virtual ring topology
- communication on different protocols:
    - USB
    - Ethernet
    - ...

##### I²C (Inter-Integrated Circuit Bus)
- only two wires:
    1. SDA: data transmission
    2. SCL: clock
- limited to about 10 meters
- bus speed determined by slowest node on bus
- allows multi master
- can have 127 slaves to one master because of address space
- typically much slower than SPI
- slave can keep clock low if he needs more time to process
- one of the easiest bus systems to set up
- used between microcontrollers
- simple and low cost
- discovery possible? (what devices are on I²C bus?) 
    - yes (a little), because they have addresses
    - some addresses are reserved for specific devices

##### OneWire
- one data line + ground reference for communication
- parasitically powered
- slaves have unique ID from manufacturer
- up to 300 meters
- up to 75 devices on one bus
- rather slow
- very simple!

##### RS-232
- = serial port
- was used widely to connect f.e. modems to other devices
- straight or twisted pair cable
- 15-30 m distance (theoretical limit: 300 m)


##### RS-485
- three state logic
    - individual transmitters can be deactivated
    - linear bus topology
    - two wires
- Master - Slave
- three signals
    - sending
    - receiving
    - on/off
- applications
    - programmable logic controllers
    - factory floows
    - physicl layer in many automation protocols (Modbus, Profibus)
    - lighting controllers in theaters

#### KNX-bus/ Ebus, Canbus
##### KNX
- separate power supply and device control into two separate networks
- devices made by different manufacturers
- devices just plugged in (= actors)
- sends plain text data

##### Ebus
- control heating & solar components
- European standard, mostly developed and used by German companies
- can provide power to participants
- 2 wires, twisted pair
- fixed data rate: 2400 baud -> very slow!
- start and stop bits


##### CAN Bus
- mainly used in car industry
- CAN Bus Low: very cheap, not so secure, slower
- CAN Bus High: more expensive, securer, faster
- supports different bus structures, but normally normal bus used
- dominant and recessive state, have also priority


### Exercise: KNX
I completed the KNX tutorial and got the KNX-Certificate. It can be found [here](./KNX_Certification_Stelzhammer.pdf).

### Exercise: Philips Hue

![node_red_configuration]

```json
[
  {
    id: "1fa4f766.3edea9",
    type: "tab",
    label: "Exercise: HueMagic",
    disabled: false,
    info: ""
  },
  {
    id: "f8d78b38.000728",
    type: "hue-light",
    z: "1fa4f766.3edea9",
    name: "Left Boy, White B.",
    bridge: "e765024c.21e87",
    lightid: "1",
    colornamer: true,
    x: 690,
    y: 280,
    wires: [[]]
  },
  {
    id: "bf372fe1.0f473",
    type: "ui_switch",
    z: "1fa4f766.3edea9",
    name: "",
    label: "Turn Light On/Off",
    tooltip: "",
    group: "26c96747.7fadf8",
    order: 7,
    width: 0,
    height: 0,
    passthru: true,
    decouple: "false",
    topic: "",
    style: "",
    onvalue: "true",
    onvalueType: "bool",
    onicon: "",
    oncolor: "",
    offvalue: "false",
    offvalueType: "bool",
    officon: "",
    offcolor: "",
    x: 150,
    y: 280,
    wires: [["17aa9245.a7b02e", "f8d78b38.000728"]]
  },
  {
    id: "17aa9245.a7b02e",
    type: "hue-light",
    z: "1fa4f766.3edea9",
    name: "Right Boy, Color B.",
    bridge: "e765024c.21e87",
    lightid: "7",
    colornamer: true,
    x: 690,
    y: 440,
    wires: [[]]
  },
  {
    id: "9669e853.d2edb8",
    type: "ui_slider",
    z: "1fa4f766.3edea9",
    name: "",
    label: "Adjust Brightness",
    tooltip: "",
    group: "26c96747.7fadf8",
    order: 8,
    width: 0,
    height: 0,
    passthru: false,
    outs: "end",
    topic: "",
    min: 0,
    max: "100",
    step: 1,
    x: 150,
    y: 360,
    wires: [["e65549e5.43c018"]]
  },
  {
    id: "e65549e5.43c018",
    type: "function",
    z: "1fa4f766.3edea9",
    name: "Package Brightness",
    func: 'msg.payload = {\n  "brightness": msg.payload  \n};\nreturn msg;',
    outputs: 1,
    noerr: 0,
    x: 440,
    y: 360,
    wires: [["17aa9245.a7b02e", "f8d78b38.000728"]]
  },
  {
    id: "2df627f8.397188",
    type: "ui_colour_picker",
    z: "1fa4f766.3edea9",
    name: "",
    label: "Adjust Color",
    group: "26c96747.7fadf8",
    format: "hex",
    outformat: "object",
    showSwatch: true,
    showPicker: false,
    showValue: false,
    showHue: false,
    showAlpha: false,
    showLightness: true,
    dynOutput: "false",
    order: 9,
    width: 0,
    height: 0,
    passthru: true,
    topic: "",
    x: 130,
    y: 440,
    wires: [["1eede0c7.7c212f"]]
  },
  {
    id: "1eede0c7.7c212f",
    type: "function",
    z: "1fa4f766.3edea9",
    name: "Package Color",
    func: 'msg.payload = {\n  "hex": msg.payload  \n};\nreturn msg;',
    outputs: 1,
    noerr: 0,
    x: 420,
    y: 440,
    wires: [["17aa9245.a7b02e"]]
  },
  {
    id: "e765024c.21e87",
    type: "hue-bridge",
    z: "",
    name: "Philips Hue Bridge",
    bridge: "192.168.12.155",
    key: "PceFQFQ6cgWvCJ7QwDoubBegPApRbBX6rxp6mxzz",
    interval: "3000"
  },
  {
    id: "26c96747.7fadf8",
    type: "ui_group",
    z: "",
    name: "Example",
    tab: "1561a345.e0333d",
    order: 1,
    disp: true,
    width: "6",
    collapse: false
  },
  {
    id: "1561a345.e0333d",
    type: "ui_tab",
    z: "",
    name: "Example",
    icon: "dashboard",
    order: 2
  }
];
```

![user_interface]

[node_red_configuration]: ./Exercise%20-%20Philips%20Hue%20and%20NodeRED/NodeRED_Configuration.PNG
[user_interface]: ./Exercise%20-%20Philips%20Hue%20and%20NodeRED/NodeRED_UI.PNG


### Thoughts/Opinion
The presentations were very boring. There were too many protocols and it was hard to distinguish what exactly is state of the art right now. Also, it was rather difficult to find answers to the questions provided by Ulno. 

The KNX exercise was pretty bad as well. There were no clear instructions on what to do or even how to get started. Despite having completed the KNX tutorial, we were not able to even connect to the KNX system. After 30 minutes of frustration, we decided to get help from Ulno who then helped us get started.
Additionally, we did not know what KNX software to download and there were even problems installing it on our laptop. There was so much other work (besides KNX) to do that we did not have enough time to actually play around with KNX. We did the bare minimum because otherwise there would not have been time for the other assignments (e.g. RFID Smart Lock).