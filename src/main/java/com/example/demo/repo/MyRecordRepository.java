package com.example.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.MyRecord;

public interface MyRecordRepository extends MongoRepository<MyRecord, String> {

}
