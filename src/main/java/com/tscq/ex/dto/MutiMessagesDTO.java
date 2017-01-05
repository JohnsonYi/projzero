package com.tscq.ex.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by johnson on 28/12/2017.
 */
//@XmlRootElement
public class MutiMessagesDTO {
    public int count;
    public List<MessageDTO> messages;

    public MutiMessagesDTO() {}

    public MutiMessagesDTO(int count, List<MessageDTO> messages){
        this.count = count;
        this.messages = (messages != null) ? new LinkedList<MessageDTO>(messages) : null;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<MessageDTO> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageDTO> messages) {
        this.messages = messages;
    }
}
