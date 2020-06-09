#!/bin/bash
rm -rf .idea/ .gradle/ && \
find . -name "build" -type d | xargs rm -rf && \
find . -name "*.iml" -type f | xargs rm -rf && \
find . -name ".settings" -type d | xargs rm -rf && \
find . -name ".project" -type f | xargs rm -rf && \
find . -name ".classpath" -type f | xargs rm -rf
