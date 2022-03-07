package com.diekinari.demo.controllers;

import com.diekinari.demo.entities.DecoderFile;
import com.diekinari.demo.entities.Image;
import com.diekinari.demo.entities.PicturesList;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("requests")
public class RequestingController {

    @GetMapping("userPics")
            public  @ResponseBody PicturesList someRequest() {
        String username = "diekinari";
        String url = "https://localhost:8081/SwipeDrop/userPics/" + username;
        RestTemplate restTemplate = new RestTemplate();
        PicturesList responseEntity = restTemplate.getForObject(url, PicturesList.class);
        return responseEntity;
    }


    @GetMapping("testUploadPics")
            public void someRequest_2() {
        byte[] bytes = new byte[5];
        String fileName = "some.jpg";

        String url = "https://localhost:8081/SwipeDrop/testUploadPics";
        String username = "diekinari";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE));
        headers.add("username", username);

        DecoderFile decoderFile = new DecoderFile(bytes, fileName);

        try {
            HttpEntity<?> request = new HttpEntity<>(decoderFile, headers);
            restTemplate.postForObject(url, request, DecoderFile.class);
        } catch(Exception e){
            System.out.println(e);
        }


    }


    @GetMapping("getPics")
        public  @ResponseBody  Image someRequest_3() {
            String fileName = "some.jpg";
            String username = "diekinari";
            String url = "https://localhost:8081/SwipeDrop/getPics/" + username + "?fileName=" + fileName;
            RestTemplate restTemplate = new RestTemplate();
            Image responseEntity = restTemplate.getForObject(url, Image.class);
            return responseEntity;
    }




}
