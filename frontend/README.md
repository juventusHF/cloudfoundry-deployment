# SPA nach CF deployen

Diese Applikation basiert auf dem CF React Starter, siehe https://github.com/pivotal-cf/react-starter.

Um diese Applikation deployen zu können, sollte das CF Command Line Tool installiert sein:

    cf login -a http://api.run.pivotal.io

Die Applikation lässt sich wie folgt bauen und starten:

    npm  install
    gulp foreman

Die Applikation lässt sich wie folgt nach CF deployen:

    gulp deploy

Das Deployment-Manifest befindet sich in [manifest.yml](manifest.yml).

Mehr Informationen finden sich [im originalen README.md](README.orig.md).