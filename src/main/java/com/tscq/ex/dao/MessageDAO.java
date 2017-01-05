package com.tscq.ex.dao;

import com.tscq.ex.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;


/**e
 * Created by johnson on 3/01/2017.
 */
public class MessageDAO implements IMessageDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public int getCount(){
        String SQL = "select count(id) from messages";
        return jdbcTemplate.queryForObject(SQL, Integer.class);
    }

    public int createMessage(MessageDTO messageDTO){
        String SQL = "insert into messages (id, username, message, postedat) values (:id, :username, :message, :postedat)";

        Map<String, Serializable> namedParameters = new HashMap<String, Serializable>();
        namedParameters.put("id", messageDTO.getId());
        namedParameters.put("username", messageDTO.getUser());
        namedParameters.put("message", messageDTO.getMessage());
        namedParameters.put("postedat", messageDTO.getPostedAt());

        return namedParameterJdbcTemplate.update(SQL, namedParameters);
    }

    public List<MessageDTO> listMessages(int limit){
        String sql = "select * from messages order by postedat DESC LIMIT:limit";

        Map<String, Integer> namedParameters = new HashMap<String, Integer>();
        namedParameters.put("limit", limit);

        List<MessageDTO> msgList = namedParameterJdbcTemplate.query(sql, namedParameters, new MessageDTOMapper());

        return msgList;
    }
}

class MessageDTOMapper implements RowMapper<MessageDTO> {
    public MessageDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setId((UUID) rs.getObject("id"));
        messageDTO.setUser(rs.getString("username"));
        messageDTO.setMessage(rs.getString("message"));
        Timestamp t = rs.getTimestamp("postedat");
        messageDTO.setPostedAt(new Date(t.getTime()));
        return messageDTO;
    }
}