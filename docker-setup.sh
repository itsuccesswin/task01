#!/bin/bash

sudo yum install docker -y 
sudo groupadd docker
sudo usermod -a -G docker $USER
sudo systemctl enable docker
sudo systemctl start docker
sudo curl -s -L https://github.com/docker/compose/releases/download/1.22.0/docker-compose-$(uname -s)-$(uname -m) -o /usr/local/bin/docker-compose
chmod +x /usr/local/bin/docker-compose
sudo su - $USER
