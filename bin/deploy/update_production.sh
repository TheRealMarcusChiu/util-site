#! /bin/bash

ssh pi@192.168.86.28 << EOF
    cd util/
    git pull origin master
    ./bin/deploy/kill-app.sh
    nohup mvn spring-boot:run &
    tail -f nohup.out
EOF