# Please refer to the [global lecture readme file](https://github.com/AdaLollA/HnB-Automation/tree/develop/1%20-%20Lecture/Lecture%20Lorenz) to find the desired resources.

# Debate
We also had the debate where i was the Debate-Administrator, while Iris was the Moderator. The entire team (except Michael) worked hard and spent multiple hours the day before on

 - researching and defining a mode
 - creating a timetable
 - organizing the the communications channel (discord)
 - assigning / managing the teams
 - gathering the teams structures, speakers and their arguments
 - filming a [20 minute debate demo](https://www.youtube.com/watch?v=iGxVoLWiEhA&feature=youtu.be) where Manuel (con1), Alex (con2) and i (pro) represented the debaters and Iris trained her moderating

The results (questions, participants, statistics, etc.) can be found at [this link](https://www.loom.com/share/5df041b1f0044c17a3e1355317fa7672).

# Smart Lock Progress
This lecture we invested some more time into finalizing the smart lock project.

## Architecture / Flow
When holding an RFID card onto the sensor an mqtt message is sent to node red. NodeRed then communicates with the java-based authentication management server to generate an access key. The key is pushed to the corresponding phone (rfid cards are mapped to users in authentication management server). The notification looks like the following screenshot and contains the authentication code:

![push](push.jpg)

When clicking the notification you get automatically forwarded to the node red user interface where you can enter your code and press the confirm button (see image).

![nodered](nodered.jpg) 

Node red then again communicates with the authentication management server to assert validity as well as timestamp validation of the provided authentication code. If everything is asserted valid the smart lock opens.

The entire process is finished within a few seconds and the actual latency between pressing confirm and the lock opening can be measured in milliseconds.

## Push Integration
We used IFTTT for push integration with the following configuration that is triggered on webhook (called by NodeRed).

![ifttt config](ifttt.png)

## HTTP Call Confirmation
Since we do not necessarily have to use the code which brings a few usability losses (have to remember code, have to enter code into box, press confirm) we afterwards transitioned to the usage of a clean HTTP GET request. For this the java authentication management server was altered to no longer use auth-codes, and the IFTTT push notification is modified to directly call the necessary (newly added) NodeRed HTTP-GET call.

The new users flow is now way simpler:

1. Hold card onto sensor
2. Press Push Notification

# Personal Opinion
The project is very interesting and a great way to learn about multiple devices as well as infrastructure elements. My personal contribution was architectural and conceptual design as well as the push notification implementation together with Iris. Other participation was performed through assistance in nodered system design.

The push notificatiosn were not necessarily required by the execerise assignment, so it might be evaluated as extra work. Also the usability optimization through removing the authentication code and integrating HTTP-call confirmation was not assigned and performed out of own motivation.

What was really frustrating was that Michael was not communicating with us neither through phone, discord or telegram. Not even when directly contacted through said channels. He was not present at the team meeting and did not contribute to project 1.