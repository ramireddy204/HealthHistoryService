package com.healthhistoryservice.demo.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "HealthHistory")
public class HealthHistoryEntity {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    private String timestamp;

	    private Double cpuUsage;

	    private Double diskUsage;  
	    
	    

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		
		public String getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(String timestamp) {
			this.timestamp = timestamp;
		}

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
