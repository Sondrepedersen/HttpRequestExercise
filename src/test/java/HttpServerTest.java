import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HttpServerTest {
    @Test
    void shouldReadResponseCode() throws IOException {
        HttpServer server = new HttpServer(0);
        server.start();
        int port = server.getActualport();
        HttpClient client = new HttpClient("httpbin.org", 80 , "/hello");
        //HttpRespone respone = client.executeRequest();
        //assertEquals(200 , response.getResponseCode());

    }


    @Test
    void ShouldReturn404ForUnknownRequestTarget () throws IOException {
        HttpServer server = new HttpServer(10001);
        HttpClient client = new HttpClient("localHost" , 10001 , "/non-existing");
        assertEquals(404, client.getStatusCode());
    }
}
