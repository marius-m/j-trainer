#!/bin/bash
echo "Refreshing project"
set +x
./gradlew clean && ./gradlew war && ./gradlew cargoRedeployRemote

echo "Complete!"
