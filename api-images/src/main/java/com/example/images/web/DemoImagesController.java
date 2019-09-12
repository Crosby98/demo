package com.example.images.web;

import com.example.images.web.bom.Image;
import com.example.images.web.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoImagesController {

    @Autowired
    private ImagesService imagesService;

    @RequestMapping(value = "/image", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<String> addNewImage(@RequestBody Image image) {
        imagesService.addNewImage(image);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/GIF", method = RequestMethod.GET)
    public ModelAndView getRandomGIF(ModelMap model) {
        String randomGIF = imagesService.getRandomGIF();
        return new ModelAndView("redirect:" + randomGIF, model);
    }
}
