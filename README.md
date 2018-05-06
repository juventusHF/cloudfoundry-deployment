# Cloud Foundry Beispiele

## Pivotal Cloud Foundry

Ein möglicher CF-Anbieter is Pivotal: https://login.run.pivotal.io/login.

### Account einrichten

Erzeuge einen neuen Account: https://login.run.pivotal.io/login

- Es muss (zunächst) keine Kreditkarte hinterlegt werden.
- Als Identifikation zählt eine Telefonnummer.
- Die ersten $100 sind inklusive (das reicht für einige Monate).

Erzeuge eine "Org" und einen "Space", z.B. `demo` und `development`.

### CF CLI

Installier das Commandline Tool von Cloud Foundry: https://github.com/cloudfoundry/cli

Nun kannst Du Dich bei der Pivotal Cloud anmelden:

    cf login -a http://api.run.pivotal.io

### Switching deployment target

To switch the deployment target space, run one of the following

    cf target -o demo -s development
    cf target -o demo -s production

## Demo Applikationen

Dieses Repository enthält folgende Demo-Applikationen:

- Ein Single-Page-App Frontend mit ReactJS: [frontend/README.md](frontend/README.md).
- Ein RESTful Service mit Spring Boot: [service/README.md](service/README.md).

Nach dem Deployen der Demos nach Cloud Foundry siehst Du sie in der Pivotal Cloud Foundry Console https://console.run.pivotal.io/.

## Arbeiten mit Cloud Foundry

Nützliche Commands:

- Deployment Target: `cf t`
- Applikationen: `cf apps`
- Neueste Applikations-Logs: `cf logs demoservice.dev --recent`


### scaling up and out

https://docs.cloudfoundry.org/devguide/deploy-apps/cf-scale.html

## work with DB on CF

https://github.com/cloudfoundry-samples/pong_matcher_spring

## logging
https://docs.cloudfoundry.org/devguide/deploy-apps/streaming-logs.html

## CORS

Was tun, damit JS den Service aufrufen kann, obwohl die Domain verschieden ist?

- a) CORS header
- b) Gleiche Domain nehmen, und apps via Context Root unterscheiden.
- c) im CF eine Domain für einen Proxy einrichten?

