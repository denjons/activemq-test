
##while ! echo exit | nc 10.0.2.30 27017; do sleep 10; done

sleep 10

mongo 10.0.2.30:27017 /replSetConfig.js
