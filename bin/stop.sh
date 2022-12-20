#! /bin/bash

kill $(ps aux | grep java | grep util-service | awk  '{print $2}')
