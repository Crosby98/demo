package com.example.bom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Image {

    @Getter
    @Setter
    public Long userId;

    @Getter
    @Setter
    public byte[] image;
}

