package com.healthhistoryservice.demo.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HealthHistoryUtil {	
	
	 
		
	public static double getCPUUsage() throws JSONException {
    	double cpuUsage = 0.0D; 		   
        String response = getMetricResponse(ApplicationConstants.METRICS_SERVICE_URL);       
        
        
			JSONObject jsonObject = new JSONObject(response);
			JSONArray measurements = jsonObject.getJSONArray(ApplicationConstants.API_MEASUREMENTS);
			for (int i = 0; i < measurements.length(); i++) {
				JSONObject metricName = measurements.getJSONObject(i);
				cpuUsage= Math.ceil(metricName.getDouble(ApplicationConstants.API_VALUE));	
			}			
			
		
        
        return cpuUsage;
    }
    
    public static double getDiskUsage() throws JSONException {
    	long diskFree = 0L;
    	long diskTotal = 0L; 
    	double diskUsagePercentage = 0.0D;
    	String diskFreeresponse  = getMetricResponse(ApplicationConstants.DISK_FREE_SERVICE_URL);  	   
        String diskTotalresponse = getMetricResponse(ApplicationConstants.DISK_TOTAL_SERVICE_URL); 
        
        
      
			JSONObject diskFreeJson = new JSONObject(diskFreeresponse);
			JSONArray diskFreeMeasurements = diskFreeJson.getJSONArray(ApplicationConstants.API_MEASUREMENTS);
			for (int i = 0; i < diskFreeMeasurements.length(); i++) {
				JSONObject metricName = diskFreeMeasurements.getJSONObject(i);
				diskFree=  metricName.getLong(ApplicationConstants.API_VALUE);						
				break;
			}
			
			JSONObject diskTotalJson = new JSONObject(diskTotalresponse);
			JSONArray diskTotalMeasurements = diskTotalJson.getJSONArray(ApplicationConstants.API_MEASUREMENTS);
			for (int i = 0; i < diskTotalMeasurements.length(); i++) {
				JSONObject metricName = diskTotalMeasurements.getJSONObject(i);
				diskTotal=  metricName.getLong(ApplicationConstants.API_VALUE);					
				break;
			}
			
			diskUsagePercentage = Math.ceil((double) (diskTotal - diskFree) / diskTotal * 100);
			
		
        
        return  diskUsagePercentage ;
    }
    
    
    public static String getMetricResponse(String serviceURL) {
    	RestTemplate restTemplate = new RestTemplate();
    	String response = restTemplate.getForObject(serviceURL, String.class);   	
    	return response;    	
    }

}
