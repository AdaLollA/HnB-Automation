### HaBA Lecture 2

##### Author: Michael Breiteneder

##### Content

Assigned to random project group with open seat.

Since I missed the previous lecture I was trying to catch up to the current status of my project group.

Introduction to IoT Empower, which I guess is a successor of the previously known ulno-iot.

IoT Empower now features a web interface with terminal and node-red interface. It runs on the Raspberry Pi which can be connected to with a local WiFi. Also there is a Wemos dongle connected to the Pi which allows communication on a separate connection with the other Wemos chips.

Current setup is one dongle and 2 nodes. Only the dongle needs to be connected to the Pi. Nodes need to be adopted via the IoT framework. For that, they need to be set in config mode by pressing the reset button on the Wemos chip and connecting Ground and D3 pin two times shortly after restarting.

After adoption, the current configuration can be deployed onto the Wemos again over the IoT framework.

There are a lot of update/upgrade options that are necessary for the framework to function properly, see explanations in Discord channel.

The local node-red installation works with the mqtt data provided by the Wemos nodes.

##### Lab Work

I did some wiring work, connecting the sensors like button to the Wemos, since the rest of the group was already working on the IoT framework configurations.

Wiring of the smart lock as well as the led panels.