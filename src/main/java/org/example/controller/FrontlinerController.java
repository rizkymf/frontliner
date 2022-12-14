package org.example.controller;

import org.example.service.MessageProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FrontlinerController {

    @Autowired
    MessageProcess messageProcess;

    @PostMapping("/post-message")
    public ResponseEntity postMessage(@RequestBody Map<String, Object> body) {
        Map<String, Object> response = new HashMap<>();
        try{
            if(body.containsKey("message")) {
                String result = messageProcess.process(body);
                System.out.println(body.get("message"));
                response.put("status", "Success");
                response.put("message", "Message Sent Successfully");
            } else {
                throw new Exception("Heh!");
            }
//            if(!result.equals("OK")) throw new Exception();
        } catch(Exception e) {
            response.put("status", "Failed");
            response.put("message", e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
