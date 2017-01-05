package com.tscq.ex.dto;

import java.util.Date;
import java.util.UUID;

//@XmlRootElement     //This statement will caused the json order mixed
/**
 * Created by johnson on 2016/12/11.
 * Message DTO class
 */
//@XmlRootElement
public class MessageDTO {
    private UUID id = UUID.randomUUID();
    private String user;
    private String message;
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Date postedAt = new Date();   //DateFormatUtils.format(new Date(), "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    public MessageDTO() {}

    public MessageDTO(String user, String message) {
        this.user = user;
        this.message = message;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) { this.id = id; }

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

    public Date getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Date postedAt) { this.postedAt = postedAt; }

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
