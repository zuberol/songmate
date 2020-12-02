# $ongmate 

This app's main objective is to connect people who have similar music taste. They can send each other musical challenges, collaborate in making new playlists, chat about music and their beloved artists.


## Things I find cool in this project
- creating challenges - it is done in "/matching/custom" endpoint. I have implemented a custom deserializer making it possible. It also uses Java Reflection API. Thanks to that I can save many types of challenges with just one endpoint,
- database connectivity - I have learnt a lot about jdbc, jpa, hibernate and a persistance layer as a whole,
- using Spotify API - that was an opportunity to learn about OAuth 2.0 and REST principle,
- Spring Security - I have learnt about different kinds of authorization and authentication.

## Future objectives
- the project needs huge refactoring,
- migration to AWS cloud,
- dockerization and CI/CD pipeline,
- creation of better matching algorithm,
- make project reactive using WebFlux,
- add chat feature using WebSockets,
- create mobile-first frontend made with React.js.
