package com.nagarro.restbackApi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.restbackApi.Models.Batch;
import com.nagarro.restbackApi.repository.BatchRepository;

@Service
public class BatchService {
	
	@Autowired
	private BatchRepository batchRepository;
	
	public List<Batch> getAllBatches() {
		// TODO Auto-generated method stub
		return batchRepository.findAll();
	}

	public void addBatch(Batch batch) {
		// TODO Auto-generated method stub
		if (batch.getBatchId().equals("") || batch.getBatchId()== null) {
			batch.setBatchId(batch.generateBatchId());
		}
		batchRepository.save(batch);
		
	}

	public void updateBatch(String id, Batch newBatch) {
		// TODO Auto-generated method stub
		Batch old=batchRepository.getOne(id);
		if(old!=null) 
		{
			if(newBatch.getTechnology().equals(""))
			{
				newBatch.setTechnology(old.getTechnology());
				//System.out.println(newLevel.getLevelName());
			}
			if(newBatch.getBatchDescription().equals(""))
			{
				newBatch.setBatchDescription(old.getBatchDescription());
				//System.out.println(newLevel.getQualifyPoints());
			}
			if(newBatch.getYear().equals(""))
			{
				newBatch.setYear(old.getYear());
				//System.out.println(newLevel.getLevelDesc());
			}
			newBatch.setBatchId(old.getBatchId());
			newBatch.setStartDate(old.getStartDate());
			batchRepository.save(newBatch);
		}
		else {
			System.out.println("Error ");
		}
		
	}

	public void deleteBatch(String id) {
		// TODO Auto-generated method stub
		Batch old=batchRepository.getOne(id);
		System.out.println();
		batchRepository.delete(old);
	}

	public Batch getBatchById(String id) {
		// TODO Auto-generated method stub
		return batchRepository.findById(id).get();
	}
	
	
}
