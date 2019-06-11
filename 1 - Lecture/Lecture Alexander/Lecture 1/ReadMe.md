# Lecture 1
## S1810455024, Alexander Stelzhammer

### Self Presentation
#### Name
Alexander Stelzhammer

#### Age
24

#### Occupation
- former MBI student
- switched to MC because of 
    * wanting to stay in the field of Software Development
    * the freedom it gives you to choose your own courses
        -> can pick the courses that fit my former degree (machine learning, AI, mobile health/sports, cross platform)

#### Expectations from HaBA
I expect to learn how to improve living using IoT and hope to get knowledge how to enable people with disabilities to live a more carefree life, at least when they are at home.

#### Strengths
- knowledge of medicine- and bioinformatics as well as anatomy and physiology
- stress resistent
- knowledge of Scrum and Agile Development, some experience as a project leader

#### Weaknesses
* spend too much time on details
* can get a little heated in discussions
* busy 24/7

### Hello World of IoT and H&B Automation - Day 1
#### Movie Takeaways
##### Applications
- turn on light via a click
- play stereo via a click
    - lower the volume via laptop
- grant public access to stereo/lamp/webcam/...
- remote control cars
- stacking elevators
- connectected lawn mowers
- park your car via an app
- lighting and climate control
- coffee machine connected to alarm
- feed your pets via alarm
- dynamic route management

##### Domains
- Safety & Security
    -> dynamic root management
    -> lighting installations for security, acoustic signals and voice prompts
    -> 
- Efficiency
- Energy Optimization
    -> energy mix of public power grid systems
    -> additional energy storage is possible via intelligent networking
- Comfort & Health


##### Other
- modularity is key
    -> adapting to users' needs


### Hello World of IoT and H&B Automation - Day 2
#### Continue work from Day 1
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