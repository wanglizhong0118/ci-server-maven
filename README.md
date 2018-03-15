# Continuous Integrations

A maven based Java project working as a simple coninous integration. This CI server only contains three core features of continuous integration introduced below.


## System Enviroment
* JDK 1.8 +
http://www.oracle.com/technetwork/java/javase/downloads/index.html
* Ngrok server
https://ngrok.com
* Maven
http://maven.apach
* Github Account
https://github.com
* Gmail Account
https://mail.google.com


## How to configure
1. Download ngrok from https://ngrok.com/download and unzip it
2. Download the runnable jar filr [ci-server.jar](https://github.com/wanglizhong0118/ci-server-maven/blob/master/ci-server-maven/ci-server.jar "ci-server.jar")
3. Execute the jar by `java -jar ci-serve.jar` in CMD/Powershell
4. Run `./ngrok http 8080` in another CMD/Powershell
5. Open github repository page and go to `Settings >> Webhooks`, click on `Add webhook`. 
6. Paste the forwarding URL gotten from ngrok in field `Payload URL` and send click on `Add webhook`. 
7. Any commit made in the repository will be auto compiled and tested. 


## How to configure
Compilation using Maven  
`mvn clean test-compile`

Test using Mavn  
`mvn test -Dtest=AllTests`



## Featrure

Compilation: the CI server supports compiling the group project, a static syntax check is to be performed for languages without compiler. Compilation is triggered as webhook, the CI server compiles the branch where the change has been made, as specified in the HTTP payload.


Testing: the CI server supports executing the automated tests of the group project. Testing is triggered as webhook, on the branch where the change has been made, as specified in the HTTP payload.


Notification: the CI server supports notification of CI results. The CI server sends an email to the project member about the build result.


## Documentation
All the source code API, see [Javadoc](https://github.com/wanglizhong0118/ci-server-maven/tree/master/ci-server-maven/doc/index.html "Javadoc")
