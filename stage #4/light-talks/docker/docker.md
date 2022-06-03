## Docker

* What is docker
    * Docker architecture
    * Simple demo - `docker run -p 8080:80 nginx`
    * Docker advantages
* Virtualization vs Containerization
    * Virtualization - is the process of running a virtual instance of a computer system in a layer abstracted from the actual hardware.
    * VMs require multiple OS, containers run on single container engine. Because of it, containers
        * require less resources
        * start faster
    * Containers are lightweight and fast
* Docker example
    * `docker ps` - show running nginx
    * `docker kill` - stop nginx
    * `docker run -p 8088:80 nginx` - bind nginx to another port
    * `docker exec <id> ls` - execute a command inside the container
    * `docker exec -it <id> /bin/bash` - enter the shell in container. `it` to stay inside and not return immediately
        * `curl localhost:8088` - can't connect 
        * `curl localhost:80` - container binds to port 80, so inside of it we have to make requests to 80
    * `docker run busybox` - runs busybox, basically linux. When you don't specify a command, exits immediately
    * `docker run busybox ls`
    * `docker run -e A=1 busybox env` - pass an env var to the container
    * `docker run --memory=100m --cpus=1 nginx` - set limits on container
* Dockerfile
    * Anatomy
        * `FROM <>` - first command in dockerfile, specifies base image. For java apps it's usually JDK image
        * `COPY` - copies files or folders from one location to another
        * `RUN` - executes any command during the build phase
        * `CMD` - specifies command that runs on the container start
    * Layers
        * Each instruction in a Dockerfile creates a layer. Each layer is an image itself
        * Layers are used to avoid transferring redundant information and skip build steps which have not changed
    * Writing dockerfile for java app
        * Show app - simple hello world. Execute `graldew jar` to build an executable
        * Dockerfile
            * `FROM openjdk:11`
            * `COPY ./build/libs/demo-1.0-SNAPSHOT.jar demo.jar`
            * `CMD ["java", "-jar", "demo.jar"]`
        * `docker build -t demo -f Dockerfile .`
        * `docker run demo`
* Docker compose
    * Allows you to define your application multi-container stack in a file
    * Demo
        * Show any briefly describe `docker-compose.yaml`
        * `docker-compose up`. Go to `http://localhost:5050`, login - `email@epam.com`, password - `admin`. Create server, host - `postgres`, username and password - `admin`
