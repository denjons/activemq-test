 
if( rs.status().myState < 1){
  var demoConfig={"_id": "demo", "members": [{ "_id": 0, "host": "10.0.2.30:27017", "priority": 10 }, {"_id": 1,"host": "10.0.2.31:27017"}, {"_id": 2, "host": "10.0.2.32:27017", "arbiterOnly": true}]};

  rs.initiate(demoConfig);

}

