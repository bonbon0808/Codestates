#!/usr/bin/env bash
cd /home/ubuntu/build
nohup java -jar coffee-order-app.jar > /var/log/coffee-order-app/app.log 2>&1 &