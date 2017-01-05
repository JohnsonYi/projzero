package com.tscq.ex.service;

//import com.sun.jersey.spi.resource.Singleton;

//@Singleton

import com.tscq.ex.dto.MessageDTO;

/**
 * Created by johnson on 2016/12/11.
 * Spring MessageService bean
 */
public interface IMessageService {

    MessageDTO replyMessage(String user, String msg);

}
