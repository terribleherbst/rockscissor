# Rock, Paper, Scissor

A basic implementation of the popular game [Rock, Paper, Scissors](https://en.wikipedia.org/wiki/Rock%E2%80%93paper%E2%80%93scissors) in Java
using Spring Boot and [Easyrules](https://github.com/j-easy/easy-rules/wiki).

# Usage
The code contains all you need to start and run the game by using the gradle wrapper with `gradlew bootRun`. The
embedded server will start an at [http://localhost:8080/game](http://localhost:8080/game]) which accepts
an parameter `choice` with one of the values:
* Stein (Rock)
* Papier (Paper)
* Schere (Scissor)

For example you can call [http://localhost:8080/game?choice=Stein](http://localhost:8080/game?choice=Stein) 
to play a game with a choice of Stein.

# Stateless implementation
The game is implemted just for a simple rule engine demo. The implementation is stateless. The selections are 
not stored on the server and the computer _knows_ nothing about the human player. Every selection of the computer
is just a random choice and no strategy is implemented based on human behaviour.

# Variant
The code contains an additional variant of the game which includes Fountain. The variant can be used by
using the `brunnen` profiles, which is configured in `application-brunnen.properties`.

# Development
All source code of the game is included. For development you need an install Java 1.8 JDK. You should 
make yourself familiar with the [Spock Testing Framework](http://spockframework.org/spock/docs/1.1/index.html) 
and the [Lombok](https://projectlombok.org/) project.
There are also some checkstyle configuration which define code styles based on best practice and the common
coding style conventions.