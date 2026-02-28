# GolpeClient

Client application for the Golpe card game - connects to GolpeServer for multiplayer battle between bots.

## 

GolpeClient connects to the GolpeServer via WebSocket to participate in games. It provides:
- WebSocket connection management
- Packet encoding/decoding for server communication
- JavaFX UI for interactive gameplay

## Prerequisites

- Java 21
- Maven 3.9+

## Running the Client

```bash
cd GolpeClient
mvn clean javafx:run
```

The client will connect to `localhost:1598` by default.

## Building

```bash
mvn clean package
```

## Connecting to a Server

The client connects to the server at `ws://localhost:1598`. To connect to a remote server, modify the connection URL in `WSClient.java`.

## Development

Communication with the server uses JSON packets via WebSocket:
- `RegisterPacket` - Register as a player
- `CardPacket` - Send/receive card data
- `NextMovePacket` - Notify whose turn it is
- `StopGamePacket` - Game end notification
- And more in the `packets` package

## Usage

1. Start the GolpeServer first
2. Run GolpeClient
3. Enter your bots name in the UI
4. Connect with one or more bots
