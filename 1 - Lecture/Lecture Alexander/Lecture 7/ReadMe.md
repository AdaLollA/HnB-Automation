# Lecture 7
## S1810455024, Alexander Stelzhammer

### Project 3: Final Presentations

#### Project 3: "Chemsident Automation"
##### Presentation
- thinking more about automating the building of a bigger company
- automate physical access control system, environment safety guards, and energy consumption of a company working in the field of chemistry
- most important part of the project: Smart Door Lock using two-factor authentication with RFID card and enter PIN within 5 seconds
- configuration happened in Node-RED
  - very messy -> split the logic by domains using multiple working sheets/tabs!
- goal was to control Kodi with any device 
  - penalty for bad energy consumption -> play a bad or annoying song until energy consumption is great again
- Z-Wave proved to be difficult
  - found multiple Z-Wave devices despite there only being one Z-Wave active

##### Final Video
- very thorough
- however, audio was hard to understand and made it hard to follow what was going on over the course of the story
- adding a screenshot of the UI (used to unlock the Smart Door Lock) would have been helpful to understand what was going on
  - multiple buttons were pressed and multiple text inputs were used; however, it was hard to decipher the labels


#### Project 3: "Mannequin"
##### Final Video
- very funny video because of the mannequin
- very easy to follow, funny presentation
- using live voice-over works better than recording it on the video itself

##### Presentation
- tried using openHAB and said it was uselessly complex
- tried installing HomeAssistant (with the new Hass.io interface)
- drew internet from USB tethering 
- running HomeAssistant (Hass.io) on a Pi instead of a laptop
  - very good experience with HomeAssistant
  - easy to install add-ons
- used components in HomeAssistant
  - MQTT
  - Spotify
  - Plex
  - Philips Hue
  - Rest Command
  - Sun (to know sunrise/sundown)
  - HomeKit
  - Tuya Cloud
- used Node-RED for Smart Lock and coffee machine
  - had to trigger coffee machine for 20 seconds to get the perfect cup of coffee
  - used an old coffee machine that does not support any IoT functionality
    - instead used servo for pressing the button twice
- used Philips Hue for light automation
- Z-Wave socket for fans
- Voice control over Siri and Home App
- also had troubles with the power consumption -> we were not the only ones!
- Mycroft did not work very well which is why they switched to Siri


#### Project 3: "Family Scenario"
##### Presentation
- Door Sensor (welcoming and tracking assistant)
  - tracking how many people are inside your home
- Smart Lock (security with a second factor)
- connecting Spotify to openHAB and Kodi did not work out
  - scrapped everything and sent commands to Spotify directly using Node-RED
- Lighting
  - autonomous and easy control system
- Watering
  - water and plants friendly
- Mycroft
  - voice assistant and entertainment 

- very good overview of domains!

##### Final Video
- door sensor looks like bombs
  - but looks awesome! music and lights are turned on as soon as someone enters the room
  - got a look at the HomeAssistant UI! very nice
  - very awesome water pump system!
    - very impressive!
- good display how "well" Mycroft currently works
  - it is a very ambitious project, however at this stage not really usable...
  - does not understand very well what is said
  - problems with Spotify integration



### Project 3: Review of Final Presentations
It was very awesome to see what the other groups built, what they used and especially what challenges and problems they were facing. Especially Group 3 ("Mannequin") showed awesome ways to automate the morning routine (coffee machine, lights, ...). 
Also, the presentations give a big incent to actually try to automate more in your home or to try out other stuff (Mycroft, Kodi, HomeAssistant, Philips Hue, ...).