# Lecture 4

## S1810455024, Alexander Stelzhammer

### Presentation: BacNET, LonWorks, ModBus

- More research has to be done:
  - Compare KNX and BacNET
  - Look up if there is a discovery protocol for ModBus

### Presentations of the others teams

#### Zigbee, Zwave, X10, DMX

- ...

#### SPI, I2C, Onewire, rs-232/rs-422/485

- ...

#### KNX-bus/ Ebus, Canbus

- ...

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