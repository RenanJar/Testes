package com.ProvaJavaBHU.ProvaJavaBHU.repository;

import com.ProvaJavaBHU.ProvaJavaBHU.model.LogCarModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogCarRepository extends MongoRepository<LogCarModel,String> {
}
