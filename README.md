# 🃏 GolpeClient

Client for the Golpe automatic card game.
This is the client application that connects to the GolpeServer, sends commands, and receives game state updates. It can be used as a bot or interactive player client.
The client is a work-in-progress and is intended for learning and personal use.

## 📌 What is GolpeClient?

GolpeClient lets a user or bot connect to a Golpe game server, communicate using JSON packets over WebSocket, and participate in automatic or interactive gameplay. It works with the GolpeServer backend.
The client can be used to build:

* Bots that automatically make decisions
* Test clients for server debugging
* Simple players that connect via console

## 🧠 How the Client Works

**GolpeClient implements**:
* WebSocket connection to the server
* JSON packet construction and parsing
* Handshake logic (JOIN, READY, MOVE / PLAY_CARD)
* Ability to listen for server packets and react

This is done using a Java WebSocket client library (you may use libraries like nv-websocket-client or Java’s built-in WebSocket implementation).\
The client does not contain full game logic; it simply follows the packet protocol defined for communication.