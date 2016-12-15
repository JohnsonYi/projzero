package com.tscq.ex.service;

//import com.sun.jersey.spi.resource.Singleton;

//@Singleton

import com.tscq.ex.dao.Message;

/**
 * Created by johnson on 2016/12/11.
 * Spring MessageService bean
 */
public interface MessageService {

    Message replyMessage(String user, String msg);


}
