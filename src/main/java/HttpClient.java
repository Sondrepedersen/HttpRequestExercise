import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;


public class HttpClient {

    private final int statusCode;

    public HttpClient(String host, int port, String requestTarget) throws IOException {
        Socket socket = new Socket(host , port);
        socket.getOutputStream().write(("GET " + requestTarget +
                " HTTP/1.1\r\nHost: " + host + "\r\n\r\n").getBytes());

        StringBuilder result = new StringBuilder();
        InputStream in = socket.getInputStream();

        int c;
        while ((c = in.read()) != -1 && c != '\r') {
            result.append((char) c);
        }
        String myResponseMessage = result.toString();
        this.statusCode = Integer.parseInt(myResponseMessage.split(" ")[1]);
        System.out.println(result);


    }

    public static void main(String[] args) throws IOException {
        HttpClient client = new HttpClient("httpbin.org" , 80 , "/html");
        //System.out.println(client.getStatusCode());
    }

    public Integer getStatusCode() {
        return statusCode;
    };

   /* public String getHeader(String fieldName) {
        return headerFields.get(fieldName);
    }*/


}
