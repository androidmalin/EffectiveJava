#!/bin/bash
gradle -q clean && \
gradle -q :skeletalImplementation:jar && \
gradle -q build && \
java -jar app/build/libs/malin-java-1.0.0.jar
