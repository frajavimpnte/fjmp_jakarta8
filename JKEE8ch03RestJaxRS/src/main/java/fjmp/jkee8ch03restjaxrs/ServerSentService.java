
package fjmp.jkee8ch03restjaxrs;

import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.sse.Sse;
import javax.ws.rs.sse.SseBroadcaster;
import javax.ws.rs.sse.SseEventSink;

/**
 *
 * @author FJMP <frajavimopu@gmail.com>
 */

// We started with our SSE engine, the ServerEvent class, and a JAX-RS 
// (short for JAVA API for RESTful Web Services) endpoint—We started with 
//  our SSE engine, the ServerEvent class, and a JAX-RS (short for JAVA API for RESTful Web Services) endpoint—
// 
// Following are the main points:
// >>This method will create and prepare an event to be sent by the server to the clients.
// >>Then, the newly-created event is put in a HashMap called POOL.
// >>Then, our event is attached to URI that represents another method in this same class (details are provided next).

@Path("serverSentService")
@RequestScoped
public class ServerSentService {
    private static final Map<Long, UserEvent> POOL = new ConcurrentHashMap<>();
    
    @Resource(name = "LocalManagedExecutorService")
    private ManagedExecutorService executor;
    
    @Path("start")
    @POST
    public Response start(@Context Sse sse) {
        final UserEvent process = new UserEvent(sse);
        
        POOL.put(process.getId(), process);
        executor.submit(process);
        
        final URI uri = UriBuilder.fromResource(ServerSentService.class)
                .path("register/{id}").build(process.getId());
        
        return Response.created(uri).build();
    }
    
    @Path("register/{id}")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @GET
    public void register(@PathParam("id") Long id,
            @Context SseEventSink sseEventSink) {
        final UserEvent process = POOL.get(id);
        
        if (process != null) {
            process.getSseBroadcaster().register(sseEventSink);
        } else {
            throw new NotFoundException();
        }
    }
    
    static class UserEvent implements Runnable {
        private final Long id;
        private final SseBroadcaster sseBroadcaster;
        private final Sse sse;
        
        UserEvent(Sse sse) {
            this.sse = sse;
            this.sseBroadcaster = sse.newBroadcaster();
            id = System.currentTimeMillis();
        }
        
        Long getId() {
            return id;
        }
        
        SseBroadcaster getSseBroadcaster() {
            return sseBroadcaster;
        }
        
        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(5);
                sseBroadcaster.broadcast(sse.newEventBuilder()
                   .name("register")
                   .data(String.class, "Text from event " + id)
                   .build()
                );
                sseBroadcaster.close();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
