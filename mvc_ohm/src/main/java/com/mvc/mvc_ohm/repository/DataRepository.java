package com.mvc.mvc_ohm.repository;


import com.mvc.mvc_ohm.entity.DataCPUEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataRepository extends JpaRepository<DataCPUEntity,Integer> {


    DataCPUEntity findFirstByOrderByTimeDesc();
    List<DataCPUEntity> findTop15ByOrderByTimeDesc();
}
