package com.example.json.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObjectMapperController {
   @GetMapping("/convert")
    public String convert() throws JsonProcessingException {

        User user=new User();
        user.setId(1);
       user.setName("kelly");
       user.setContactEmail("test.com");

        ObjectMapper objectMapper=new ObjectMapper();
        //將User ->json 字串
        String jsonResult=objectMapper.writeValueAsString(user);
        System.out.println("json value is:"+jsonResult);
        //將json 字串->User
        String json="{\"" +
                "id\":1,\"name\":\"kelly\"," +
                "\"age\":20," +
                "\"contact-email\":\"hello@gamil.com\"}";

        User userResult=objectMapper.readValue(json,User.class);

       System.out.println("Userid value is: "+userResult.getId());
       System.out.println("Username value is: "+userResult.getName());
       System.out.println("UserEmail value is: "+userResult.getContactEmail());
       return "covert success";

    }
}
