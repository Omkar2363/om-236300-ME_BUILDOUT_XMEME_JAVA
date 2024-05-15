package com.crio.starter.repository;

import com.crio.starter.data.MemeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MemesRepository extends MongoRepository<MemeEntity, String> {
    
}
