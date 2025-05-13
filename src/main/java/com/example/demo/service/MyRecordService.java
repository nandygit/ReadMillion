package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.MyRecord;
import com.example.demo.repo.MyRecordRepository;

@Service
public class MyRecordService {
	
	@Autowired
	private MyRecordRepository repository;

	public void insertMillionRecords() {
		List<MyRecord> batch = new ArrayList<>();
		int batchSize = 10000;

		for (int i = 1; i <= 1_000_000; i++) {
			batch.add(new MyRecord("Name_" + i, i));
			if (i % batchSize == 0) {
				repository.saveAll(batch);
				batch.clear();
				System.out.println("Inserted: " + i);
			}
		}
		if (!batch.isEmpty()) {
			repository.saveAll(batch);
		}
		System.out.println("Finished inserting 1 million records.");
	}
	
	 public List<MyRecord> getAllRecords() {
	        return repository.findAll();
	    }

}
