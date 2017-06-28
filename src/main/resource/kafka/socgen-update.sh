#!/bin/bash

DIR=$(dirname $(readlink -f $0))
cd $DIR

cd OBP-Kafka-SocGen

#git pull 1>&1 | grep "Already up-to-date."
git fetch origin
git checkout JVMcompatible

if [[ ! $?  == 0 ]]; then
  ../socgen-stop.sh
  mvn clean install
  ../socgen-start.sh
fi

