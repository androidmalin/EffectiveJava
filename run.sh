#!/bin/bash
gradle -q build && \
java -jar app/build/libs/malin-java-1.0.0.jar
