package com.apps;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HappyController {


    @Value("${welcome.msg}")
    private String welcomeMsg;


    @GetMapping("/")
    public ResponseEntity<?> info() {
        ResponseEntity<?> response = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        response = new ResponseEntity<String>(welcomeMsg, headers, HttpStatus.OK);
        return response;
    }


}
