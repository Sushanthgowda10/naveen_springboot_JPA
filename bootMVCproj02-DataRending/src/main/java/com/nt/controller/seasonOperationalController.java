package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.ISeasonFinderService;

@Controller
public class seasonOperationalController {
	
	@Autowired
	private ISeasonFinderService service;
	
	@RequestMapping("/")
	public String showHome() {
		return "welcome";}
//		
//		@RequestMapping("/season")
//		public String showSeason(Map<String, Object>map) {
//			//Use Service 
//			String msg = service.findSeason();
//			
//			//keep the result in model Attributes
//			map.put("resultMsg", msg);
//			
//			
//			//Return LVN
//			return "display";
//		}
		
		@GetMapping("/report")
		public String sendData(Map<String,Object>map) {
			//put array.collectionns as the model attributes values
			
			map.put("favColors",new String[] {"red","green","yellow"});
			map.put("nickNames",List.of("raja","sush","ashi"));
			map.put("phoneNumber",Set.of(99999L,76543L,234567));
			map.put("idDetails",Map.of("aadarNo",345678,"voterId",21345678));
			//return LVN
			return "show_report";
			
		}
	
		

}
