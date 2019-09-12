package com.example.api.web.сlient;

import com.example.bom.Image;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "demo-api-images")
public interface ImagesServiceClient {
        @RequestMapping(method = RequestMethod.POST, value = "/image", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
        void addNewImage(@RequestBody Image image, @RequestHeader("Authorization") String authHeader);
}
