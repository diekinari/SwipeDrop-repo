package com.diekinari.demo.controllers;

import com.diekinari.demo.database.Picture;
import com.diekinari.demo.database.User;
import com.diekinari.demo.entities.DecoderFile;
import com.diekinari.demo.entities.Image;
import com.diekinari.demo.entities.PicturesList;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path = "SwipeDrop")
public class MainController {
    public User user = new User(new HashMap<>());


    @PostMapping(path = "testUploadPics", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void uploadPics(@RequestBody DecoderFile decoderFile, @RequestHeader String username) throws IOException {
        if (user.fileMap != null && user.fileMap.containsKey(username)){
            if(user.fileMap.get(username).pictureMap.containsKey(decoderFile.getFileName())){
                user.fileMap.get(username).pictureMap.replace(decoderFile.getFileName(), decoderFile.getBytes());
            } else {
                user.fileMap.get(username).pictureMap.put(decoderFile.getFileName(), decoderFile.getBytes());
            }

        } else {
            if (user.fileMap != null && decoderFile.getFileName() != null && decoderFile.getBytes() != null) {
                user.fileMap.put(username, new Picture());
                user.fileMap.get(username).pictureMap = new HashMap<>();
                user.fileMap.get(username).pictureMap.put(decoderFile.getFileName(), decoderFile.getBytes());
            }
        }
    }


    @GetMapping("userPics/{name}")
        public  @ResponseBody PicturesList getAvailablePics(@PathVariable String name){
        List<String> mapKeys = new ArrayList<>();
            if (user.fileMap != null && user.fileMap.containsKey(name)) {
                mapKeys.addAll(user.fileMap.get(name).pictureMap.keySet());
            }else {
                mapKeys.add("List is empty");
            }
        return new PicturesList(mapKeys);
    }


    @GetMapping(value = "getPics/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
        public @ResponseBody Image getPicture(@PathVariable String username, @RequestParam(value = "fileName") String fileName){
            return new Image(user.fileMap.get(username).pictureMap.get(fileName));

    }

}
