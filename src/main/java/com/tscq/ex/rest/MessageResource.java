package com.tscq.ex.rest;

//import com.tscq.ex.dto.Message;
import com.tscq.ex.dto.MessageDTO;
import com.tscq.ex.dto.MutiMessagesDTO;
//import com.tscq.ex.provider.JABXContextResolver;
import com.tscq.ex.service.IMessageService;
//import com.tscq.ex.service.impl.MessageServiceImpl;
//import com.tscq.ex.dto.MutiMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
//import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;

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
    /**
    public Message getMessages() {
        //messageService = new MessageServiceImpl();
        return messageService.replyMessage("foo", "bar");
    }
     */
    public MutiMessagesDTO getMessages(@QueryParam("limit") int limit) {
        if(limit <= 0 ) {
            return null;
        }
        final MessageDTO[] msg = {new MessageDTO("foo", "bar")};
        MutiMessagesDTO mutimsg = new MutiMessagesDTO(2, Arrays.asList(msg));
        mutimsg.messages.add(new MessageDTO("foo","bar"));
        return mutimsg;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public MessageDTO postMessage(MessageDTO message) { return message; }
    /**
     * This function also print json like output by string format
    public String getMessage(Message message) {
        return message.toString();
    }
     */

}


