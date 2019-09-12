package com.example.images.dto.dao;

import com.example.images.dto.ImageDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagesRepository extends MongoRepository<ImageDto, String> {
    @Query("{ 'userId' : {$regex: ?0, $options: 'i' }}")
    ImageDto findByUserId(final String userId);
}
