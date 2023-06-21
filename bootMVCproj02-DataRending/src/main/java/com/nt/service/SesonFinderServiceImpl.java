package com.nt.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service("seasonService")
public class SesonFinderServiceImpl implements ISeasonFinderService{
@Override
public String findSeason() {
	//Get system date
	LocalDate ld =LocalDate.now();
	
	// Get current month
	int month = ld.getMonthValue();
	
	//Find season
	if(month >= 7 && month <= 9)
		return "Rainy Season";
	
	else if(month>= 3 && month <= 6)
		return "summer Season";
	else 
		return "winter season";
	
}
}
