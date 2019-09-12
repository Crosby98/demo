package com.example.images.web.converter;

import com.example.images.dto.ImageDto;
import com.example.images.web.bom.Image;
import org.springframework.stereotype.Component;

@Component
public class ImageConverter {

    public ImageDto toDto(Image source) {
        ImageDto destination = new ImageDto();
        destination.setImage(source.getImage());
        destination.setUserId(source.getUserId());
        return destination;
    }
}
