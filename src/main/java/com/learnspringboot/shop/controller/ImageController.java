package com.learnspringboot.shop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author tamvo
 * @created 15/02/2020 - 3:33 PM
 */

@Controller
public class ImageController {

    @RequestMapping(value = "/images/{name}", method = RequestMethod.GET,  produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable("name") String name) throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/images/" + name);
        if (inputStream == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        byte[] bytes = StreamUtils.copyToByteArray(inputStream);
        return new ResponseEntity<>(bytes, HttpStatus.OK);
    }
}
