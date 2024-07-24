package com.healthhistoryservice.demo.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.healthhistoryservice.demo.dao.HealthHistoryRepository;
import com.healthhistoryservice.demo.pojo.HealthHistoryEntity;
import com.healthhistoryservice.demo.util.HealthHistoryUtil;

@Component
public class Schedulerservice {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private HealthHistoryRepository myObjectRepository;
	
	
    @Scheduled(fixedRate = 10000) 
	public void scheduleTask()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String strDate = dateFormat.format(new Date());        
        
        HealthHistoryEntity healthHistory = new HealthHistoryEntity();
        try {
			healthHistory.setCpuUsage(HealthHistoryUtil.getCPUUsage());
			 healthHistory.setDiskUsage(HealthHistoryUtil.getDiskUsage());
		} catch (Exception exception) {			
			logger.error("Exception while fetching metric data :"+exception.getMessage());
		}
       
        healthHistory.setTimestamp(strDate);          
        
        myObjectRepository.save(healthHistory);      
        
        
        
    }
    
   
    
   

}
