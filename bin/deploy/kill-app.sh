#! /bin/bash

kill $(ps aux | grep java | grep util | awk  '{print $2}')