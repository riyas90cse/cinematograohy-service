#!/bin/bash

rm -rf cinematography-service
git clone -b main https://github.com/riyas90cse/cinematography-service.git

rm -rf cinematography-service/.git/

docker build -f services.Dockerfile -t app-base .

# cleanup
rm -rf cinematography-service