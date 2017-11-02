docker run -d --name mongo_db1 --network net1 --ip 10.0.0.2 -v mongodb1:/data/db --entrypoint="" mongo mongod --port 27017 -dbpath /data/db --replSet demo
docker run -d --name mongo_db2 --network net1 --ip 10.0.0.3 -v mongodb2:/data/db --entrypoint="" mongo mongod --port 27017 -dbpath /data/db --replSet demo
docker run -d --name mongo_db3 --network net1 --ip 10.0.0.4 -v mongodb3:/data/db --entrypoint="" mongo mongod --port 27017 -dbpath /data/db --replSet demo
