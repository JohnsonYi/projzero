package com.tscq.ex.service.impl;

import com.tscq.ex.dao.Message;
import com.tscq.ex.service.IMessageService;

/**
 * Created by johnson on 14/12/2016.
 */
public class MessageServiceImpl implements IMessageService {
    public Message replyMessage(String user, String msg) {
        Message message = new Message();
        message.setUser(user);
        message.setMessage(msg);
        return message;
    }

}
