# Lecture 6
## S1810455012, Manuel Leibetseder

### Home Gateways

We still had some work to do for the last challenges on the home gateway implementations. Sensors actually worked inn this lecture, also Z-Wave controller and plug. We did a lot of research on that too and talked to other groups how they are doing - so no real documentation as we tried the steps mentioned in [lecture 5](https://github.com/AdaLollA/HnB-Automation/tree/develop/1%20-%20Lecture/Lecture%20Manuel/Lecture%205).



## Final Project

### Mycroft

Unfortunatelly MyCroft is not working on macOS, also with Docker containers as they only provided information with setup on Linux for Docker. I am really? 🤷‍♂ You already have a working environment for Linux and also just do a documentation for Linux again? Yeah ok. We decided to do MyCroft with a VM then. 

What I tried to get it running on mac was forwarding the brew installation of pulse audio to the docker container, but it was not possible to "hack" into that config, as I am not that familiar with Docker and forwarding components to the container. In this session I did a broad research on MyCroft to maybe get it to run on macOS, but I was not successfull.

```bash
docker run -d  
-v directory_on_local_machine:/root/.mycroft  
--device /dev/snd  
-e PULSE_SERVER=unix:${XDG_RUNTIME_DIR}/pulse/native  
-v ${XDG_RUNTIME_DIR}/pulse/native:${XDG_RUNTIME_DIR}/pulse/native  
-v ~/.config/pulse/cookie:/root/.config/pulse/cookie  
-p 8181:8181  
--name mycroft mycroftai/docker-mycroft  
```

The bash code above, for running the MyCroft container is the code executing to bind docker dependencies in the container with the operating systems libraries. Unfortunately I didn't get it to work as I was only able to install pulse audio with brew. Brew is living in its own environment in macOS, as Apple is restricting direct installation. So you forward a link of a directory which seem to not work that well for pulse audio. 

All the other setup for the final project are viewable in the [project folder](https://github.com/AdaLollA/HnB-Automation/tree/develop/4%20-%20Project3).