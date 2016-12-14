package com.tscq.ex;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;
import java.util.UUID;

//@XmlRootElement     //This statement will caused the json order mixed
/**
 * Created by johnson on 2016/12/11.
 * Message DTO class
 */
public class Message {
    private String id= UUID.randomUUID().toString();
    private String user;
    private String message;
    private String postedAt = DateFormatUtils.format(new Date(), "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    public Message() {}

    public Message(String user, String message) {
        this.user = user;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    /**
     * UUID should not be revised
    public void setId(String id) { this.id = id; }
     */

    //@JsonProperty(value="user")
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPostedAt() {
        return postedAt;
    }

    /**
     * postAt timestamp should not be revised
    public void setPostedAt(String postedAt) { this.postedAt = postedAt; }
     */

    //Format message object to json like output with string format
    @Override
    public String toString() {
        return new StringBuffer("{\"id\":\"").append(this.id)
                .append("\",\"user\":\"").append(this.user)
                .append("\",\"message\":\"").append(this.message)
                .append("\",\"postedAt\":\"").append(this.postedAt)
                .append("\"}").toString();
    }

}
