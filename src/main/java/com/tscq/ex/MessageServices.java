package com.tscq.ex;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("message")
/**
 * Created by johnson on 2016/12/10.
 */
public class MessageServices {
    @GET
    @Produces("application/json")
    public MessageResources getJAXB() {
        return new MessageResources("foo","bar");
    }

}
