package com.example.images.web.service;

import com.example.images.web.bom.Image;

public interface ImagesService {
    void addNewImage(Image image);

    String getRandomGIF();
}
