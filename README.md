App Engine Java Application
Copyright (C) 2010-2012 Google Inc.

##JukeSvc Resources

    GET     /exercises        - Retrieves a list of exercises
    POST    /exercises        - Creates a new exercise
  						          FormParam: name (String)
    GET     /exercises/{id}   - Retrieves a specific exercise
    DELETE  /exercises/{id}   - Deletes an exercise

    GET     /exercises/{id}/musclegroups      - Retrieves list of muscle groups for exercise
    POST    /exercises/{id}/musclegroups      - Adds muscle group to exercise
									                FormParam: mgid (long)
    POST    /exercises/{id}/primarymuscles    - Adds muscle group to exercise
									                FormParam: pid (long
    POST    /exercises/{id}/secondarymuscles  - Adds muscle group to exercise
									                FormParam: sid (long)
									      
    GET     /musclegroups        - Retrieves a list of muscle groups
    POST    /musclegroups        - Creates a new muscle group
							             FormParam: name (String)
    GET     /musclegroups/{id}   - Retrieves a specific muscle group
    DELETE  /musclegroups/{id}   - Deletes a muscle group			   
							   
    GET     /muscles             - Retrieves a list of muscles
    POST    /muscles             - Creates a new muscle
							           FormParam: name (String)
    GET     /muscles/{id}   	 - Retrieves a specific muscle
    DELETE  /muscles/{id}   	 - Deletes a muscle		




## Skeleton application for use with App Engine Java.

Requires [Apache Maven](http://maven.apache.org) 3.0 or greater, and JDK 6+ in order to run.

To build, run

    mvn package

Building will run the tests, but to explicitly run tests you can use the test target`

    mvn test

To start the app, use the [App Engine Maven Plugin](http://code.google.com/p/appengine-maven-plugin/) that is already included in this demo.  Just run the command.

    mvn appengine:devserver
    
To debug, run the below command and start a 'Remove Java Application' debug configuration on localhost:1066
	
    mvn appengine:devserver -P debug

For further information, consult the [Java App Engine](https://developers.google.com/appengine/docs/java/overview) documentation.

To see all the available goals for the App Engine plugin, run

    mvn help:describe -Dplugin=appengine
