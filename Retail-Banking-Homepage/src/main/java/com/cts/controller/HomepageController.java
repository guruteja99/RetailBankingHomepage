package com.cts.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cts.service.HomepageService;

@RestController
public class HomepageController {
	
	@Autowired
	private HomepageService service;
	
	@GetMapping("/{custId}")
	public Map<String,Object> getHomepage(@PathVariable("custId") long custId){
		Map<String,Object> map = new HashMap<>();
		map.put("accounts", service.getAccounts(custId));
		map.put("transactions",service.getTransactions(custId));
		map.put("creditScore", service.getCreditScore(custId));
		map.put("noOfRewards", service.getNoOfRewards(custId));
		return map;
	}

}
