package com.tscq.ex;

//import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("messages")
/**
 * Created by johnson on 2016/12/11.
 */
public class MessageResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessages() {
        Message message = new Message();
        message.setUser("foo");
        message.setMessage("bar");
        return message;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Message getMessage(Message message) {
        return message;
    }
    /**
     * This function also print json like output by string format
    public String getMessage(Message message) {
        return message.toString();
    }
     */

}


