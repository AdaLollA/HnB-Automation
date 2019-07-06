# Lecture 2
## S1810455024, Alexander Stelzhammer

### Exercise: Let’s Switch on a Light
This task was done with the help of Iris. To see her side of the documentation, please refer to [her documentation](../../Lecture%20Iris/Lecture%202/ReadMe.md#Lighting%20an%20LED%20Day%202).

Turns out that the Pi was using an updated version that is not compatible with the image from the previous lecture. Ulno uploaded a new image and/or provided commands to upgrade 
- Downloaded the new image
- Flashed the Pi using the new image
- Ulno flashes the nodes because flashing over wire is bad (only a 70% success rate)
- After receiving the flashed nodes, we tried adopting the node:
  - Connected the node to the anchor power supply
  - Put the node into adoption mode (morse code: 3 long, 5 short)
  - Tried adopting the node via web interface
  - **ERROR:** Could not adopt node
    - *SOLUTION*:
    Tried recompiling the compile cache:
      - Command "iot"
      - Command "upgrade_cache"
      - **ERROR:** Same error as before.

    - The solution did not work. Thus, with the help of Ulno we killed the upgrade-cache thread.
    - We ran         - Thus, we killed upgrade cache thread.
        - Ran command "rm -rf /home/iot/.platformio/packages/framework-arduinoespressif8266"
    - After that, we changed into the folder "iot" and subfolders "iot-test/node1", followed by the command "compile" to test everything is working fine.
    - Afer the previous steps the nodes were working fine and adoption was successful.
    - For the second node, we created another node folder (F2 -> Create New Node Folder) and renamed it from "new_node" to "node2". Then, we connected the second node to the anchor power supply and tried out the display.
      - At first, the node did not work because it was not properly connected to the power supply (the Micro-USB to USB cable was not fully inserted). After making sure it was properly connected to the power supply, we used the following steps:
        - Used the reset button
        - Pressed the "grounding" button of the display twice while it was resetting.
        - The display then showed the morse code and the time remaining.
        - We adopted the node which was successful.

    - We now have two working nodes.
  - As we added the second node using the node template, no code was present in the "setup.cpp" file of node2. Because of this, we copied the code of node1 to the "setup.cpp" of node2. After that, we OTA-deployed the code to node2. 
  - Using the connected button to node1 we were able to control the LED on node2. The button was connected using a yellow, a red, and a black cable:
    - The black cable has been connected to G (= ground).
    - The yellow cable has been connected to S (= signal).
    - The red cable has been connected to V (= 5 V).


#### Upgrading the Pi
- Pi needs to be connected to the internet
- Open Full User Interface
  - Command "iot upgrade"
    - It will download changes from github (-> pull request)
  - Command "sudo su"
    - Change to superuser (get root access)
  - Use following commands: 
    - sudo  npm uninstall -g --unsafe-perm gritty
    - sudo  npm uninstall -g --unsafe-perm terminal-kit
    - sudo  npm uninstall -g --unsafe-perm cloudcmd
    - sudo  npm innstall -g --unsafe-perm gritty
    - sudo  npm install -g --unsafe-perm terminal-kit
    - sudo  npm install -g --unsafe-perm cloudcmd
  - Edit "bin/cloudcmd"
    - Replace content with:
        ```bash
        #!/bin/bash

        ## local
        #cd "$HOME/cloudcmd"
        #exec node bin/cloudcmd.js

        # global
        exec /usr/bin/cloudcmd "$@"
        ```

  - Edit ".cloudcmd.menu.js"
    - Replace content with 
        ```javascript
        module.exports = {
            'D - Deploy': async ({CloudCmd}) => {
                await CloudCmd.TerminalRun.show({
                    command: 'iot menu deploy',
                    autoClose: true,
                });
                
                await CloudCmd.refresh();
            },
            'A - Adopt': async ({CloudCmd}) => {
                await CloudCmd.TerminalRun.show({
                    command: 'iot menu adopt',
                    autoClose: true,
                });
                
                await CloudCmd.refresh();
            },
            'C - Create New Node Folder': async ({CloudCmd}) => {
                await CloudCmd.TerminalRun.show({
                    command: 'iot menu create_node_template',
                    autoClose: true,
                });
                
                await CloudCmd.refresh();
            },
            'V - Advanced': async ({CloudCmd}) => {
                await CloudCmd.TerminalRun.show({
                    command: 'iot menu advanced',
                    autoClose: true,
                });
                
                await CloudCmd.refresh();
            },
            'M - Full IoTEmpower User Menu': async ({CloudCmd}) => {
                await CloudCmd.TerminalRun.show({
                    command: 'iot menu',
                    autoClose: true,
                }); 
                await CloudCmd.refresh();
            },
            'F2 - Rename file': async ({DOM}) => {
                await DOM.renameCurrent();
            }
        }
        ```


### Challenge: RGB LED
[Can be found here](./Challenges/RGB%20LED/ReadMe.md)

### Challenge: Analog Light Sensor
[Can be found here](./Challenges/Analog%20Light%20Sensor/ReadMe.md)

### Thoughts/Opinion
Slowly, things are starting to make sense. However, the framework is still magic to me and why everything works the way it does will hopefully be answered in the coming lectures. There were small achievements today, so the frustration is stating to wear off. I am curios how the coming lectures will go.