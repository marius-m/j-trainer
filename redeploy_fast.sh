#!/bin/bash
echo "Refreshing project"
set +x
./gradlew war && ./gradlew cargoRedeployRemote

echo "Complete!"
