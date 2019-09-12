package com.example.images.dto;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "images")
public class ImageDto {

    @Id
    @Transient
    public ObjectId id;

    @Indexed
    public String userId;

    public byte[] image;

    @Override
    public String toString() {
        return String.format(
                "Image[id=%s, userId='%s', image='%s']",
                id, userId, image);
    }
}
