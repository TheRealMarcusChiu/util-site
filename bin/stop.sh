#! /bin/bash

kill $(ps aux | grep java | grep util-site | awk  '{print $2}')
