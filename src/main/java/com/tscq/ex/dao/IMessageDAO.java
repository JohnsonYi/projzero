package com.tscq.ex.dao;

import com.tscq.ex.dto.MessageDTO;

import java.util.List;

/**
 * Created by johnson on 03/01/2017.
 */
public interface IMessageDAO {

    int getCount();
    int createMessage(MessageDTO messageDTO);
    List<MessageDTO> listMessages(int limit);
}
