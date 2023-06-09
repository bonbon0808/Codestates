#!/usr/bin/env bash
# Change ownership of files in /home/ubuntu/build directory using sudo
sudo chown -R ubuntu:ubuntu /home/ubuntu/build
sudo chmod +x /home/ubuntu/build/**
sudo mkdir -p "/var/log/coffee-order-app"
sudo chown -R ubuntu:ubuntu /var/log/coffee-order-app