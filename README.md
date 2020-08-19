# $ongmate 

This app's main objective is to connect people who have similar music taste. They can send each other playlists, collaborate in making new playlists, chat about music and their beloved artists.

## Milestone tasks. They are sorted based on their relevance.

### Backend - general
- create endpoints for Frontend - use @RestController, so JSON data will be sent,
- learn about stream API, so it can be used to implement clean data validation from Frontend.

### Frontend - general
- create BASIC views with html, css, js,
- upgrade views so it looks cool,
- use Fetch API or axios library to fetch data from our backend server,
- migrate frontend to React.js, so fancy stuff can be added - use Nelson's tutorial -> https://www.youtube.com/watch?v=i-hoSg8iRG0

### Security layer i.e. authentication, authorization.
- read spring security documentation,
- add security config to the project - i suppose we will use JWT,
- authenticate new user, by asking Spotify auth server for user credentials, when creating user get his password, use Spotify email as a login,
- create some users and assign roles to them, then add it db,
- match endpoints with user roles/permissions,
- set Timeout after inactivity interval - i think it can be done, by using application.properties file.

### Check Spotify API tutorial on connecting your first app to their database.
- https://developer.spotify.com/documentation/web-api/ - already added to maven dependency, git repo have many useful examples, super simple,
- create service which will handle talking to spotify about data,
- use API to fill database tables (Artist, Playlist, Track) - use data.sql file,
- storing user tokens might be added to User entity, so we can easily send requests to spotify,
- add Spotify controller, so it contains endpoits which will be used to talk to spotify db.

### Develop dummy algorithm which computes graph based on peoples playlists.
- make it in a way that it is stateless and multiple instances can be used to compute graph,
- create algorithm service,
- do some research about it,
- migrate it to microservice.


## Future objectives
### Push it to Amazon s3 bucket.
- check Nelson's tutorial about it.

### Rewrite it to microservice architecture.
- read about msg brokers for Java - JMS?,
- set rabbitMQ container or some different message broker

### Dockerize services.
- do some research,
- dockerize it.

### Make it reactive
- study async Java,
- study reactive programming paradigm,
- use Rx.Java.


