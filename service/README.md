# Spring-Boot Applikation nach CF deployen

Um diese Applikation deployen zu können, sollte das CF Command Line Tool installiert sein:

    cf login -a http://api.run.pivotal.io

Die Applikation lässt sich wie folgt bauen und nach CF deployen:

    mvn package
    cf push

Das Deployment-Manifest befindet sich in [manifest.yml](manifest.yml).

Mehr Informationen finden sich [im originalen README.md](README.orig.md).

## Development

Starte die Applikation:

    mvn spring-boot:run
    
Du kannst nun die Applikation unter folgenden URLs aufrufen: 
- http://localhost:8080/employees
- http://localhost:8080/departments
