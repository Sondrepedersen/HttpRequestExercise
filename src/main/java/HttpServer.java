import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    private final ServerSocket serverSocket;

    public HttpServer (int port) throws IOException{
        this.serverSocket = new ServerSocket(port);

        try (Socket clientSocket = serverSocket.accept()) {

            String response = "HTTP/1.1 404 not found\r\n\r\n";
            clientSocket.getOutputStream().write(response.getBytes());
        }


    }


    public static void main(String[] args) throws IOException {
        new HttpServer(1080).start();
    }

    public void start() throws IOException {
        Socket socket = serverSocket.accept();

        socket.getOutputStream().write(("HTTP/1.1 200 OK\r\n" +
                "Content-length: 12\r\n" +
                "Content-type: text/plain\r\n" +
                "\r\n" +
                "Hello World!").getBytes());
    }

    public int getActualport() {
        return 0;
    }
}
