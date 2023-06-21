package com.nt.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class LinkServiceImpl implements ILinkService{

	@Override
	public String generateWishMessage() {
		
		//get system date and time
		LocalDateTime idt = LocalDateTime.now();
		
		//get current hour of the day
		int hour= idt.getHour();
		
		if(hour<12)
		return "GoodMorning";
		
		else if(hour<16)
			return "GoodAfternoon";
		

		else if(hour<20)
			return "GoodEvening";
		else
			return "GoodNight";
				
		
		
	}

	@Override
	public Set<String> fetchAllLanguages() {
		Locale[] locales= Locale.getAvailableLocales();
		HashSet<String>langSet = new HashSet<String>();
		for (Locale l : locales) {
			langSet.add(l.getDisplayLanguage());
		}
		return langSet;
	}

}
