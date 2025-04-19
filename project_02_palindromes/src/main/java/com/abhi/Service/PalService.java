package com.abhi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.Entity.PalData;
import com.abhi.Repo.PalRepo;

@Service
public class PalService {
	
	@Autowired
	private PalRepo palRepo;
	
	
	public boolean palSave(PalData data)
	{
		 PalData p = palRepo.findByPalStr(data.getPalStr());
		 if(p==null)
		 {
			 palRepo.save(data);
			 return true;
		 }else
			return false;
	}
	
	public List<PalData> getAll()
	{
		return palRepo.findAll();
	}
	
	
	

}
