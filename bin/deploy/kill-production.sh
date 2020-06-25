#! /bin/bash

ssh ubuntu-server.local << EOF
    cd util-site/
    ./bin/deploy/kill-app.sh
EOF