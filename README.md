# running-location-service
## How to run:
1. Please open the running-location-service folder, make sure the build is successful.
Run:
```
$ mvn clean install
```
2. Set up docker mysql database
```
$ docker-compose up
```
3. Go to the target file and run the jar file
```
$ cd target
$ java -jar running....
```
## API
1. Post Json info to the database, use PostMan to help me verify the function, send POST request.
```
http://localhost:8080/running_info
```
2. Show user info in descending direction, send GET request.
```
http://localhost:8080/running_info?page=1&size=2
```
3. Find user info by running id, send GET request.
```
http://localhost:8080/running_info/{runningId}?page=1&size=2
```
4. Find user info by username, send GET request.
```
http://localhost:8080/running_info/username/{username}?page=1&size=2
```
5. Delete user info by running Id, send DELETE Request.
```
http://localhost:8080/running_info/delete/{runningId}
```
