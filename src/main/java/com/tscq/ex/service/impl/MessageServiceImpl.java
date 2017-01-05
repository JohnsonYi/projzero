package com.tscq.ex.service.impl;

import com.tscq.ex.dto.MessageDTO;
import com.tscq.ex.service.IMessageService;

/**
 * Created by johnson on 14/12/2016.
 */
public class MessageServiceImpl implements IMessageService {
    public MessageDTO replyMessage(String user, String msg) {
        MessageDTO message = new MessageDTO();
        message.setUser(user);
        message.setMessage(msg);
        return message;
    }
    /**
    public Message arrayMessage(String user, String msg) {
        List msgList = new ArrayList();
        ArrayList <Message> messages = new ArrayList<Message>();
        msgList.add(new Message(user, msg));
        msgList.add(new Message(user, msg));

        JsonArray result = msgList;
        return null;
    }
     */

}
