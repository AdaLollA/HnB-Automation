# Challenge: RGB LED
## Alexander Stelzhammer, S1810455024

### Task
Using a color picker on a mobile phone the user should be able to manipulate a RGB LED lamp's color.

### Setup
#### Light Sensor Configuration 
First, the RGB LED needs to be configured. It uses the topic "rgb1" (resulting in a total topic of "node1/rgb1") to receive a MQTT-message.
The code can be seen below:
```c++
rgb_single(rgb1, D3, D2, D1, true);
```


#### Node-RED Setup
On node red, we send messages to the topic "node1/rgb1" to set the RGB LED's channels.
The configuration can be seen below:
![node_red_setup]

The exported JSON can be seen below:
```json
[
    {
        "id": "85b60300.bde1a",
        "type": "tab",
        "label": "Challenge: RGB LED",
        "disabled":false,
        "info": ""
    },
    {
        "id": "744b719f.95b6d",
        "type": "ui_colour_picker",
         "z": "85b60300.bde1a",
        "name": "",
        "label": "",
        "group": "26c96747.7fadf8",
        "format": "hex",
        "outformat": "string",
        "showSwatch":true,
        "showPicker":false,
        "showValue":false,
        "showHue":false,
        "showAlpha":false,
        "showLightness":true,
        "dynOutput": "true",
        "order":0,
        "width":0,
        "height":0,
        "passthru":true,
        "topic": "",
        "x":140,
        "y":100,
        "wires": [
            [
                "e2949f28.100688"
            ]
        ]
    },
    {
        "id": "40e247b9.9b0858",
        "type": "ui_switch",
        "z": "85b60300.bde1a",
        "name": "",
        "label": "switch",
        "tooltip": "",
        "group": "26c96747.7fadf8",
        "order":1,
        "width":0,
        "height":0,
        "passthru":true,
        "decouple": "false",
        "topic": "",
        "style": "",
        "onvalue": "on",
        "onvalueType": "str",
        "onicon": "",
        "oncolor": "",
        "offvalue": "off",
        "offvalueType": "str",
        "officon": "",
        "offcolor": "",
        "x":330,
        "y":180,
        "wires":[
            [
                "7fff471d.55056"
            ]
        ]
    },
    {
        "id": "e2949f28.100688",
        "type": "mqtt out",
        "z": "85b60300.bde1a",
        "name": "",
        "topic": "node2/rgb1/rgb/set",
        "qos": "",
        "retain": "",
        "broker": "77293117.a8a4b",
        "x":620,
        "y":120,
        "wires":[]
    },
    {
        "id": "7fff471d.55056",
        "type": "mqtt out",
        "z": "85b60300.bde1a",
        "name": "",
        "topic": "node2/rgb1/set",
        "qos": "",
        "retain": "",
        "broker": "77293117.a8a4b",
        "x":610,
        "y":200,
        "wires":[]
    },
    {
        "id": "26c96747.7fadf8",
        "type": "ui_group",
        "z": "",
        "name": "Example",
        "tab": "1561a345.e0333d",
        "order":1,
        "disp":true,
        "width": "6",
        "collapse":false
    },
    {
        "id": "77293117.a8a4b",
        "type": "mqtt-broker",
        "z": "",
        "broker": "localhost",
        "port": "1883",
        "clientid": "",
        "usetls":false,
        "compatmode":true,
        "keepalive": "60",
        "cleansession":true,
        "birthTopic": "",
        "birthQos": "0",
        "birthPayload": "",
        "willTopic": "",
        "willQos": "0",
        "willPayload": ""
    },
    {
        "id": "1561a345.e0333d",
        "type": "ui_tab",
        "z": "",
        "name": "Example",
        "icon": "dashboard",
        "order":2
    }
]
```

[node_red_setup]: ./Challenge_RGB_LED_NodeRED.PNG