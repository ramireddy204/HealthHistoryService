package com.healthhistoryservice.demo.pojo;

import org.springframework.stereotype.Component;

@Component
public class ApplicationHealth {
	
	    private Double cpuUsage;

	    private Double diskUsage;

		public Double getCpuUsage() {
			return cpuUsage;
		}

		public void setCpuUsage(Double cpuUsage) {
			this.cpuUsage = cpuUsage;
		}

		public Double getDiskUsage() {
			return diskUsage;
		}

		public void setDiskUsage(Double diskUsage) {
			this.diskUsage = diskUsage;
		}
	    
	    
	    

}
