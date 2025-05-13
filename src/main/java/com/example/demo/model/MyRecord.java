package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("my_records")
public class MyRecord {

	   @Id
	    private String id;
	    private String name;
	    private int value;

	    public MyRecord() {}

	    public MyRecord(String name, int value) {
	        this.name = name;
	        this.value = value;
	    }

}
