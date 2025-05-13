package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MyRecord;
import com.example.demo.service.MyRecordService;

@RequestMapping("/records")
@RestController
public class MyRecordController {

	@Autowired
	private MyRecordService myRecordService;
	
	@PostMapping("/generate")
	public String generateData() {

		long start = System.currentTimeMillis();

		myRecordService.insertMillionRecords();
		
		long end = System.currentTimeMillis();
		long timeTaken = end - start;

		return "Inserted 1 million records in " + timeTaken + " milli seconds";

	}
	
	@GetMapping("/all")
	public RecordResponse getAllRecords() {
		long start = System.currentTimeMillis();
		
		List<MyRecord> records = myRecordService.getAllRecords();
		
		long end = System.currentTimeMillis();
		long timetaken =  end - start;
		return new	RecordResponse(records.size(),timetaken);
	}

	public static class RecordResponse {
        private int totalRecords;
        private long timeInMillis;
        private long timeInSeconds;

        public RecordResponse(int totalRecords, long timeInMillis) {
            this.totalRecords = totalRecords;
            this.timeInMillis = timeInMillis;
            this.timeInSeconds=timeInMillis/1000;
        }

        public int getTotalRecords() {
            return totalRecords;
        }

        public long getTimeInMillis() {
            return timeInMillis;
        }
        public long getTimeInSeconds() {
            return timeInSeconds;
        }
    }
}
