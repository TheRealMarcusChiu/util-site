#! /bin/bash

ssh ubuntu-server.local << EOF
    cd util-site/
    git pull origin master
    ./bin/deploy/kill-app.sh
    nohup mvn spring-boot:run &
    tail -f nohup.out
EOF