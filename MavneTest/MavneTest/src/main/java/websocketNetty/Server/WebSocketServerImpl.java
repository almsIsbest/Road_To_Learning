package websocketNetty.Server;

public class WebSocketServerImpl extends WebSocketServer<WebSocketHandler> {
    @Override
    public WebSocketHandler createHandler() {
        return new WebSocketHandler();
    }

    public static void main(String[] args) {
        WebSocketServerImpl webSocketServer = new WebSocketServerImpl();
        webSocketServer.start("127.0.0.1", 59757, false);
    }
}
