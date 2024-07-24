package com.healthhistoryservice.demo.service;

import java.util.List;

import com.healthhistoryservice.demo.pojo.ApplicationHealth;

public interface HealthHistoryService {
	
	List<ApplicationHealth> getHistoricalData(String date);
	  
	List<ApplicationHealth> getHistoricalDataWithTimeRange(String startTime, String endTime);

}
