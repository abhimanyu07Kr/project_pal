package com.abhi.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.Entity.PalData;

public interface PalRepo extends JpaRepository<PalData, Integer>{
	
	public PalData findByPalStr(String s);

}
