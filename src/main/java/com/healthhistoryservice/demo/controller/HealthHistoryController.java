package com.healthhistoryservice.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthhistoryservice.demo.pojo.ApplicationHealth;
import com.healthhistoryservice.demo.service.HealthHistoryService;

@RestController
@RequestMapping("/api/health-history")
public class HealthHistoryController {
	
	
	  @Autowired 
	  HealthHistoryService healthService;
	  
	  @GetMapping("/applicationhealth/{date}") 
	  public List<ApplicationHealth>   retrieveApplicationHealth(@PathVariable(value = "date") String date){		   		   
		    return  healthService.getHistoricalData(date);
		  }
	  
	  @GetMapping("/dataWithTimeRange") 
	  public List<ApplicationHealth> getDataWithTimeRange(@RequestParam(name="startTime") String startTime, @RequestParam(name="endTime") String  endTime)
	  {     return healthService.getHistoricalDataWithTimeRange(startTime, endTime);
	  
	  }
	  
}
