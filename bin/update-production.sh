#! /bin/bash

ssh quicktionary << EOF
    cd util-service-backend
    git pull origin master
    ./bin/stop.sh
EOF
