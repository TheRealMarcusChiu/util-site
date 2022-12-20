#! /bin/bash

ssh util-site << EOF
    cd util-site
    git pull origin master
    ./bin/stop.sh
EOF
