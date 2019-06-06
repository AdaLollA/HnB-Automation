# 0 - Running ulnoiot natively on Windows
The Professor set the seed for the idea to attempt running ulnoiot. In this document i will document the results and experiences resulting from it.

# 1 - Install Bash on Windows 10
We will be using the bash to setup the ulnoiot environment.

## 1.1 Prerequisites
This feature doesn’t work on the 32-bit version of Windows 10, so ensure you’re using the 64-bit version of Windows.

## 1.2 Enable Feature
Assuming you have 64-bit Windows, to get started, head to Control Panel > Programs > Turn Windows Features On Or Off. Enable the “Windows Subsystem for Linux” option in the list, and then click the “OK” button.

Click “Restart now” when you’re prompted to restart your computer. The feature won’t work until you reboot.

## 1.3 Get From Store
After your computer restarts, open the Microsoft Store from the Start menu, and search for “Linux” in the store.

You’ll see a list of every Linux distribution currently available in the Windows Store. As of the Fall Creators Update, this includes Ubuntu, openSUSE Leap, and openSUSE Enterprise.

To install a Linux distribution, click it, and then click the “Get” or “Install” button to install it like any other Store application.

### Microsoft App Store Problem
In my case i had to spend a lot of time on fixing the microsoft store since the "GET" button did only refresh the page but not actually download the selected application. A fix might be the following:

1. Go ahead click on your Search Windows button on your Windows 10.
2. Next, search for “Run“. Once you find it, click on Run.
3. Finally, all that you have to do is just copy and paste **WSReset.exe** into the search bar. Then just hit OK.

Good. Now you’ll see that the window will close on its own (might take 5-10 minutes), then it’ll open back up your Microsoft Store app. You can test to see if the Microsoft Store refresh loop has been fixed.

In my case - it wasn't. Yay!

So the next thing i tried was to switch from the educational wireless networks (fhhgb/eduroam) to a privately hosted mobile hotspot. Luckily this fixed the problem. Apparently the educational wireless networks somehow block traffic from the Microsoft Store here in Hagenberg.

If this still doesn't fix the problem you may refer to the "Fix Microsoft Store" source problem to find a few more possible solutions.

## 1.4 Run To Initialize
After the successful installation you have to run the shell for the first time. This will trigger an initialization process that will take a few minutes.

## 1.5 Credentials
After the initialization you will have to insert your new credentials. I chose the following:

 - username: Ada
 - password: yeet

## 1.6 Update System
As the last step lets get the system up to date using the following commands:

1. 
```
apt update
```

2. 
```
apt upgrade
```

# 2 - Install UlnoIoT
For this we are going to be within the previously (step 1) installed linux environment and we enter the following commands.

## 2.1 Install Dependencies
```
sudo apt install git mc mosquitto mosquitto-clients virtualenv iptables bridge-utils hostapd dnsmasq nodejs python-minimal
```

## 2.2 Clone IoTEmpower
```
git clone https://github.com/iotempire/iotempower
```

## 2.3 Installation
Now you can navigate into the just downloaded repository using the ```cd iotempower``` command. There you can run the following command to start the installation:

```
bash run
```

### Fix Bugs & Clean Install
If you encounter any errors during the installation process you can attempt a fix and rerun the installation using the following command:

```
iot install clean
```

## 2.4 Update PlatformIO
```
platformio platform update
```

## 2.5 Test Deployment
To test the deployment system we use an existing configuration of a node that is currently active and has already been adopted by downloading its folder through a raspberries web  ulnoiot interface.

Afterwards use the mounted **C** of windows in the shells **mnt/** folder to move the downloaded folder from Windows into your user- or workspace directory.

When this is done you have to manipulate the config file by updating the wifi ssid and credential preferences.

## 2.6 Install Espotapy
The last setup step is to install espotapy which can at the moment not be handeled by the system itself. For this you may utilize the following commands:

1.
```
mkdir -p /home/ada/.platformio/packages/tool-espotapy/
```

2.
```
cd /home/ada/.platformio/packages/tool-espotapy/
```

3.
```
wget https://raw.githubusercontent.com/esp8266/Arduino/master/tools/espota.py
```

## 2.7 Node Discovery
Now we have to find the address of the node. This might be kind of a challenge since Windows doesn't natively support mDNS.

### Over Raspberry DNS
You can use the nodes name (directory name, e.g. "node1") as deployment adress.

### Alternative: IP Over UlnoIoT Raspberry
Using the following command on the raspberries command line (either web or direct) you can ping any node and get the IP address through it:

```
ping node2.local
```

You can check if the adress is reachable from windows using the ping command with the discovered IP adress.

## 3 - Deployment
For the deployment itself just navigate into the target node directory and execute the deploy command with the previously discovered address. Here is an example of what this command might look like:

```
deploy node1
```

or

```
deploy 192.168.0.27
```


# 3 - Sources
[Linux Shell on Windows](https://www.howtogeek.com/249966/how-to-install-and-use-the-linux-bash-shell-on-windows-10/)

[Fix Microsoft Store](https://www.saintlad.com/fix-microsoft-store-refresh-loop-on-windows-10/)

[UlnoIoT Install Guide](https://github.com/iotempire/iotempower/blob/master/doc/installation.rst)
