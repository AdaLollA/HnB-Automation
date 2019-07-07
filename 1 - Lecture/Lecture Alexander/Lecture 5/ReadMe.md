# Lecture 5
## S1810455024, Alexander Stelzhammer

### Project 2: Presentations
#### Group 01
This was our group and we presented in the first time slot.

#### Group 02
- goal: home automation < 20.000 €
- automatic garage
- NFC chip in right hand to open door (sounds painful!)
- mutliple cleaning robots & lawn mowers
- pool regulates temperature automatically
- home entertainment system
- security cameras
- lots of DIY (Wemos, Raspberries, ...)

I really liked that they thought of some DIY solutions. Very nice!

#### Group 03
- family with several people
- very nice user story!
- smart pool
- lots of Alexas/Echo Dots
- smart washing machine

Why not use Philips Hue instead of the other system? -> Asked by Manuel

#### Group 04
- very environment friendly
- lots of Loxone (expensive!)
- focused on energy consumption (how much energy would be used by all the devices?)
- detect whether windows are open or closed
- close shutters automatically when room gets too hot

There was a lot of Loxone. Wouldn't there be other (probably cheaper) products to use?
The visualization of where the speakers in the building are was very nice.

### Exercise: KNX - Part II
#### Step 1 - Connect To the KNX System
Do not make the same mistake as we did and use the LAN cable. You are connecting to Loxone, not KNX, then. Instead, use the USB cable and plug it into your laptop. After that the interface should appear:
![step_01]

#### Step 2 - Create A Project
After connecting to KNX, you have to create a project. You can choose whatever name you like. The backbone needs to be set to "TP" and the group address style should be set to "Three Level". Once you are done configuring the project, create it:
![step_02]

#### Step 3 - Create A Building And Its Parts
Next up, you have to create a building and all of its parts. After that, your screen should go from something like this:
![step_03]
to something like this:
![step_04]

#### Step 4 - Add A Group Address To The Room, Add the Switch Actuator To the Group Address
Next up, to be able to add devices to a room, it has to have a group address assigned to it. Afer that, you can drag and drop a device to the group address:
![step_05]

#### Step 5 - Configure the Channels
Finally, you have to configure the respective channels to actually control the device you added to the room:
![step_06]

We configured the actutor to delay the on and off switching in order to notice a change in the configuration:
![step_07]
![step_08]

After that, we download the configuration to the system.

#### Step 6 - Write Value To Channel
Lastly, we write a value to the channel to change its state:
![step_09]
![step_10]

[step_01]: ./Exercise%20-%20KNX/1.PNG "KNX - Step 01"
[step_02]: ./Exercise%20-%20KNX/2.PNG "KNX - Step 02"
[step_03]: ./Exercise%20-%20KNX/3.PNG "KNX - Step 03.01"
[step_04]: ./Exercise%20-%20KNX/4.PNG "KNX - Step 03.02"
[step_05]: ./Exercise%20-%20KNX/5.PNG "KNX - Step 04"
[step_06]: ./Exercise%20-%20KNX/6.PNG "KNX - Step 05"
[step_07]: ./Exercise%20-%20KNX/7.PNG "KNX - Step 06"
[step_08]: ./Exercise%20-%20KNX/8.PNG "KNX - Step 07"
[step_09]: ./Exercise%20-%20KNX/9.PNG "KNX - Step 08"
[step_10]: ./Exercise%20-%20KNX/10.PNG "KNX - Step 09"


### Exercise: Home Gateway
This exercise was split in two: Iris and Michael focused on the integration with OpenHAB, whereas Manuel and I focused on Home Assistant.
Personally, from what I have seen, I prefer Home Assistant. The UI is way simpler and there are no bindings required, just add-ons.
The documentation for OpenHAB can be found over in [Iris' documentation](../../Lecture%20Iris/Lecture%205/ReadMe.md#OpenHab%20experiments). The documentation for Home Assistant can be found over in [Manuel's documentation](../../Lecture%20Manuel/Lecture%205/ReadMe.md#Home%20Assistant).


### Thoughts/Opinion
Z-Wave was really frustrating. We did not know why it was not working until we read the manual (RTFM, I know) and reset the Z-Wave plug. Integrating the plug was very easy however. 
Working with the Hue lights was really cool and actually made me think of buying some myself. Or the ones from Ikea because, you know, cheaper.

If I had to choose between OpenHAB and Home Assistant, I would definitely pick Home Assistant. I fancy the UI as it is reminiscent of Google's Material Design which I am already familiar with.

KNX was very frustrating. We had no instructions or whatsoever to get started. Once we got a connection to the KNX system, we applied the information we gained from going through the tutorial and finished the assignment rather quickly. However, we had spent so much time and patience on getting a connection to the system, that we had run out of time once we finished the assignment and we could not play around with the system. 