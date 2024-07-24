package com.healthhistoryservice.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthhistoryservice.demo.dao.HealthHistoryRepository;
import com.healthhistoryservice.demo.pojo.ApplicationHealth;
import com.healthhistoryservice.demo.pojo.HealthHistoryEntity;
import com.healthhistoryservice.demo.service.HealthHistoryService;

@Service
public class HealthHistoryServiceImpl implements HealthHistoryService {
	
	
	@Autowired
	HealthHistoryRepository healthHistoryRepository;	
	

	@Override
	public List<ApplicationHealth> getHistoricalData(String date) {		
		List<ApplicationHealth> applicationhealthData = new ArrayList<>();			
		List<HealthHistoryEntity>  healthData = healthHistoryRepository.findBytimestamp(date);		
		for(HealthHistoryEntity entity : healthData) {
			ApplicationHealth health = new ApplicationHealth();
			health.setCpuUsage(entity.getCpuUsage());
			health.setDiskUsage(entity.getDiskUsage());
			applicationhealthData.add(health);			
		}
		
		return applicationhealthData;
	}

	@Override
	public List<ApplicationHealth> getHistoricalDataWithTimeRange(String startTime, String endTime) {		
		List<ApplicationHealth> applicationhealthData = new ArrayList<>();		
		List<HealthHistoryEntity>  healthData = healthHistoryRepository.findBytimestampBetween(startTime,endTime);
		for(HealthHistoryEntity entity : healthData) {
			ApplicationHealth health = new ApplicationHealth();
			health.setCpuUsage(entity.getCpuUsage());
			health.setDiskUsage(entity.getDiskUsage());
			applicationhealthData.add(health);			
		}
		
		return applicationhealthData;
	}

}
