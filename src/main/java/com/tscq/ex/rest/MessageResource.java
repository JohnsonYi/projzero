package com.tscq.ex.rest;

import com.tscq.ex.dao.Message;
import com.tscq.ex.service.IMessageService;
//import com.tscq.ex.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Component
@Path("messages")
/**
 * Created by johnson on 2016/12/11.
 */
public class MessageResource {

    @Autowired
    private IMessageService messageService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessages() {
        //messageService = new MessageServiceImpl();
        return messageService.replyMessage("foo", "bar");
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Message postMessage(Message message) { return message; }
    /**
     * This function also print json like output by string format
    public String getMessage(Message message) {
        return message.toString();
    }
     */

}


