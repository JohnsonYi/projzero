package com.tscq.ex;

import org.apache.commons.lang3.time.DateFormatUtils;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.UUID;

@XmlRootElement
/**
 * Created by johnson on 2016/12/10.
 */
public class MessageResources {
    public String id;
    public String user;
    public String messages;
    public String postedAt;

    public MessageResources() {}
    public MessageResources(String user, String messages){
        this.id = UUID.randomUUID().toString();
        this.user = user;
        this.messages = messages;
        this.postedAt = DateFormatUtils.format(new Date(), "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    }
}
