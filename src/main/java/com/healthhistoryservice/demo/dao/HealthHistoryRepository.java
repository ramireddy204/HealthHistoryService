package com.healthhistoryservice.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.healthhistoryservice.demo.pojo.HealthHistoryEntity;

@Repository
public interface HealthHistoryRepository extends JpaRepository<HealthHistoryEntity, Long> {
	
	
	@Query("FROM HealthHistoryEntity WHERE timestamp LIKE CONCAT('%',?1,'%')")	
	List<HealthHistoryEntity> findBytimestamp(@Param("timestamp")String timestamp);
	
	@Query("SELECT h FROM HealthHistoryEntity h WHERE h.timestamp BETWEEN :from AND :to")
	List<HealthHistoryEntity> findBytimestampBetween(@Param("from") String from, @Param("to") String to);
	
	

}
