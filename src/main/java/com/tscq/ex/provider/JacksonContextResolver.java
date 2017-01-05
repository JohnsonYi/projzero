package com.tscq.ex.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * Created by johnson on 28/12/2017.
 */
@Provider
public class JacksonContextResolver implements ContextResolver<ObjectMapper>{
    private final ObjectMapper mapper = new ObjectMapper();

    public JacksonContextResolver(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        mapper.setDateFormat(dateFormat);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    public ObjectMapper getContext(Class<?> objectType) {
        return mapper;
    }
}

/**
 *
 package com.tscq.ex.provider;

 import com.sun.jersey.api.json.JSONConfiguration;
 import com.sun.jersey.api.json.JSONJAXBContext;
 import com.tscq.ex.dto.MessageDTO;
 import com.tscq.ex.dto.MutiMessagesDTO;

 import javax.ws.rs.ext.ContextResolver;
 import javax.ws.rs.ext.Provider;
 import javax.xml.bind.JAXBContext;

 @Provider
 public class JABXContextResolver implements ContextResolver<JAXBContext> {
 private JAXBContext context;
 private Class[] types = { MutiMessagesDTO.class, MessageDTO.class };

 public JABXContextResolver() throws Exception{
 //this.context = new JSONJAXBContext(JSONConfiguration.natural().build(), types);
 this.context = new JSONJAXBContext(JSONConfiguration.mapped().arrays("msg").build(), types);
 }

 public JAXBContext getContext(Class<?> objectType){
 return (types[0].equals(objectType)) ? context : null;
 }

 }
 */
