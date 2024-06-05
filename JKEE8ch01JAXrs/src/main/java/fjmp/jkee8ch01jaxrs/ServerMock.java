
package fjmp.jkee8ch01jaxrs;

import java.io.IOException;
import java.net.URI;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;


/**
 *
 * @author FJMP <frajavimopu@gmail.com>
 */
public class ServerMock {

    public static final URI CONTEXT = URI.create("http://localhost:8080/");
    public static final String BASE_PATH = "ssevents";

    public static void main(String[] args) {
        try {
            final ResourceConfig resourceConfig = new 
                    ResourceConfig(SseResource.class);

            final HttpServer server = 
            GrizzlyHttpServerFactory.createHttpServer(CONTEXT, 
            resourceConfig, false);
            server.start();

            System.out.println(String.format("Mock Server startedat %s%s", CONTEXT, BASE_PATH));

            /*
            Thread.currentThread().join() blocks the current thread forever. 
            In your example, that prevents the main from exiting, unless 
            the program is killed
            */
            Thread.currentThread().join();
        } catch (IOException | InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}