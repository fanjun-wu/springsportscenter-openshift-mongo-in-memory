springsportscenter-openshift-mongo-in-memory
============================================
you don't need to install Hazelcast(the in-memory cache we  use here), just remember to adapt the pom.xml for your cloudbees rather than my openshift

******************************************************************************************
mongoDB config file: (!!!!)
    springsportscenter-openshift-mongo-in-memory / src / main / resources / hazelcast-config.properties
    two version inside, remember to comment one

    for hazelcast:
    hz_port=5701 is the default port used by hazelcast, you can try it first, if not change it to the port allowed in     cloudbees, hz_port=16000 is the one i try because it seems that 16000 can be used by us but it still doesn't work


******************************************************************************************
after deployed, check in the: http://hazelcastmonitor-cloudmigration.rhcloud.com/mancenter-3.2-RC2
(defined in springsportscenter-openshift-mongo-in-memory / src / main / resources / hazelcast.xml  Line 77th)

  log in infor: username: admin,  password: admin
  then there is a box saying "directory write problem", just click on the "continue read-only". then you will see many graphs there if it's deployed successfully.
  
